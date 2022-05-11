package com.ruoyi.web.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * @program: ruoyi
 * @description:
 * @author:
 * @create: 2022-05-07 18:53
 */
public class HistoryResponse {
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

    public String gethHandlerUserName() {
        return hHandlerUserName;
    }

    public void sethHandlerUserName(String hHandlerUserName) {
        this.hHandlerUserName = hHandlerUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /** 当前处理者用户名 */
    @Excel(name = "当前处理者用户名")
    private String hHandlerUserName;

    /** 处理信息 */
    @Excel(name = "处理信息")
    private String message;

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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("hId", gethId())
                .append("hWorkId", gethWorkId())
                .append("hLastUserId", gethLastUserId())
                .append("hHandlerUserId", gethHandlerUserId())
                .append("hNextUserId", gethNextUserId())
                .append("hUpdateTime", gethUpdateTime())
                .append("hHandlerUserName", gethHandlerUserName())
                .append("message", getMessage())
                .toString();
    }
}
