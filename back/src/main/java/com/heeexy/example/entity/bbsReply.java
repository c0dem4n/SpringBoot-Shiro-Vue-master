package com.heeexy.example.entity;

import java.util.Date;

/**
 * Created by wzq
 */
public class bbsReply {
    private int id;
    private int commentId;
    private String nickName;
    private String replyInfo;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "bbsReply{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", nickName='" + nickName + '\'' +
                ", replyInfo='" + replyInfo + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
