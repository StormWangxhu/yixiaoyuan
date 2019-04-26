package com.wangxhu.yixiaoyuan.dao;

import com.wangxhu.yixiaoyuan.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-25 20:04
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAddressDaoTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(IAddressDaoTest.class);

    @Autowired
    private IAddressDao addressDao;

    /**
     * 根据uid查询用户地址
     */
    @Test
    public void getAllGoodsAddressTest() {
        Integer uid = 1;
        List<Address> address = addressDao.getAllGoodsAddress(uid);
        LOGGER.warn("测试结果:{}", address);
    }

    @Test
    public void saveTest(){
        Address address = new Address();
        address.setUid(3);
        address.setProvince("宁夏回族自治区");
        address.setDetailedAddress("吴忠市红寺堡开发区");
        address.setIsDefault(1);
        addressDao.save(address);
        LOGGER.warn("保存成功！");
    }

}
