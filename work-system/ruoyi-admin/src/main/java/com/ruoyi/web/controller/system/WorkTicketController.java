package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.WorkTicket;
import com.ruoyi.system.domain.WorkTicketHistory;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IWorkTicketHistoryService;
import com.ruoyi.system.service.IWorkTicketService;
import com.ruoyi.web.controller.response.HistoryResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 工单Controller
 *
 * @author ruoyi
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/system/ticket")
public class WorkTicketController extends BaseController {
    private String prefix = "system/ticket";

    @Autowired
    private IWorkTicketService workTicketService;

    @Autowired
    private IWorkTicketHistoryService iWorkTicketHistoryService;

    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("system:ticket:view")
    @GetMapping()
    public String ticket() {
        return prefix + "/ticket";
    }

    @RequiresPermissions("system:ticket:radio")
    @GetMapping("/radio")
    public String radio(Long id,ModelMap mmap) {
        mmap.put("id", id);
        return prefix + "/radio";
    }

    /**
     * 查询工单列表
     */
    @RequiresPermissions("system:ticket:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkTicket workTicket) {
        startPage();
        List<WorkTicket> list = workTicketService.selectWorkTicketList(workTicket);
        return getDataTable(list);
    }

    /**
     * 统计工单完成情况
     */
    @RequiresPermissions("system:ticket:ifsuccess")
    @PostMapping("/ifsuccess")
    @ResponseBody
    public ArrayList<HashMap<String,Object>> ifsuccess() {

        return workTicketService.selectWorkTicketifsuccess();

    }


    /**
     * 导出工单列表
     */
    @RequiresPermissions("system:ticket:export")
    @Log(title = "工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTicket workTicket) {
        List<WorkTicket> list = workTicketService.selectWorkTicketList(workTicket);
        ExcelUtil<WorkTicket> util = new ExcelUtil<WorkTicket>(WorkTicket.class);
        return util.exportExcel(list, "工单数据");
    }

    /**
     * 新增工单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存工单
     */
    @RequiresPermissions("system:ticket:add")
    @Log(title = "工单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkTicket workTicket) {
        return toAjax(workTicketService.insertWorkTicket(workTicket));
    }

    /**
     * 修改工单
     */
    @RequiresPermissions("system:ticket:edit")
    @GetMapping("/edit/{tId}")
    public String edit(@PathVariable("tId") Long tId, ModelMap mmap) {
        WorkTicket workTicket = workTicketService.selectWorkTicketByTId(tId);
        mmap.put("workTicket", workTicket);
        return prefix + "/edit";
    }

    /**
     * 修改保存工单
     */
    @RequiresPermissions("system:ticket:edit")
    @Log(title = "工单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkTicket workTicket) {
        return toAjax(workTicketService.updateWorkTicket(workTicket));
    }

    /**
     * 删除工单
     */
    @RequiresPermissions("system:ticket:remove")
    @Log(title = "工单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(workTicketService.deleteWorkTicketByTIds(ids));
    }


    /**
     * 历史记录
     */
    @PostMapping("/history")
    @ResponseBody
    public TableDataInfo history(Long id) {
        WorkTicket workTicket = workTicketService.selectWorkTicketByTId(id);
        ArrayList<HistoryResponse> historyResponses = new ArrayList<>();

        WorkTicketHistory workTicketHistory = new WorkTicketHistory();
        workTicketHistory.sethWorkId(id);
        List<WorkTicketHistory> workTicketHistories = iWorkTicketHistoryService.selectWorkTicketHistoryList(workTicketHistory);
        HistoryResponse historyResponse = new HistoryResponse();
        historyResponse.setMessage("创建工单");
        historyResponse.sethUpdateTime(workTicket.gettCreateTime());

        SysUser sysUser = iSysUserService.selectUserById(workTicket.gettCreateUserId());
        historyResponse.sethHandlerUserName(sysUser.getUserName());
        historyResponses.add(historyResponse);

        HistoryResponse historyResponse1 = new HistoryResponse();
        for (int i = 0; i < workTicketHistories.size(); i++) {
            WorkTicketHistory workTicketHistory1 = workTicketHistories.get(i);
            historyResponse1.setMessage("更新订单");
            historyResponse1.sethUpdateTime(workTicketHistory1.gethUpdateTime());
            Long aLong = workTicketHistory1.gethHandlerUserId();
            SysUser sysUser1 = iSysUserService.selectUserById(aLong);
            historyResponse1.sethHandlerUserName(sysUser1.getUserName());
            historyResponses.add(historyResponse1);
            historyResponse1=new HistoryResponse();
        }
        return getDataTable(historyResponses);
    }
}
