package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 工单对象 work_ticket
 * 
 * @author ruoyi
 * @date 2022-05-03
 */
public class WorkTicket extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工单主键 */
    private Long tId;

    /** 工单标题 */
    @Excel(name = "工单标题")
    private String tTitile;

    /** 工单信息 */
    @Excel(name = "工单信息")
    private String tInfo;

    /** 工单类型(0:流转工单;1:协作工单) */
    @Excel(name = "工单类型(0:流转工单;1:协作工单)")
    private Integer tType;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long tCreateUserId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date tCreateTime;

    /** 完成状态(0:未完成;1:完成) */
    @Excel(name = "完成状态(0:未完成;1:完成)")
    private Integer tState;

    /** 协作工单指定人数组(顺序排列) */
    @Excel(name = "协作工单指定人数组(顺序排列)")
    private String tUserList;

    /** 指定处理人id(流转工单) */
    @Excel(name = "指定处理人id(流转工单)")
    private Long tUserId;

    /** 当前处理人id */
    @Excel(name = "当前处理人id")
    private Long tHandlerUserId;

    public void settId(Long tId) 
    {
        this.tId = tId;
    }

    public Long gettId() 
    {
        return tId;
    }
    public void settTitile(String tTitile) 
    {
        this.tTitile = tTitile;
    }

    public String gettTitile() 
    {
        return tTitile;
    }
    public void settInfo(String tInfo) 
    {
        this.tInfo = tInfo;
    }

    public String gettInfo() 
    {
        return tInfo;
    }
    public void settType(Integer tType) 
    {
        this.tType = tType;
    }

    public Integer gettType() 
    {
        return tType;
    }
    public void settCreateUserId(Long tCreateUserId) 
    {
        this.tCreateUserId = tCreateUserId;
    }

    public Long gettCreateUserId() 
    {
        return tCreateUserId;
    }
    public void settCreateTime(Date tCreateTime) 
    {
        this.tCreateTime = tCreateTime;
    }

    public Date gettCreateTime() 
    {
        return tCreateTime;
    }
    public void settState(Integer tState) 
    {
        this.tState = tState;
    }

    public Integer gettState() 
    {
        return tState;
    }
    public void settUserList(String tUserList) 
    {
        this.tUserList = tUserList;
    }

    public String gettUserList() 
    {
        return tUserList;
    }
    public void settUserId(Long tUserId) 
    {
        this.tUserId = tUserId;
    }

    public Long gettUserId() 
    {
        return tUserId;
    }
    public void settHandlerUserId(Long tHandlerUserId) 
    {
        this.tHandlerUserId = tHandlerUserId;
    }

    public Long gettHandlerUserId() 
    {
        return tHandlerUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tId", gettId())
            .append("tTitile", gettTitile())
            .append("tInfo", gettInfo())
            .append("tType", gettType())
            .append("tCreateUserId", gettCreateUserId())
            .append("tCreateTime", gettCreateTime())
            .append("tState", gettState())
            .append("tUserList", gettUserList())
            .append("tUserId", gettUserId())
            .append("tHandlerUserId", gettHandlerUserId())
            .toString();
    }
}
