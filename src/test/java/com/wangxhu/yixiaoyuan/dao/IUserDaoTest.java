package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.User;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-25 10:52
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserDaoTest {

    @Autowired
    private IUserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(IUserDaoTest.class);

    @Test
    public void getUserByOpenId() {
        String openId = "thisisOpenIdTest";
        User user = userDao.getUserByOpenId(openId);
        LOGGER.warn("测试结果为:{}", user);
    }


    @Test
    public void getUserInfoTest() {
        Integer uid = 1;
        User user = userDao.getUserInfo(uid);
        LOGGER.warn("测试结果为:{}", user);
    }

    @Test
    public void updateTest() {
        Integer uid = 2;
        User user = new User();
        user.setQq("2690582171");
        user.setNickname("哦吼");
        user.setGender(1);
        user.setAddressNow("陕西省西安市西安电子科技大学南校区");
        user.setPhone("15664765950");
        user.setUsername("王小虎");
        user.setAvatar("avatarTest");
        userDao.update(user, 2);
        LOGGER.warn("测试成功！");
    }
}
