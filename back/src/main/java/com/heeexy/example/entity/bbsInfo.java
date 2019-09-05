package com.heeexy.example.entity;

import java.util.Date;

/**
 * Created by wzq
 */
public class bbsInfo {
    private int id;
    private String roleId;
    private String nickName;
    private String title;
    private String content;
    private int replyNum;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "bbsInfo{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", replyNum=" + replyNum +
                ", createTime=" + createTime +
                '}';
    }
}
