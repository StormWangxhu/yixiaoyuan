package com.wangxhu.yixiaoyuan.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 13:13
 * @Email: StormWangxhu@163.com
 * @Description: order订单模型类
 */

//@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(nullable = false)
    private Integer uid;

    /**
     * 商品id
     */
    @Column(nullable = false)//nullable 的意思是可空
    private Integer gid;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单付款时间
     */
    private Date payTime;

    /**
     * 订单编号
     */
    private Long number;

    /**
     * 订单是否完成，默认无
     */
    private boolean isFinished = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", number=" + number +
                ", isFinished=" + isFinished +
                '}';
    }
}
