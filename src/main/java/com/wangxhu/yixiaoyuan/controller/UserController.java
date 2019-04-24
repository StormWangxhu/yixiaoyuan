package com.wangxhu.yixiaoyuan.controller;

import com.wangxhu.yixiaoyuan.constant.UserConstant;
import com.wangxhu.yixiaoyuan.service.IUserService;
import com.wangxhu.yixiaoyuan.utils.common.WeChatUtil;
import com.wangxhu.yixiaoyuan.utils.result.Result;
import com.wangxhu.yixiaoyuan.utils.result.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 11:17
 * @Email: StormWangxhu@163.com
 * @Description: 用户控制器UserController
 */


@Api(value = "api/user", description = UserConstant.CONTROLLER_DESC)
@RequestMapping("api/user")
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired//从spring容器中自动注入，会发现我在UserServiceImpl类处添加了@Service注解
    private IUserService userService;

    @Autowired
    private WeChatUtil weChatUtil;


    @ApiOperation(value = UserConstant.LOGIN_DESC, httpMethod = "POST")
    @PostMapping("/login")
    public Result<Object> login(@RequestBody String param) throws Exception {
//        String code = userService.getCode(param);
//        String openId = weChatUtil.getOpenId(code);
//        Map<String, Integer> datas = userService.isLoginSuccess(openId);

        return ResultBuilder.success();
    }


}