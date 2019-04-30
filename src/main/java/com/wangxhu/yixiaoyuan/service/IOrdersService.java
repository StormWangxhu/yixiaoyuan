package com.wangxhu.yixiaoyuan.service;

import com.wangxhu.yixiaoyuan.model.Orders;

import java.util.List;
import java.util.Map;

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

    /**
     * 将交易商品添加至我的订单中
     *
     * @param gid
     * @param uid
     * @return
     */
    boolean addMyOrders(Integer gid, Integer uid);


    /**
     * 更新订单状态
     *
     * @param gid
     * @param uid
     * @return
     */
    Map<String, String> updateStatus(Integer gid, Integer uid);

}
