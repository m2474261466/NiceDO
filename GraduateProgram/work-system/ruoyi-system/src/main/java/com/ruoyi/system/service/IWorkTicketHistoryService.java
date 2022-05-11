package com.ruoyi.system.service;

import com.ruoyi.system.domain.WorkTicketHistory;

import java.util.List;

/**
 * 工单历史记录Service接口
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
public interface IWorkTicketHistoryService 
{
    /**
     * 查询工单历史记录
     * 
     * @param hId 工单历史记录主键
     * @return 工单历史记录
     */
    public WorkTicketHistory selectWorkTicketHistoryByHId(Long hId);

    /**
     * 查询工单历史记录列表
     * 
     * @param workTicketHistory 工单历史记录
     * @return 工单历史记录集合
     */
    public List<WorkTicketHistory> selectWorkTicketHistoryList(WorkTicketHistory workTicketHistory);

    /**
     * 新增工单历史记录
     * 
     * @param workTicketHistory 工单历史记录
     * @return 结果
     */
    public int insertWorkTicketHistory(WorkTicketHistory workTicketHistory);

    /**
     * 修改工单历史记录
     * 
     * @param workTicketHistory 工单历史记录
     * @return 结果
     */
    public int updateWorkTicketHistory(WorkTicketHistory workTicketHistory);

    /**
     * 批量删除工单历史记录
     * 
     * @param hIds 需要删除的工单历史记录主键集合
     * @return 结果
     */
    public int deleteWorkTicketHistoryByHIds(String hIds);

    /**
     * 删除工单历史记录信息
     * 
     * @param hId 工单历史记录主键
     * @return 结果
     */
    public int deleteWorkTicketHistoryByHId(Long hId);
}
