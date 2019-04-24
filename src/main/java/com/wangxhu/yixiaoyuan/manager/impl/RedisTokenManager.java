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
}
