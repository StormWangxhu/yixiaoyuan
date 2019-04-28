package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-26 16:24
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Repository
@Mapper
public interface IGoodsDao {

    /**
     * 保存用户发布的商品
     *
     * @param goods
     */
    void save(@Param("goods") Goods goods);

    /**
     * 获取我的所有发布
     *
     * @param uid
     * @return
     */
    List<Goods> getAllPublishGoods(@Param("uid") Integer uid);

    /**
     * 更新一个用户特定商品的页面浏览量
     *
     * @param goods
     */
    void updatePageviews(@Param("goods") Goods goods);

    /**
     * 获取我的收藏
     *
     * @param iddLists
     * @param uid
     * @return
     */
    List<Goods> getAllMyCollectGoods(@Param("list") List<Integer> iddLists, @Param("uid") Integer uid);
}
