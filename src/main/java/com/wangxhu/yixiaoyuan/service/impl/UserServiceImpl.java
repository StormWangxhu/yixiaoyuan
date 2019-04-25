package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.dao.IUserDao;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    /**
     * 获取用户信息
     *
     * @param uid
     * @return
     */
    @Override
    public User getUserInfo(Integer uid) {
        User user = userDao.getUserInfo(uid);
        return user;
    }
}
