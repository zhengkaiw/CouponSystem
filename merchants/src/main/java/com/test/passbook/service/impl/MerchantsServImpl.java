package com.test.passbook.service.impl;

import com.test.passbook.constant.ErrorCode;
import com.test.passbook.dao.MerchantsDao;
import com.test.passbook.entity.Merchants;
import com.test.passbook.service.IMerchantsServ;
import com.test.passbook.vo.CreateMerchantsRequest;
import com.test.passbook.vo.CreateMerchantsResponse;
import com.test.passbook.vo.PassTemplate;
import com.test.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <h1>商户服务接口实现</h1>
 */
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {

    /** Merchants 数据库接口 */
    @Autowired
    private MerchantsDao merchantsDao;

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {
        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}
