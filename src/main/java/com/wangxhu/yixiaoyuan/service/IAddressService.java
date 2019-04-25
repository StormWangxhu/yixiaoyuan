package com.wangxhu.yixiaoyuan.service;

import com.wangxhu.yixiaoyuan.model.Address;
import com.wangxhu.yixiaoyuan.model.User;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-25 11:45
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public interface IAddressService {

    /**
     * 更新收获地址信息
     *
     * @param loginUser
     * @param addressParam
     * @return
     */
    boolean insertAddress(User loginUser, Address addressParam);

    /**
     * 根据uid查询用户的所有的地址
     * @param uid
     * @return
     */
    List<Address> getAllGoodsAddress(Integer uid);
}
