package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.WorkTicket;
import com.ruoyi.system.mapper.WorkTicketMapper;
import com.ruoyi.system.service.IWorkTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 工单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
@Service
public class WorkTicketServiceImpl implements IWorkTicketService
{
    @Autowired
    private WorkTicketMapper workTicketMapper;

    /**
     * 查询工单
     * 
     * @param tId 工单主键
     * @return 工单
     */
    @Override
    public WorkTicket selectWorkTicketByTId(Long tId)
    {
        return workTicketMapper.selectWorkTicketByTId(tId);
    }

    /**
     * 查询工单列表
     * 
     * @param workTicket 工单
     * @return 工单
     */
    @Override
    public List<WorkTicket> selectWorkTicketList(WorkTicket workTicket)
    {
        return workTicketMapper.selectWorkTicketList(workTicket);
    }

    /**
     * 新增工单
     * 
     * @param workTicket 工单
     * @return 结果
     */
    @Override
    public int insertWorkTicket(WorkTicket workTicket)
    {
        return workTicketMapper.insertWorkTicket(workTicket);
    }

    /**
     * 修改工单
     * 
     * @param workTicket 工单
     * @return 结果
     */
    @Override
    public int updateWorkTicket(WorkTicket workTicket)
    {
        return workTicketMapper.updateWorkTicket(workTicket);
    }

    /**
     * 批量删除工单
     * 
     * @param tIds 需要删除的工单主键
     * @return 结果
     */
    @Override
    public int deleteWorkTicketByTIds(String tIds)
    {
        return workTicketMapper.deleteWorkTicketByTIds(Convert.toStrArray(tIds));
    }

    /**
     * 删除工单信息
     * 
     * @param tId 工单主键
     * @return 结果
     */
    @Override
    public int deleteWorkTicketByTId(Long tId)
    {
        return workTicketMapper.deleteWorkTicketByTId(tId);
    }

    @Override
    public ArrayList<HashMap<String,Object>> selectWorkTicketifsuccess() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        //完成
        hashMap.put("完成",0);
        //未完成
        hashMap.put("未完成",0);
        List<WorkTicket> workTickets = workTicketMapper.selectWorkTicketList(null);
        for (int i = 0; i < workTickets.size(); i++) {
            WorkTicket workTicket = workTickets.get(i);
            if (workTicket.gettState()==1){
                //完成
               if (hashMap.get("完成")!=0){
                   Integer integer = hashMap.get("完成");
                   integer++;
                   hashMap.put("完成",integer);
               }else{
                   hashMap.put("完成",1);
               }
            }else{
                //未完成
                if (hashMap.get("未完成")!=0){
                    Integer integer = hashMap.get("未完成");
                    integer++;
                    hashMap.put("未完成",integer);
                }else{
                    hashMap.put("未完成",1);
                }

            }
        }
        ArrayList<HashMap<String,Object>> integers = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
       while (iterator.hasNext()){
           Map.Entry<String, Integer> next = iterator.next();
           String key = next.getKey();
           Integer value = next.getValue();
           HashMap<String, Object> hashMap1 = new HashMap<>();
           hashMap1.put("name",key);
           hashMap1.put("value",value);
           integers.add(hashMap1);
       }
        return integers;
    }
}
