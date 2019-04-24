package com.wangxhu.yixiaoyuan.model;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 19:51
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public class TokenModel {

    /**
     * 用户的id
     */
    private Integer uid;

    /**
     * 微信给的openId作为token
     */
    private String token;

    public TokenModel() {
    }

    public TokenModel(Integer uid, String openId) {
        this.uid = uid;
        this.token = openId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "uid=" + uid +
                ", token='" + token + '\'' +
                '}';
    }
}
