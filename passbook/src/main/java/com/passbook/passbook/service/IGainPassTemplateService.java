package com.passbook.passbook.service;

import com.passbook.passbook.vo.GainPassTemplateRequest;
import com.passbook.passbook.vo.Response;

/**
 * 用户领取优惠券功能实现接口
 */
public interface IGainPassTemplateService {

    /**
     * 用户领取优惠券
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}
