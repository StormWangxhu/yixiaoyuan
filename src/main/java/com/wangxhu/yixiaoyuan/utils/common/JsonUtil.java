package com.wangxhu.yixiaoyuan.utils.common;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxhu.yixiaoyuan.constant.CommonConstant;

import java.io.IOException;

/**
 * Json工具类
 */
public class JsonUtil {
    /**
     * 将对象转为json
     *
     * @param object obj
     * @return json
     * @throws JsonProcessingException nothing
     */
    public static String object2Json(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    /**
     * 将json转为指定对象
     *
     * @param json  json
     * @param clazz 指定实体
     * @return 实体对象
     * @throws IOException io
     */
    public static <T> T json2Object(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }


    public static String JsonCode(String jsonCode) {
        JSONObject jsonObject = JSONObject.parseObject(jsonCode);
        String code = jsonObject.getString("code");
        if (ObjectUtil.isStringEmpty(code)) {
            return CommonConstant.OPENID_NULL;
        } else {
            return code;
        }
    }

}