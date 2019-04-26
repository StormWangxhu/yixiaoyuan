package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.dao.IGoodsDao;
import com.wangxhu.yixiaoyuan.model.Goods;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Integer uid = loginUser.getId();
        Goods goods = new Goods();
        goods.setAvatar(paramGoods.getAvatar());
        goods.setCategory(paramGoods.getCategory());
        goods.setDescription(paramGoods.getDescription());
        goods.setPrice(paramGoods.getPrice());
        goods.setPageviews(paramGoods.getPageviews());
        goods.setIsSelled(paramGoods.getIsSelled());
        goods.setUid(uid);
        goods.setPublishTime(ft.format(new Date()));
        goodsDao.save(goods);
    }


    /**
     * 获取我的所有发布
     *
     * @param loginUser
     * @return
     */
    @Override
    public List<Goods> getAllPublishGoods(User loginUser) {
        Integer uid = loginUser.getId();
        List<Goods> list = goodsDao.getAllPublishGoods(uid);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }

    /**
     * 更新页面浏览量
     *
     * @param uid
     * @param gid
     * @param pageviews
     * @return
     */
    @Override
    public boolean updatePageviews(Integer uid, Integer gid, Integer pageviews) {
        Goods goods = new Goods();
        goods.setId(gid);
        goods.setPageviews(pageviews);
        goods.setUid(uid);
        goodsDao.updatePageviews(goods);
        return true;
    }
}
