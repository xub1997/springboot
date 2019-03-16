package com.xub.wechat.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_friend_request")
public class FriendRequest {
    /**
     * 请求编号
     */
    @Id
    @Column(name = "request_id")
    private String requestId;

    /**
     * 发送人编号
     */
    @Column(name = "send_user_id")
    private String sendUserId;

    /**
     * 接受人编号
     */
    @Column(name = "accept_user_id")
    private String acceptUserId;

    /**
     * 请求状态（1 待通过   2 通过   3 拒绝通过）
     */
    private Integer status;

    /**
     * 是否删除（0未删除  1已删除）
     */
    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 请求时间
     */
    @Column(name = "request_time")
    private Date requestTime;

    /**
     * 获取请求编号
     *
     * @return request_id - 请求编号
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 设置请求编号
     *
     * @param requestId 请求编号
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * 获取发送人编号
     *
     * @return send_user_id - 发送人编号
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * 设置发送人编号
     *
     * @param sendUserId 发送人编号
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    /**
     * 获取接受人编号
     *
     * @return accept_user_id - 接受人编号
     */
    public String getAcceptUserId() {
        return acceptUserId;
    }

    /**
     * 设置接受人编号
     *
     * @param acceptUserId 接受人编号
     */
    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    /**
     * 获取请求状态（1 待通过   2 通过   3 拒绝通过）
     *
     * @return status - 请求状态（1 待通过   2 通过   3 拒绝通过）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置请求状态（1 待通过   2 通过   3 拒绝通过）
     *
     * @param status 请求状态（1 待通过   2 通过   3 拒绝通过）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否删除（0未删除  1已删除）
     *
     * @return is_del - 是否删除（0未删除  1已删除）
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除（0未删除  1已删除）
     *
     * @param isDel 是否删除（0未删除  1已删除）
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取请求时间
     *
     * @return request_time - 请求时间
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * 设置请求时间
     *
     * @param requestTime 请求时间
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}