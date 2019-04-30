package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.constant.CommonConstant;
import com.wangxhu.yixiaoyuan.constant.OrderConstant;
import com.wangxhu.yixiaoyuan.dao.IOrdersDao;
import com.wangxhu.yixiaoyuan.model.Orders;
import com.wangxhu.yixiaoyuan.service.IOrdersService;
import com.wangxhu.yixiaoyuan.utils.common.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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


    /**
     * 将交易商品添加到我的订单中
     *
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public boolean addMyOrders(Integer gid, Integer uid) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Orders orders = new Orders();
        orders.setGid(gid);
        orders.setUid(uid);
        orders.setCreateTime(dateFormat.format(new Date()));
        orders.setOrderNum(new IdUtils(0, 0).nextId());//生成一个订单号
        orders.setStatus(0);//0代表订单未完成
        ordersDao.save(orders);
        return true;
    }


    /**
     * 用户完成了订单
     *
     * @param gid
     * @param uid
     * @return
     */
    @Override
    public Map<String, String> updateStatus(Integer gid, Integer uid) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Map<String, String> datas = new HashMap<>();
        Orders orders = ordersDao.queryOrders(gid, uid);
        Integer status = orders.getStatus();
        if (status == OrderConstant.DONE) {
            datas.put(CommonConstant.FAIL, OrderConstant.FININSH);
            return datas;
        }
        orders.setPayTime(dateFormat.format(new Date()));
        orders.setUid(uid);
        orders.setGid(gid);
        ordersDao.updateStatus(orders);
        datas.put(CommonConstant.SUCCESS, CommonConstant.SUCCESS);
        return datas;
    }
}
