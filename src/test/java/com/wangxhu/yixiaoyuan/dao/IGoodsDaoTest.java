package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.Goods;
import javafx.scene.input.DataFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-26 18:51
 * @Email: StormWangxhu@163.com
 * @Description:
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class IGoodsDaoTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(IGoodsDaoTest.class);

    @Autowired
    private IGoodsDao goodsDao;

    @Test
    public void saveTest() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Goods goods = new Goods();
        goods.setUid(3);
        goods.setPageviews(20);
        goods.setPrice(200);
        goods.setDescription("我的电脑最牛逼");
        goods.setCategory(0);
        goods.setAvatar("avatarTest");
        goods.setPublishTime(ft.format(new Date()));
        goods.setIsSelled(0);
        goodsDao.save(goods);
        LOGGER.warn("测试成功！");
    }
}
