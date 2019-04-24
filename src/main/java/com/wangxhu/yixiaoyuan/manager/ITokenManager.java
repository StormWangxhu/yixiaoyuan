package com.wangxhu.yixiaoyuan.manager;

import com.wangxhu.yixiaoyuan.model.TokenModel;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 19:47
 * @Email: StormWangxhu@163.com
 * @Description:
 */


public interface ITokenManager {

    /**
     * 根据uid和openId生成一个Token
     *
     * @param uid
     * @return
     */
    public TokenModel createToken(Integer uid);
}
