package com.wangxhu.yixiaoyuan.service.impl;

import com.wangxhu.yixiaoyuan.dao.IAddressDao;
import com.wangxhu.yixiaoyuan.model.Address;
import com.wangxhu.yixiaoyuan.model.User;
import com.wangxhu.yixiaoyuan.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StormWangxhu
 * @Time: 2019-04-25 11:45
 * @Email: StormWangxhu@163.com
 * @Description:
 */

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressDao addressDao;

    @Override
    public boolean insertAddress(User loginUser, Address addressParam) {
        Address address = new Address();
        address.setProvince(addressParam.getProvince());
        address.setDetailedAddress(addressParam.getDetailedAddress());
        address.setUid(loginUser.getId());
        address.setIsDefault(addressParam.getIsDefault());
        addressDao.save(address);
        return true;
    }

    /**
     * 根据Uid查询用户的所有的收货地址
     * TODO
     * 此处是否可以优化在数据库层面批量查询，减少代码层面循环
     *
     * @param uid
     * @return
     */
    @Override
    public List<Address> getAllGoodsAddress(Integer uid) {
        List<Address> list = addressDao.getAllGoodsAddress(uid);
        return list;
    }
}
