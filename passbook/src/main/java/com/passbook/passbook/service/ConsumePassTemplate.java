package com.passbook.passbook.service;

import com.alibaba.fastjson.JSON;
import com.passbook.passbook.constant.Constants;
import com.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消费 Kafka 中的 PassTemplate
 */
@Slf4j
@Component
public class ConsumePassTemplate {

    // Pass 相关的 HBase 服务
    private final IHBasePassService passService;

    @Autowired
    public ConsumePassTemplate(IHBasePassService passService) {
        this.passService = passService;
    }

    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})
    public void receive(@Payload String passTemplate,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID)int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC)String topic) {
        log.info("Consume Receive PassTemplate: {}", passTemplate);

        PassTemplate pt;

        try {
            pt = JSON.parseObject(passTemplate, PassTemplate.class);
        } catch (Exception e) {
            log.error("Parse PassTemplate Error: {}", e.getMessage());
            return;
        }

        log.info("DropPassTemplateToHBase: {}", passService.dropPassTemplateToHBase(pt));
    }
}
