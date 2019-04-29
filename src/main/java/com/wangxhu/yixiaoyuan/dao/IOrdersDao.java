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
}
