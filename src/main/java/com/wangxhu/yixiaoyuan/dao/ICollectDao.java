package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.Collects;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 判断该商品是否已加入我的收藏
     *
     * @param uid
     * @param gid
     * @return
     */
    Integer isExistThisGoods2(@Param("uid_my") Integer uid, @Param("gid") Integer gid);

    /**
     * 取消我的收藏
     *
     * @param uid
     * @param gid
     */
    void updateCollectState(@Param("uid_my") Integer uid, @Param("gid") Integer gid);

    /**
     * 获取我的所有收藏商品
     *
     * @param uid
     * @return
     */
    List<Collects> getAllMyCollectsId(@Param("uid_my") Integer uid);
}
