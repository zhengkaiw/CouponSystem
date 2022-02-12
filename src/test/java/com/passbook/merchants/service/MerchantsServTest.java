package com.passbook.merchants.service;

import com.alibaba.fastjson.JSON;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 商户服务测试类
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
//    @Transactional
    public void testCreateMerchants() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("test");
        request.setLogoUrl("www.test.com");
        request.setBusinessLicenseUrl("www.test.com");
        request.setPhone("123456789");
        request.setAddress("Beijing");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    @Test
    public void testBuildMerchantsInfoById() {

        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(19)));
    }

    @Test
    public void testDropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(19);
        passTemplate.setTitle("title: test");
        passTemplate.setSummary("summary: test");
        passTemplate.setDesc("desc: test");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}
