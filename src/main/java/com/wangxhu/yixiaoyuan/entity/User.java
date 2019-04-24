package com.wangxhu.yixiaoyuan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 11:05
 * @Email: StormWangxhu@163.com
 * @Description: 用户模型类user
 */

@Entity//设置为一个实体类
@Table(name = "user")//设置实体类对应的表，常与@Entity一起使用。参数：name制定表名，不写的话，为实体类的类名
public class User {

    @Id//作用：设置对象标识符
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//作用：设置标识符的生成策略，常与@Id一起使用。IDENTITY：适用于MySQL,主键由数据库自动生成（主要是自动增长型)  JPA标准用法
    @JsonInclude(JsonInclude.Include.NON_EMPTY)//使用 @JsonInclude 注解可以控制在哪些情况下才将被注解的属性转换成 json，例如只有属性不为 null 时。
    private Integer id;

    /**
     * 用户性别，0-男，1-女
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer gender;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String username;

    /**
     * 用户微信名，可得到
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nickname;

    /**
     * 用户头像
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String avatar;

    /**
     * 用户手机号
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phone;

    /**
     * 用户QQ号
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String qq;

    /**
     * 用户当前所在的地址
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String addressNow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddressNow() {
        return addressNow;
    }

    public void setAddressNow(String addressNow) {
        this.addressNow = addressNow;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender=" + gender +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", addressNow='" + addressNow + '\'' +
                '}';
    }
}
