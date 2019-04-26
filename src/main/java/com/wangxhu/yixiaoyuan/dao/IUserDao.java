package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 11:06
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Repository//作用和@Service作用一样
@Mapper
public interface IUserDao {

    /**
     * 根据openId查询用户
     *
     * @param openId
     * @return
     */
    User getUserByOpenId(@Param("openId") String openId);

    /**
     * 获取用户信息
     *
     * @param uid
     * @return
     */
    User getUserInfo(@Param("uid") Integer uid);

    /**
     * 更新用户信息
     *
     * @param user
     * @param id
     */
    void update(@Param("user") User user, @Param("id") Integer id);

}
