package com.wangxhu.yixiaoyuan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

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
    private Long pageviews;

    /**
     * 商品是否已经出售
     */
    private boolean isSelled = false;//默认无

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

    public Long getPageviews() {
        return pageviews;
    }

    public void setPageviews(Long pageviews) {
        this.pageviews = pageviews;
    }

    public boolean isSelled() {
        return isSelled;
    }

    public void setSelled(boolean selled) {
        isSelled = selled;
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
                '}';
    }
}
