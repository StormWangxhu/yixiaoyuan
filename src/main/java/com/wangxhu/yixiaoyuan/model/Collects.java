package com.wangxhu.yixiaoyuan.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-28 15:10
 * @Email: StormWangxhu@163.com
 * @Description: 我的收藏 实体映射类
 */

@Entity
@Table(name = "Collects")
public class Collects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;

    /**
     * 我的收藏里被收藏商品的贴主id
     */
    private Integer uidOther;

    /**
     * 我的收藏里用户的id
     */
    private Integer uidMy;

    /**
     * 商品的id
     */
    private Integer gid;

    /**
     * 收藏状态  0-已收藏，1-取消收藏
     */
    @Column(nullable = false)
    private Integer state = 0;


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUidOther() {
        return uidOther;
    }

    public void setUidOther(Integer uidOther) {
        this.uidOther = uidOther;
    }

    public Integer getUidMy() {
        return uidMy;
    }

    public void setUidMy(Integer uidMy) {
        this.uidMy = uidMy;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Collects{" +
                "id=" + id +
                ", uidOther=" + uidOther +
                ", uidMy=" + uidMy +
                ", gid=" + gid +
                '}';
    }
}
