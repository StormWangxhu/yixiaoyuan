package com.wangxhu.yixiaoyuan.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-28 16:42
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICollectsDaoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ICollectsDaoTest.class);

    @Autowired
    private ICollectDao collectDao;

    @Test
    public void isExistThisGoodsTest() {
        Integer gid = 1;
        Integer uidMy = 2;
        Integer uidOther = 1;
        Integer result = collectDao.isExistThisGoods(uidMy, uidOther, gid);
        LOGGER.warn("测试结果：{}", result);
    }

    @Test
    public void insertCollectsTest() {
        Integer gid = 6;
        Integer uidMy = 3;
        Integer uidOther = 1;
        collectDao.insertCollects(uidMy, uidOther, gid);
        LOGGER.warn("测试成功！");
    }
}
