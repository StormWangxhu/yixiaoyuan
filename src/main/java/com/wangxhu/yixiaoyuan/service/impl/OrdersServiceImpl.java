package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.dao.IOrdersDao;
import com.wangxhu.yixiaoyuan.model.Orders;
import com.wangxhu.yixiaoyuan.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-29 13:30
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Service
public class OrdersServiceImpl implements IOrdersService {


    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 获取我的订单
     *
     * @param uid
     * @return
     */
    @Override
    public List<Orders> getAllMyOrders(Integer uid) {
        List<Orders> ordersList = ordersDao.getMyOrders(uid);
        if (ordersList == null || ordersList.size() == 0) {
            return null;
        }
        return ordersList;
    }
}
