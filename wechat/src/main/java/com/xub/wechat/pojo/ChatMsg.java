package com.xub.wechat.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_chat_msg")
public class ChatMsg {
    /**
     * 信息编号
     */
    @Id
    @Column(name = "msg_id")
    private String msgId;

    /**
     * 发送人编号
     */
    @Column(name = "send_userid")
    private String sendUserid;

    /**
     * 接受人编号
     */
    @Column(name = "accept_userid")
    private String acceptUserid;

    /**
     * 信息内容
     */
    private String msg;

    /**
     * 信息标记 0 未签收   1 已签收
     */
    @Column(name = "sign_flag")
    private Integer signFlag;

    /**
     * 是否删除（0未删除  1已删除）
     */
    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 发送时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取信息编号
     *
     * @return msg_id - 信息编号
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置信息编号
     *
     * @param msgId 信息编号
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * 获取发送人编号
     *
     * @return send_userid - 发送人编号
     */
    public String getSendUserid() {
        return sendUserid;
    }

    /**
     * 设置发送人编号
     *
     * @param sendUserid 发送人编号
     */
    public void setSendUserid(String sendUserid) {
        this.sendUserid = sendUserid;
    }

    /**
     * 获取接受人编号
     *
     * @return accept_userid - 接受人编号
     */
    public String getAcceptUserid() {
        return acceptUserid;
    }

    /**
     * 设置接受人编号
     *
     * @param acceptUserid 接受人编号
     */
    public void setAcceptUserid(String acceptUserid) {
        this.acceptUserid = acceptUserid;
    }

    /**
     * 获取信息内容
     *
     * @return msg - 信息内容
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置信息内容
     *
     * @param msg 信息内容
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取信息标记
     *
     * @return sign_flag - 信息标记
     */
    public Integer getSignFlag() {
        return signFlag;
    }

    /**
     * 设置信息标记
     *
     * @param signFlag 信息标记
     */
    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
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
     * 获取发送时间
     *
     * @return create_time - 发送时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发送时间
     *
     * @param createTime 发送时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}