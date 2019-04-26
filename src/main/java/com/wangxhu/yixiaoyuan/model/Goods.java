package com.wangxhu.yixiaoyuan.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 13:08
 * @Email: StormWangxhu@163.com
 * @Description: 商品模型类goods
 */

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;

    /**
     * 用户Id
     */
    @Column(nullable = false)
    private Integer uid;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品图片
     */
    private String avatar;

    /**
     * 商品类别
     */
    private Integer category;

    /**
     * 商品浏览量
     */
    private Integer pageviews = 0;

    /**
     * 商品是否已经出售
     */
    private int isSelled = 0;//默认无0

    /**
     * 发布时间
     */
    private String publishTime;

    /**
     * 卖出时间
     */
    private String sellTime;


    public String getSellTime() {
        return sellTime;
    }

    public void setSellTime(String sellTime) {
        this.sellTime = sellTime;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public int getIsSelled() {
        return isSelled;
    }

    public void setIsSelled(int isSelled) {
        this.isSelled = isSelled;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", uid=" + uid +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                ", category=" + category +
                ", pageviews=" + pageviews +
                ", isSelled=" + isSelled +
                ", publishTime='" + publishTime + '\'' +
                ", sellTime='" + sellTime + '\'' +
                '}';
    }
}
