package com.test.passbook.service;

import com.alibaba.fastjson.JSON;
import com.test.passbook.vo.CreateMerchantsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>商户服务测试类</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
    public void testCreateMerchantsServ() {
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("test");
        request.setLogoUrl("www.test.com");
        request.setBusinessLicenseUrl("www.test.com");
        request.setPhone("1234567890");
        request.setAddress("Beijing");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }
}
