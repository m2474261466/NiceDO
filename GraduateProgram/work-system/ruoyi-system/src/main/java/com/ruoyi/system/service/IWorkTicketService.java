package com.ruoyi.system.service;

import com.ruoyi.system.domain.WorkTicket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 工单Service接口
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
public interface IWorkTicketService 
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
     * 批量删除工单
     * 
     * @param tIds 需要删除的工单主键集合
     * @return 结果
     */
    public int deleteWorkTicketByTIds(String tIds);

    /**
     * 删除工单信息
     * 
     * @param tId 工单主键
     * @return 结果
     */
    public int deleteWorkTicketByTId(Long tId);

    ArrayList<HashMap<String,Object>> selectWorkTicketifsuccess();

}
