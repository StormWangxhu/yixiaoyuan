package com.wangxhu.yixiaoyuan.service;

import com.wangxhu.yixiaoyuan.model.User;

import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 11:16
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public interface IUserService {

    /**
     * 判断是否登录成功
     * @param openId
     * @return
     */
    User login(String openId);
}
