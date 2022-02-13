package com.passbook.passbook.service;

import com.passbook.passbook.vo.Response;

/**
 * 获取库存信息，只返回用户没有领取的，即优惠券库存功能实现接口定义
 */
public interface IInventoryService {

    /**
     * 获取库存信息
     * @param userId 用户 id
     * @return {@link Response}
     */
    Response getInventoryInfo(Long userId) throws Exception;
}
