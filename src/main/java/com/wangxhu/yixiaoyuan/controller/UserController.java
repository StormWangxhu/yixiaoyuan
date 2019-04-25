package com.wangxhu.yixiaoyuan.controller;

import com.wangxhu.yixiaoyuan.annotation.Authorization;
import com.wangxhu.yixiaoyuan.annotation.CurrentUser;
import com.wangxhu.yixiaoyuan.constant.UserConstant;
import com.wangxhu.yixiaoyuan.manager.ITokenManager;
import com.wangxhu.yixiaoyuan.model.Address;
import com.wangxhu.yixiaoyuan.model.TokenModel;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.IAddressService;
import com.wangxhu.yixiaoyuan.service.IUserService;
import com.wangxhu.yixiaoyuan.utils.common.WeChatUtil;
import com.wangxhu.yixiaoyuan.utils.result.Result;
import com.wangxhu.yixiaoyuan.utils.result.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-24 11:17
 * @Email: StormWangxhu@163.com
 * @Description: 用户控制器UserController
 */


@Api(value = "api/user", description = UserConstant.CONTROLLER_DESC)//协议集描述
@RequestMapping("api/user")
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired//从spring容器中自动注入，会发现我在UserServiceImpl类处添加了@Service注解
    private IUserService userService;

    @Autowired
    private WeChatUtil weChatUtil;

    @Autowired
    private ITokenManager tokenManager;

    @Autowired
    private IAddressService addressService;

    /**
     * 用户登录
     *
     * @param code
     * @return
     * @throws Exception
     */
    @ApiOperation(value = UserConstant.LOGIN_DESC, httpMethod = "POST")//协议描述
    @PostMapping("/login")
    public Result<TokenModel> login(@RequestBody String code) throws Exception {
        LOGGER.info("用户登录code：{}", code);
        System.out.println("用户登录code:" + code);
        String openId = weChatUtil.getOpenId(code);
        User user = userService.login(openId);
        Integer uid = user.getId();
        //根据uid获取token
        TokenModel tokenModel = tokenManager.createToken(uid);
        //将uid和token返回给前端
        return ResultBuilder.success(tokenModel);
    }


    /**
     * 保存用户新增的收获地址
     *
     * @param addressParam
     * @param loginUser
     * @return
     */
    @Authorization//自定义注解，在拦截器中检查token中需要用到。每个方法都需要加这个注解进行权限的验证
    @ApiOperation(value = UserConstant.INSERT_NEW_GOODS_ADDRESS, httpMethod = "PUT")
    @PutMapping("/addAddress")
    public Result<Object> saveGoodsAddress(@RequestBody Address addressParam, @ApiIgnore @CurrentUser User loginUser) {
        boolean result = addressService.insertAddress(loginUser, addressParam);
        return ResultBuilder.success();
    }


    /**
     * 获取用户所有的收获地址
     *
     * @param loginUser
     * @return
     */
    @Authorization
    @ApiOperation(value = UserConstant.GET_ADDTESS_LIAT, httpMethod = "GET")
    @GetMapping("/getAllGoodsAddress")
    public Result<List<Address>> getAllGoodsAddress(@ApiIgnore @CurrentUser User loginUser) {
        Integer uid = loginUser.getId();
        List<Address> addressList = addressService.getAllGoodsAddress(uid);
        if (addressList.size() == 0 || addressList == null) {
            return ResultBuilder.fail(UserConstant.NO_RECORD);
        }
        return ResultBuilder.success(addressList);
    }


    /**
     * 获取用户信息
     *
     * @param loginUser
     * @return
     */
    @Authorization
    @ApiOperation(value = UserConstant.GET_USER_INFO, httpMethod = "GET")
    @GetMapping("/getInfo")
    public Result<User> getUserInfo(@ApiIgnore @CurrentUser User loginUser) {
        Integer uid = loginUser.getId();
        User user = userService.getUserInfo(uid);
        if (user == null) {
            return ResultBuilder.fail(UserConstant.USER_NOT_EXIST);
        }
        return ResultBuilder.success(user);
    }

}
