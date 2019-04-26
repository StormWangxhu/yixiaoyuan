package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.dao.IGoodsDao;
import com.wangxhu.yixiaoyuan.model.Goods;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-26 16:13
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Service
public class GoodsServiceImpl implements IGoodService {

    @Autowired
    private IGoodsDao goodsDao;

    /**
     * 保存用户发布的商品
     *
     * @param loginUser
     * @param paramGoods
     */
    @Override
    public void save(User loginUser, Goods paramGoods) {
        Integer uid = loginUser.getId();
        Goods goods = new Goods();
        goods.setAvatar(paramGoods.getAvatar());
        goods.setCategory(paramGoods.getCategory());
        goods.setDescription(paramGoods.getDescription());
        goods.setPrice(paramGoods.getPrice());
        goods.setPageviews(paramGoods.getPageviews());
        goods.setSelled(paramGoods.isSelled());
        goods.setUid(uid);
        goodsDao.save(goods);
    }
}
