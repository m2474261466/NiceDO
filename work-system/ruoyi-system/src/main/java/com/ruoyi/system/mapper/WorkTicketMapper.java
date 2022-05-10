package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WorkTicket;

/**
 * 工单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
public interface WorkTicketMapper 
{
    /**
     * 查询工单
     * 
     * @param tId 工单主键
     * @return 工单
     */
    public WorkTicket selectWorkTicketByTId(Long tId);

    /**
     * 查询工单列表
     * 
     * @param workTicket 工单
     * @return 工单集合
     */
    public List<WorkTicket> selectWorkTicketList(WorkTicket workTicket);

    /**
     * 新增工单
     * 
     * @param workTicket 工单
     * @return 结果
     */
    public int insertWorkTicket(WorkTicket workTicket);

    /**
     * 修改工单
     * 
     * @param workTicket 工单
     * @return 结果
     */
    public int updateWorkTicket(WorkTicket workTicket);

    /**
     * 删除工单
     * 
     * @param tId 工单主键
     * @return 结果
     */
    public int deleteWorkTicketByTId(Long tId);

    /**
     * 批量删除工单
     * 
     * @param tIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWorkTicketByTIds(String[] tIds);
}
