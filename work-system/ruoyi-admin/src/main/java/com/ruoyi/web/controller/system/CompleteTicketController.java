package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.WorkTicket;
import com.ruoyi.system.service.IWorkTicketService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 完成工单Controller
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/system/complete")
public class CompleteTicketController extends BaseController
{
    private String prefix = "system/ticket";

    @Autowired
    private IWorkTicketService workTicketService;

    @RequiresPermissions("system:complete:view")
    @GetMapping()
    public String ticket()
    {
        return prefix + "/complete";
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
        workTicket.settCreateUserId(userId);
        workTicket.settState(1);
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
