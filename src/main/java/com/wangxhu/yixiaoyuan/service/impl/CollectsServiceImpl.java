package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.constant.CollectConstant;
import com.wangxhu.yixiaoyuan.constant.CommonConstant;
import com.wangxhu.yixiaoyuan.constant.DBConstant;
import com.wangxhu.yixiaoyuan.dao.ICollectDao;
import com.wangxhu.yixiaoyuan.dao.IGoodsDao;
import com.wangxhu.yixiaoyuan.model.Collects;
import com.wangxhu.yixiaoyuan.model.Goods;
import com.wangxhu.yixiaoyuan.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-28 15:28
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Service
public class CollectsServiceImpl implements ICollectService {

    @Autowired
    private ICollectDao collectDao;

    @Autowired
    private IGoodsDao goodsDao;

    /**
     * 添加我的收藏
     *
     * @param uid
     * @param uid_other
     * @param gid
     * @return
     */
    @Override
    public Map<String, String> insertCollects(Integer uid, Integer uid_other, Integer gid) {
        Map<String, String> datas = new HashMap<>();
        //判断该商品是否已经收藏
        int result = collectDao.isExistThisGoods(uid, uid_other, gid);
        if (result >= DBConstant.HAVE_THIS_RECORD) {
            datas.put(CommonConstant.FAIL, DBConstant.HAVE_ALREADY_EXIST);
            return datas;
        }
        collectDao.insertCollects(uid, uid_other, gid);
        datas.put(CommonConstant.SUCCESS, CommonConstant.SUCCESS);
        return datas;
    }

    /**
     * 取消我的收藏
     *
     * @param uid
     * @param gid
     * @return
     */
    @Override
    public Map<String, String> cancelCollect(Integer uid, Integer gid) {
        Map<String, String> datas = new HashMap<>();
        Integer count = collectDao.isExistThisGoods2(uid, gid);
        if (count == DBConstant.NOT_HAVE_THIS_RECORD) {
            datas.put(CommonConstant.FAIL, CollectConstant.NOT_HAVE_THIS_RECORD);
            return datas;
        }
        collectDao.updateCollectState(uid, gid);
        datas.put(CommonConstant.SUCCESS, CommonConstant.SUCCESS);
        return datas;
    }

    /**
     * 获取我的所有收藏
     *
     * @param uid
     * @return
     */
    @Override
    public List<Goods> getAllMyCollects(Integer uid) {
        List<Goods> goodsList = new ArrayList<>();
        List<Integer> iddLists = new ArrayList<>();
        List<Collects> lists = collectDao.getAllMyCollectsId(uid);
        if (lists == null || lists.size() == 0) {//没有收藏
            return goodsList;
        }
        for (int i = 0; i < lists.size(); i++) {
            iddLists.add(lists.get(i).getId());
        }
        goodsList = goodsDao.getAllMyCollectGoods(iddLists, uid);
        return goodsList;
    }
}
