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

    /**
     * 从字符串中解析出token
     *
     * @param authorization 加密后的字符串
     * @return
     */
    TokenModel getToken(String authorization);

    /**
     * 检查token是否有效
     * @param model token
     * @return
     */
    boolean checkToken(TokenModel model);
}
