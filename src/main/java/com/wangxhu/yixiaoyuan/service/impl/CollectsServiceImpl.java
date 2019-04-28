package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.constant.CollectConstant;
import com.wangxhu.yixiaoyuan.constant.CommonConstant;
import com.wangxhu.yixiaoyuan.constant.DBConstant;
import com.wangxhu.yixiaoyuan.dao.ICollectDao;
import com.wangxhu.yixiaoyuan.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
