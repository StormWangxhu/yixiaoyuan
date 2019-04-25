package com.wangxhu.yixiaoyuan.manager.impl;

import com.wangxhu.yixiaoyuan.constant.TokenConstant;
import com.wangxhu.yixiaoyuan.manager.ITokenManager;
import com.wangxhu.yixiaoyuan.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 19:48
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Component
@Service
public class RedisTokenManager implements ITokenManager {

    private RedisTemplate<Integer, String> redisTemplate;

    @Autowired
    private void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());//序列化方式
    }

    /**
     * 创建token，并和uid绑定
     * 用到了redis中的String值类型。
     *
     * @param uid
     * @return
     */
    @Override
    public TokenModel createToken(Integer uid) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel tokenModel = new TokenModel(uid, token);
        redisTemplate.boundValueOps(uid).set(token, TokenConstant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return tokenModel;
    }

    /**
     * 解析出token
     *
     * @param authorization 加密后的字符串
     * @return
     */
    @Override
    public TokenModel getToken(String authorization) {
        if (authorization == null || authorization.length() == 0) {
            return null;
        }
        String[] param = authorization.split("_");
        if (param.length != 2) {
            return null;
        }
        Integer uid = Integer.parseInt(param[0]);
        String token = param[1];
        return new TokenModel(uid, token);
    }

    /**
     * 检查token是否有效
     *
     * @param model token
     * @return
     */
    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redisTemplate.boundValueOps(model.getUid()).get();
        if (token == null || !token.trim().equals(model.getToken())) {
            return false;
        }
        //检查成功，说明用户进行了一次有效操作，延长过期时间
        redisTemplate.boundValueOps(model.getUid()).expire(TokenConstant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }
}
