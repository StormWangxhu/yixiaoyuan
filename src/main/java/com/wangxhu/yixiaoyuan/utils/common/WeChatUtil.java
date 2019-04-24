package com.wangxhu.yixiaoyuan.utils.common;

import com.wangxhu.yixiaoyuan.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.naming.AuthenticationException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 15:13
 * @Email: StormWangxhu@163.com
 * @Description: 微信工具类
 */

@Component//@Component,@Service,@Controller,@Repository注解的类，并把这些类纳入进spring容器中管理
public class WeChatUtil {

    @Value("${wx.url}")//Spring用@Value(${properties})调用外面的配置，通过@Value(“${app.name}”)语法将属性文件的值注入bean属性值
    private String WECHAT_OPEN_URL;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 根据code获取openId
     *
     * @param code
     * @return
     * @throws Exception
     */
    public String getOpenId(String code) throws Exception {
        String url = null;//会抛出异常
        try {
            url = WECHAT_OPEN_URL + URLEncoder.encode(code, "UTF-8");
            ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
            if (result.getStatusCodeValue() != 200) {
                throw new AuthenticationException(CommonConstant.WECHAT_CONNECT_FAIL);
            }
            WechatResponseBody responseBody = JsonUtil.json2Object(result.getBody(), WechatResponseBody.class);
            return responseBody.getOpenid();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(CommonConstant.WECHAT_CONNECT_FAIL);
        }
    }
}

/**
 * 接受返回内容的内部类
 */
class WechatResponseBody {
    /**
     * succeed, info
     */
    private String openid;
    private String session_key;

    /**
     * failed, info
     */
    private String errcode;
    private String errmsg;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    String getOpenid() {
        return openid;
    }

    void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "WechatResponseBody{" +
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}

