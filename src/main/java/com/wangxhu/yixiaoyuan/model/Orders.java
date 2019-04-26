package com.wangxhu.yixiaoyuan.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-26 19:30
 * @Email: StormWangxhu@163.com
 * @Description: 订单模型类order
 */


/**
 * 错误记录，这个表一直报DDL错误，原因是表名order与mysql内部关键字可能冲突，改为orders
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品id
     */
    private Integer gid;

    /**
     * 订单创建时间
     */
    private String createTime;

    /**
     * 付款时间
     */
    private String payTime;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 订单状态
     * 0-未完成
     * 1-完成
     */
    private Integer status;


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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", createTime='" + createTime + '\'' +
                ", payTime='" + payTime + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", status=" + status +
                '}';
    }
}
