package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.WorkTicketHistory;
import com.ruoyi.system.mapper.WorkTicketHistoryMapper;
import com.ruoyi.system.service.IWorkTicketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工单历史记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
@Service
public class WorkTicketHistoryServiceImpl implements IWorkTicketHistoryService 
{
    @Autowired
    private WorkTicketHistoryMapper workTicketHistoryMapper;

    /**
     * 查询工单历史记录
     * 
     * @param hId 工单历史记录主键
     * @return 工单历史记录
     */
    @Override
    public WorkTicketHistory selectWorkTicketHistoryByHId(Long hId)
    {
        return workTicketHistoryMapper.selectWorkTicketHistoryByHId(hId);
    }

    /**
     * 查询工单历史记录列表
     * 
     * @param workTicketHistory 工单历史记录
     * @return 工单历史记录
     */
    @Override
    public List<WorkTicketHistory> selectWorkTicketHistoryList(WorkTicketHistory workTicketHistory)
    {
        return workTicketHistoryMapper.selectWorkTicketHistoryList(workTicketHistory);
    }

    /**
     * 新增工单历史记录
     * 
     * @param workTicketHistory 工单历史记录
     * @return 结果
     */
    @Override
    public int insertWorkTicketHistory(WorkTicketHistory workTicketHistory)
    {
        return workTicketHistoryMapper.insertWorkTicketHistory(workTicketHistory);
    }

    /**
     * 修改工单历史记录
     * 
     * @param workTicketHistory 工单历史记录
     * @return 结果
     */
    @Override
    public int updateWorkTicketHistory(WorkTicketHistory workTicketHistory)
    {
        return workTicketHistoryMapper.updateWorkTicketHistory(workTicketHistory);
    }

    /**
     * 批量删除工单历史记录
     * 
     * @param hIds 需要删除的工单历史记录主键
     * @return 结果
     */
    @Override
    public int deleteWorkTicketHistoryByHIds(String hIds)
    {
        return workTicketHistoryMapper.deleteWorkTicketHistoryByHIds(Convert.toStrArray(hIds));
    }

    /**
     * 删除工单历史记录信息
     * 
     * @param hId 工单历史记录主键
     * @return 结果
     */
    @Override
    public int deleteWorkTicketHistoryByHId(Long hId)
    {
        return workTicketHistoryMapper.deleteWorkTicketHistoryByHId(hId);
    }
}
