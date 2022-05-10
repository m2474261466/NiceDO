package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.MailUtil;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.WorkTicket;
import com.ruoyi.system.domain.WorkTicketHistory;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IWorkTicketHistoryService;
import com.ruoyi.system.service.IWorkTicketService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * 完成工单Controller
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/system/my")
public class MyTicketController extends BaseController
{
    private String prefix = "system/ticket";

    @Autowired
    private IWorkTicketService workTicketService;
    @Autowired
    private IWorkTicketHistoryService iWorkTicketHistoryService;
    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("system:my:view")
    @GetMapping()
    public String ticket()
    {
        return prefix + "/my";
    }

    /**
     * 查询工单列表
     */
    @RequiresPermissions("system:ticket:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkTicket workTicket)
    {
        //获取用户id
        Long userId = getUserId();
        workTicket.settHandlerUserId(userId);
        workTicket.settState(0);
        startPage();
        List<WorkTicket> list = workTicketService.selectWorkTicketList(workTicket);
        return getDataTable(list);
    }

    /**
     * 导出工单列表
     */
    @RequiresPermissions("system:ticket:export")
    @Log(title = "工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTicket workTicket)
    {
        List<WorkTicket> list = workTicketService.selectWorkTicketList(workTicket);
        ExcelUtil<WorkTicket> util = new ExcelUtil<WorkTicket>(WorkTicket.class);
        return util.exportExcel(list, "工单数据");
    }

    /**
     * 新增工单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工单
     */
    @RequiresPermissions("system:ticket:add")
    @Log(title = "工单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkTicket workTicket)
    {
        return toAjax(workTicketService.insertWorkTicket(workTicket));
    }

    /**
     * 修改工单
     */
    @RequiresPermissions("system:ticket:edit")
    @GetMapping("/edit/{tId}")
    public String edit(@PathVariable("tId") Long tId, ModelMap mmap)
    {
        WorkTicket workTicket = workTicketService.selectWorkTicketByTId(tId);
        mmap.put("workTicket", workTicket);
        return prefix + "/edit";
    }

    /**
     * 完成工单
     */
    @RequiresPermissions("system:my:success")
    @PostMapping("/success")
    @ResponseBody
    public AjaxResult success(Long id)
    {
        //获取用户id
        Long userId = getUserId();
        WorkTicket workTicket = workTicketService.selectWorkTicketByTId(id);
        WorkTicketHistory workTicketHistory = new WorkTicketHistory();
        //判断工单类型

        //如果为流转工单  直接完成
        if (workTicket.gettType()==0){
            workTicket.settState(1);
            //写入历史记录
            //添加工单id
            workTicketHistory.sethWorkId(workTicket.gettId());
            //添加修改时间
            workTicketHistory.sethUpdateTime(new Date(System.currentTimeMillis()));
            //添加处理人id
            workTicketHistory.sethHandlerUserId(userId);
            //添加上一处理人id
            workTicketHistory.sethLastUserId(workTicket.gettCreateUserId());
            //储存历史记录
            iWorkTicketHistoryService.insertWorkTicketHistory(workTicketHistory);
             workTicketService.updateWorkTicket(workTicket);

        }else{
            //协同工单
            //查询是否存在历史记录表
            workTicketHistory.sethWorkId(workTicket.gettId());
            List<WorkTicketHistory> workTicketHistories = iWorkTicketHistoryService.selectWorkTicketHistoryList(workTicketHistory);
            if (workTicketHistories==null||workTicketHistories.size()==0){
                //第一人完成
                //添加工单id
                workTicketHistory.sethWorkId(workTicket.gettId());
                //添加修改时间
                workTicketHistory.sethUpdateTime(new Date(System.currentTimeMillis()));
                //添加处理人id
                workTicketHistory.sethHandlerUserId(userId);
                //添加上一处理人id
                workTicketHistory.sethLastUserId(workTicket.gettCreateUserId());
                //添加下一处理者id
                //判断是否存在下一处理者
                String userList = workTicket.gettUserList();
                String[] split = userList.split(",");
                Integer index =0;
                for (int i1 = 0; i1 < split.length; i1++) {
                    long s =  Long.parseLong( split[i1]);
                    if (s==userId){
                        index=i1;
                    }
                }
                if (index+1<split.length){
                    //存在下一个人
                    //发送邮件到下一人
                    //查询用户信息
                    MailUtil mailUtil = MailUtil.getMailUtil();
                    SysUser sysUser = iSysUserService.selectUserById(Long.parseLong(split[index + 1]));
                    mailUtil.sendEmail(sysUser.getEmail());
                    //储存历史记录
                    workTicketHistory.sethNextUserId(Long.parseLong(split[index+1]));
                    iWorkTicketHistoryService.insertWorkTicketHistory(workTicketHistory);
                    //储存工单最新状态
                    workTicket.settHandlerUserId(Long.parseLong(split[index + 1]));
                    workTicketService.updateWorkTicket(workTicket);
                }else{

                    //储存历史记录
                    //不存在下一个人  存储工单为已完成
                    workTicket.settState(1);
                    workTicketService.updateWorkTicket(workTicket);
                    iWorkTicketHistoryService.insertWorkTicketHistory(workTicketHistory);
                }

            }else{
                //不是第一人完成
                //添加工单id
                workTicketHistory.sethWorkId(workTicket.gettId());
                //添加修改时间
                workTicketHistory.sethUpdateTime(new Date(System.currentTimeMillis()));
                //添加处理人id
                workTicketHistory.sethHandlerUserId(userId);
                //添加上一处理人id

                //查询上一记录
                WorkTicketHistory workTicketHistory1 = new WorkTicketHistory();
                workTicketHistory1.sethNextUserId(userId);
                List<WorkTicketHistory> workTicketHistories1 = iWorkTicketHistoryService.selectWorkTicketHistoryList(workTicketHistory1);
                workTicketHistory.sethLastUserId(workTicketHistories1.get(0).gethHandlerUserId());

                //添加下一处理者id
                //判断是否存在下一处理者
                String userList = workTicket.gettUserList();
                String[] split = userList.split(",");
                Integer index =0;
                for (int i1 = 0; i1 < split.length; i1++) {
                    long s =  Long.parseLong( split[i1]);
                    if (s==userId){
                        index=i1;
                    }
                }
                if (index+1<split.length){
                    //存在下一个人
                    //发送邮件到下一人
                    //查询用户信息
                    MailUtil mailUtil = MailUtil.getMailUtil();
                    SysUser sysUser = iSysUserService.selectUserById(Long.parseLong(split[index + 1]));
                    mailUtil.sendEmail(sysUser.getEmail());
                    //储存历史记录
                    workTicketHistory.sethNextUserId(Long.parseLong(split[index+1]));
                    iWorkTicketHistoryService.insertWorkTicketHistory(workTicketHistory);
                    //储存工单最新状态
                    workTicket.settHandlerUserId(Long.parseLong(split[index + 1]));
                    workTicketService.updateWorkTicket(workTicket);
                }else{
                    //不存在下一个人  存储工单为已完成
                    workTicket.settState(1);
                    workTicketService.updateWorkTicket(workTicket);
                    //储存历史记录
                    iWorkTicketHistoryService.insertWorkTicketHistory(workTicketHistory);
                }
            }
        }

        return toAjax(1);
    }

    /**
     * 修改保存工单
     */
    @RequiresPermissions("system:ticket:edit")
    @Log(title = "工单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkTicket workTicket)
    {
        return toAjax(workTicketService.updateWorkTicket(workTicket));
    }

    /**
     * 删除工单
     */
    @RequiresPermissions("system:ticket:remove")
    @Log(title = "工单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workTicketService.deleteWorkTicketByTIds(ids));
    }
}
