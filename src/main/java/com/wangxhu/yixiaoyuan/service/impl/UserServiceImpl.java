package com.wangxhu.yixiaoyuan.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangxhu.yixiaoyuan.constant.UserConstant;
import com.wangxhu.yixiaoyuan.dao.IUserDao;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.IUserService;
import com.wangxhu.yixiaoyuan.utils.common.ObjectUtil;
import com.wangxhu.yixiaoyuan.utils.result.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 11:16
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Service//如果一个类带了@Service注解，将自动注册到Spring容器
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao userDao;

    /**
     * 根据openId判断用户是否登录
     *
     * @param openId
     * @return
     */
    @Override
    public User login(String openId) {
        User user = userDao.getUserByOpenId(openId);
        if (user == null) {
            user = new User();
            user.setOpenId(openId);
        }
        return user;
    }
}
