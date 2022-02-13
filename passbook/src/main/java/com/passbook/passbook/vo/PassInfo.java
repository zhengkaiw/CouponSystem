package com.passbook.passbook.vo;

import com.passbook.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户领取的优惠券信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassInfo {

    // 优惠券
    private Pass pass;

    // 优惠券模板
    private PassTemplate passTemplate;

    // 商户信息
    private Merchants merchants;
}
