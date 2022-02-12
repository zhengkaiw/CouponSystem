package com.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户响应对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMerchantsResponse {

    // 商户 id，创建失败返回 -1
    private Integer id;
}
