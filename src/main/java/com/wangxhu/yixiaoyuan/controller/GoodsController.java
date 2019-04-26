package com.wangxhu.yixiaoyuan.controller;

import com.wangxhu.yixiaoyuan.constant.GoodsConstant;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
