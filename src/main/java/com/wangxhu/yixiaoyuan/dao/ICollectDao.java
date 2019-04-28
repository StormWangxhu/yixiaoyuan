package com.wangxhu.yixiaoyuan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-28 15:33
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Repository
@Mapper
public interface ICollectDao {

    /**
     * 判断该商品是否在已经收藏
     *
     * @param uid
     * @param uid_other
     * @param gid
     * @return
     */
    int isExistThisGoods(@Param("uid_my") Integer uid, @Param("uid_other") Integer uid_other, @Param("gid") Integer gid);

    /**
     * 将商品添加至用户的收藏
     *
     * @param uid
     * @param uid_other
     * @param gid
     */
    void insertCollects(@Param("uid_my") Integer uid, @Param("uid_other") Integer uid_other, @Param("gid") Integer gid);
}
