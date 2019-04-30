package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.constant.CommonConstant;
import com.wangxhu.yixiaoyuan.constant.OrderConstant;
import com.wangxhu.yixiaoyuan.model.Orders;
import com.wangxhu.yixiaoyuan.utils.common.IdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-29 15:16
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOrdersDaoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOrdersDaoTest.class);

    @Autowired
    private IOrdersDao ordersDao;

    @Test
    public void saveTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        IdUtils idUtils = new IdUtils(0, 0);
        Orders orders = new Orders();
        orders.setGid(1);
        orders.setUid(1);
        orders.setStatus(0);
        orders.setCreateTime(dateFormat.format(new Date()));
        orders.setOrderNum(idUtils.nextId());
        ordersDao.save(orders);
        LOGGER.warn("测试成功！");
    }


    @Test
    public void getMyOrdersTest() {
        Integer uid = 1;
        List<Orders> ordersList = ordersDao.getMyOrders(uid);
        LOGGER.warn("测试结果:{}", ordersList);
    }


    @Test
    public void queryOrdersTest() {
        Integer uid = 1;
        Integer gid = 1;
        Orders orders = ordersDao.queryOrders(gid, uid);
        LOGGER.warn("测试结果:{}", orders);
    }

    @Test
    public void updateStatusTest() {
        Integer uid = 1;
        Integer gid = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Orders orders = ordersDao.queryOrders(gid, uid);
        orders.setPayTime(dateFormat.format(new Date()));
        orders.setUid(uid);
        orders.setGid(gid);
        ordersDao.updateStatus(orders);
        Orders orders1 = ordersDao.queryOrders(gid, uid);
        LOGGER.warn("测试成功！{}",orders1);
    }

}
