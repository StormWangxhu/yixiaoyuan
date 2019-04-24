package com.wangxhu.yixiaoyuan.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: StormWangxhu
 * @Time: 2019-01-29 15:10
 * @Email: StormWangxhu@163.com
 * @Description: 加密工具类
 */
public class EncryptionUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(EncryptionUtil.class);

    public static String md5Encryption(String source){

        MessageDigest messageDigest = null;

        try {
            //返回md5算法的实例
            messageDigest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("加密出错:{}",e);
        }

        //得到16位随机数字
        byte[] bytes = messageDigest.digest(source.getBytes());

        //对数字进行加密成为字符串，相同的源字符串得到的相同的数字和加密字符串
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }
}
