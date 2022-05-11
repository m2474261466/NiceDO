package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.WorkTicketHistory;
import com.ruoyi.system.service.IWorkTicketHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工单历史记录Controller
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/system/history")
public class WorkTicketHistoryController extends BaseController
{
    private String prefix = "system/history";

    @Autowired
    private IWorkTicketHistoryService workTicketHistoryService;

    @RequiresPermissions("system:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询工单历史记录列表
     */
    @RequiresPermissions("system:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkTicketHistory workTicketHistory)
    {
        startPage();
        List<WorkTicketHistory> list = workTicketHistoryService.selectWorkTicketHistoryList(workTicketHistory);
        return getDataTable(list);
    }

    /**
     * 导出工单历史记录列表
     */
    @RequiresPermissions("system:history:export")
    @Log(title = "工单历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkTicketHistory workTicketHistory)
    {
        List<WorkTicketHistory> list = workTicketHistoryService.selectWorkTicketHistoryList(workTicketHistory);
        ExcelUtil<WorkTicketHistory> util = new ExcelUtil<WorkTicketHistory>(WorkTicketHistory.class);
        return util.exportExcel(list, "工单历史记录数据");
    }

    /**
     * 新增工单历史记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工单历史记录
     */
    @RequiresPermissions("system:history:add")
    @Log(title = "工单历史记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkTicketHistory workTicketHistory)
    {
        return toAjax(workTicketHistoryService.insertWorkTicketHistory(workTicketHistory));
    }

    /**
     * 修改工单历史记录
     */
    @RequiresPermissions("system:history:edit")
    @GetMapping("/edit/{hId}")
    public String edit(@PathVariable("hId") Long hId, ModelMap mmap)
    {
        WorkTicketHistory workTicketHistory = workTicketHistoryService.selectWorkTicketHistoryByHId(hId);
        mmap.put("workTicketHistory", workTicketHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存工单历史记录
     */
    @RequiresPermissions("system:history:edit")
    @Log(title = "工单历史记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkTicketHistory workTicketHistory)
    {
        return toAjax(workTicketHistoryService.updateWorkTicketHistory(workTicketHistory));
    }

    /**
     * 删除工单历史记录
     */
    @RequiresPermissions("system:history:remove")
    @Log(title = "工单历史记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workTicketHistoryService.deleteWorkTicketHistoryByHIds(ids));
    }
}
