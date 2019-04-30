package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-29 13:36
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Repository
@Mapper
public interface IOrdersDao {

    /**
     * 获取我的订单
     *
     * @param uid
     * @return
     */
    List<Orders> getMyOrders(@Param("uid") Integer uid);

    /**
     * 保存我的订单
     *
     * @param orders
     */
    void save(@Param("orders") Orders orders);

    /**
     * 查询订单
     *
     * @param gid
     * @param uid
     * @return
     */
    Orders queryOrders(@Param("gid") Integer gid, @Param("uid") Integer uid);


    /**
     * 更新订单状态
     *
     * @param orders
     */
    void updateStatus(@Param("orders") Orders orders);
}
