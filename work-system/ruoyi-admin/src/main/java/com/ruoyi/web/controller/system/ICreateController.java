package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MailUtil;
import com.ruoyi.system.domain.WorkTicket;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IWorkTicketService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 工单Controller
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/system/lcreate")
public class ICreateController extends BaseController
{
    private String prefix = "system/lcreate";

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private IWorkTicketService workTicketService;

    @RequiresPermissions("system:lcreate:view")
    @GetMapping()
    public String ticket(ModelMap mmap)
    {
        List<SysUser> sysUsers = iSysUserService.selectAllUser();
        mmap.put("user",sysUsers);
        return prefix + "/lcreate";
    }

    /**
     * 新增保存工单
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkTicket workTicket)
    {
        //获取处理人id并赋值
        Long userId = getUserId();
        workTicket.settCreateUserId(userId);
        //获取系统时间
        Date nowDate = DateUtils.getNowDate();
        workTicket.settCreateTime(nowDate);
        //获取第一位处理人并赋值
        workTicket.settHandlerUserId(workTicket.gettUserId());
        //获取处理人并发送邮件
        Long aLong = workTicket.gettUserId();
        SysUser sysUser = iSysUserService.selectUserById(aLong);
        //发送邮件
        MailUtil mailUtil = MailUtil.getMailUtil();
        mailUtil.sendEmail(sysUser.getEmail());
        return toAjax(workTicketService.insertWorkTicket(workTicket));
    }

}
