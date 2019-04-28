package com.wangxhu.yixiaoyuan.controller;

import com.wangxhu.yixiaoyuan.annotation.Authorization;
import com.wangxhu.yixiaoyuan.annotation.CurrentUser;
import com.wangxhu.yixiaoyuan.constant.CollectConstant;
import com.wangxhu.yixiaoyuan.constant.CommonConstant;
import com.wangxhu.yixiaoyuan.constant.GoodsConstant;
import com.wangxhu.yixiaoyuan.constant.UserConstant;
import com.wangxhu.yixiaoyuan.model.Goods;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.ICollectService;
import com.wangxhu.yixiaoyuan.service.IGoodService;
import com.wangxhu.yixiaoyuan.utils.common.ObjectUtil;
import com.wangxhu.yixiaoyuan.utils.result.Result;
import com.wangxhu.yixiaoyuan.utils.result.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-26 15:57
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Api(value = "api/goods", description = GoodsConstant.GOODS_CONTROLLER_DESC)
@RequestMapping("api/goods")
@RestController
public class GoodsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private IGoodService goodService;

    @Autowired
    private ICollectService collectService;


    /**
     * 发布商品讯息
     *
     * @param loginUser
     * @param goods
     * @return
     */
    @Authorization
    @ApiOperation(value = GoodsConstant.PUBLISH_CONTROLLER_DESC, httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = UserConstant.AUTHORIZATION_TOKEN, required = true, paramType = "header")})
    @PutMapping("/publish")
    public Result<Object> publishGoods(@ApiIgnore @CurrentUser User loginUser, @RequestBody Goods goods) {
        goodService.save(loginUser, goods);
        return ResultBuilder.success();
    }


    /**
     * 获取当前用户的所有的发布，即我的发布
     *
     * @param loginUser
     * @return
     */
    @Authorization
    @ApiOperation(value = GoodsConstant.GET_PUBLISH_GOODS_DESC, httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "authorization", value = UserConstant.AUTHORIZATION_TOKEN, required = true, paramType = "header")})
    @GetMapping("/getPublish")
    public Result<List<Goods>> getAllPublishGoodsInfo(@ApiIgnore @CurrentUser User loginUser) {
        List<Goods> list = goodService.getAllPublishGoods(loginUser);
        if (list == null || list.size() == 0) {
            return ResultBuilder.fail(GoodsConstant.LIST_NULL);
        }
        return ResultBuilder.success(list);
    }


    /**
     * 更新页面浏览量
     *
     * @param gid
     * @param pageviews
     * @param loginUser
     * @return
     */
    @Authorization
    @ApiOperation(value = GoodsConstant.UPDATE_GOODS_PAGEVIEWS, httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "gid", value = GoodsConstant.GID, required = true
            , paramType = "path")
            , @ApiImplicitParam(name = "pageviews", value = GoodsConstant.PAGEVIEWS_DESC, required = true
            , paramType = "path")
            , @ApiImplicitParam(name = "authorization", value = UserConstant.AUTHORIZATION_TOKEN, required = true
            , paramType = "header")})
    @PutMapping("/update/pageviews/{gid}/{pageviews}")
    public Result<Object> updatePageViews(@PathVariable("gid") Integer gid,
                                          @PathVariable("pageviews") Integer pageviews,
                                          @ApiIgnore @CurrentUser User loginUser) {
        Integer uid = loginUser.getId();
        boolean result = goodService.updatePageviews(uid, gid, pageviews);
        if (result) {
            return ResultBuilder.success();
        }
        return ResultBuilder.fail();
    }


    /**
     * 用户添加我的收藏
     *
     * @param loginUser
     * @param uid_other
     * @param gid
     * @return
     */
    @Authorization
    @ApiOperation(value = GoodsConstant.ADD_USER_COLLECTIONS, httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "uid_other", value = CollectConstant.UID_OTHER, required = true
            , paramType = "path")
            , @ApiImplicitParam(name = "gid", value = CollectConstant.GID, required = true
            , paramType = "path")
            , @ApiImplicitParam(name = "authorization", value = UserConstant.AUTHORIZATION_TOKEN, required = true
            , paramType = "header")})
    @PutMapping("/insert/myCollects/{uid_other}/{gid}")
    public Result<Object> updateMyCollection(@ApiIgnore @CurrentUser User loginUser,
                                             Integer uid_other, Integer gid) {
        LOGGER.warn("用户添加我的收藏:{}", "uid_other : " + uid_other + "gid : " + gid);
        Integer uid = loginUser.getId();
        Map<String, String> datas = collectService.insertCollects(uid, uid_other, gid);
        if (!ObjectUtil.isEmpty(datas.get(CommonConstant.SUCCESS))) {
            return ResultBuilder.success();
        }
        return ResultBuilder.fail(datas.get(CommonConstant.FAIL));
    }

    @Authorization
    @ApiOperation(value = CommonConstant.CANCEL_COLLECT, httpMethod = "PUT")
    @ApiImplicitParams({@ApiImplicitParam(name = "gid", value = CollectConstant.GID, required = true
            , paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = UserConstant.AUTHORIZATION_TOKEN, required = true, paramType = "header")})
    @PutMapping("/update/cancelCollect/{gid}")
    public Result<Object> cancelCollect(@ApiIgnore @CurrentUser User loginUser, @PathVariable("gid") Integer gid) {
        LOGGER.warn("用户取消我的收藏:{}", "gid: " + gid);
        Integer uid = loginUser.getId();
        Map<String, String> datas = collectService.cancelCollect(uid, gid);
        if (!ObjectUtil.isEmpty(datas.get(CommonConstant.FAIL))) {
            return ResultBuilder.fail(datas.get(CommonConstant.FAIL));
        } else {
            return ResultBuilder.success();
        }
    }
}
