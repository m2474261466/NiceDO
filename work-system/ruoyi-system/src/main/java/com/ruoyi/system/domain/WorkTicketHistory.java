package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 工单历史记录对象 work_ticket_history
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
public class WorkTicketHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long hId;

    /** 工单id */
    @Excel(name = "工单id")
    private Long hWorkId;

    /** 上一处理者id */
    @Excel(name = "上一处理者id")
    private Long hLastUserId;

    /** 当前处理者id */
    @Excel(name = "当前处理者id")
    private Long hHandlerUserId;

    /** 下一处理者id */
    @Excel(name = "下一处理者id")
    private Long hNextUserId;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date hUpdateTime;

    public void sethId(Long hId) 
    {
        this.hId = hId;
    }

    public Long gethId() 
    {
        return hId;
    }
    public void sethWorkId(Long hWorkId) 
    {
        this.hWorkId = hWorkId;
    }

    public Long gethWorkId() 
    {
        return hWorkId;
    }
    public void sethLastUserId(Long hLastUserId) 
    {
        this.hLastUserId = hLastUserId;
    }

    public Long gethLastUserId() 
    {
        return hLastUserId;
    }
    public void sethHandlerUserId(Long hHandlerUserId) 
    {
        this.hHandlerUserId = hHandlerUserId;
    }

    public Long gethHandlerUserId() 
    {
        return hHandlerUserId;
    }
    public void sethNextUserId(Long hNextUserId) 
    {
        this.hNextUserId = hNextUserId;
    }

    public Long gethNextUserId() 
    {
        return hNextUserId;
    }
    public void sethUpdateTime(Date hUpdateTime) 
    {
        this.hUpdateTime = hUpdateTime;
    }

    public Date gethUpdateTime() 
    {
        return hUpdateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hId", gethId())
            .append("hWorkId", gethWorkId())
            .append("hLastUserId", gethLastUserId())
            .append("hHandlerUserId", gethHandlerUserId())
            .append("hNextUserId", gethNextUserId())
            .append("hUpdateTime", gethUpdateTime())
            .toString();
    }
}
