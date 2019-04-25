package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-25 16:11
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Repository
@Mapper
public interface IAddressDao {

    /**
     * 保存用户的收货地址
     *
     * @param address
     */
    void save(@Param("address") Address address);

    /**
     * 根据id查询用户的收货地址
     *
     * @param uid
     * @return
     */
    List<Address> getAllGoodsAddress(@Param("uid") Integer uid);
}
