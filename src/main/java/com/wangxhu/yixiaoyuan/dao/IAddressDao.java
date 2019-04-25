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
     * 保存用户的收获地址
     *
     * @param address
     */
    void save(@Param("address") Address address);

    /**
     * 根据id查询用户的收获地址
     *
     * @param id
     * @return
     */
    Address getAllGoodsAddress(@Param("id") Integer id);

    /**
     * 根据用户的uid查询出用户所有的收获地址id
     *
     * @param uid
     * @return
     */
    List<Integer> getIdsByUid(@Param("uid") Integer uid);
}
