package com.wangxhu.yixiaoyuan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 12:26
 * @Email: StormWangxhu@163.com
 * @Description: 收获地址模型address
 */

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generate 产生的意思，IDENTITY主键则由数据库自动维护，使用起来很简单
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(nullable = false)//设置列的属性，非空
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer uid;

    /**
     * 省市
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String province;

    /**
     * 详细地址
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String detailedAddress;

    /**
     * 是否详细地址
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean isDefault = false;//默认不是

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
