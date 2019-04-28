package com.wangxhu.yixiaoyuan.service;

import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-28 15:27
 * @Email: StormWangxhu@163.com
 * @Description:
 */
public interface ICollectService {

    /**
     * 添加我的收藏
     *
     * @param uid
     * @param uid_other
     * @param gid
     * @return
     */
    Map<String, String> insertCollects(Integer uid, Integer uid_other, Integer gid);

}
