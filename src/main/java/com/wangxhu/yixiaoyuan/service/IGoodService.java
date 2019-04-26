package com.wangxhu.yixiaoyuan.service;

import com.wangxhu.yixiaoyuan.model.Goods;
import com.wangxhu.yixiaoyuan.model.User;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-26 16:13
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public interface IGoodService {

    /**
     * 保存发布的商品信息
     * @param loginUser
     * @param goods
     */
    void save(User loginUser, Goods goods);
}
