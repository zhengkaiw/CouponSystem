package com.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 库存请求响应
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    // 用户 id
    private Long userId;

    // 优惠券模板信息
    private List<PassTemplateInfo> passTemplateInfos;
}
