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
    public void getUserByOpenId(){
        String openId = "hello";
        User user = userDao.getUserByOpenId(openId);
        LOGGER.info("测试结果为：{}",user);
    }
}
