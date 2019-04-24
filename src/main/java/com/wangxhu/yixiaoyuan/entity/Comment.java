package com.wangxhu.yixiaoyuan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 13:32
 * @Email: StormWangxhu@163.com
 * @Description: 评论实体类comment
 */

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id ;

    /**
     * 商品Id
     */
    @Column(nullable = false)
    private Integer gid ;

    /**
     * 发帖用户id
     */
    @Column(nullable = false)
    private Integer uidLeader ;

    /**
     * 跟帖用户id
     */
    @Column(nullable = false)
    private Integer uidFollower ;

    /**
     * 发帖用户评论内容
     */
    private String contentLeader ;

    /**
     * 跟帖用户评论内容
     */
    private String contentFollower ;

    /**
     * 发帖用户评论时间
     */
    private Date leaderCallbackTime ;

    /**
     * 跟帖用户评论时间
     */
    private Date followerCommentTime ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUidLeader() {
        return uidLeader;
    }

    public void setUidLeader(Integer uidLeader) {
        this.uidLeader = uidLeader;
    }

    public Integer getUidFollower() {
        return uidFollower;
    }

    public void setUidFollower(Integer uidFollower) {
        this.uidFollower = uidFollower;
    }

    public String getContentLeader() {
        return contentLeader;
    }

    public void setContentLeader(String contentLeader) {
        this.contentLeader = contentLeader;
    }

    public String getContentFollower() {
        return contentFollower;
    }

    public void setContentFollower(String contentFollower) {
        this.contentFollower = contentFollower;
    }

    public Date getLeaderCallbackTime() {
        return leaderCallbackTime;
    }

    public void setLeaderCallbackTime(Date leaderCallbackTime) {
        this.leaderCallbackTime = leaderCallbackTime;
    }

    public Date getFollowerCommentTime() {
        return followerCommentTime;
    }

    public void setFollowerCommentTime(Date followerCommentTime) {
        this.followerCommentTime = followerCommentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", gid=" + gid +
                ", uidLeader=" + uidLeader +
                ", uidFollower=" + uidFollower +
                ", contentLeader='" + contentLeader + '\'' +
                ", contentFollower='" + contentFollower + '\'' +
                ", leaderCallbackTime=" + leaderCallbackTime +
                ", followerCommentTime=" + followerCommentTime +
                '}';
    }
}
