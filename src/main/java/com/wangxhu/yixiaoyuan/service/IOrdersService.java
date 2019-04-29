package com.wangxhu.yixiaoyuan.service;

import com.wangxhu.yixiaoyuan.model.Orders;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-29 13:30
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public interface IOrdersService {


    /**
     * 获取我的订单
     *
     * @param uid
     * @return
     */
    List<Orders> getAllMyOrders(Integer uid);
}
