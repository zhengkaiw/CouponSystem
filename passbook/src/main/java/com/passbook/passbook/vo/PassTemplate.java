package com.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 投放的优惠券对象定义
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    // 所属商户 id
    private Integer id;

    // 优惠券标题
    private String title;

    // 优惠券摘要
    private String summary;

    // 优惠券详细信息
    private String desc;

    // 最大个数限制
    private Long limit;

    // 优惠券是否有 Token，用于商户核销
    private Boolean hasToken; // token 存储于 Redis Set 中，每次领取从 Redis 中获取

    // 优惠券背景色
    private Integer background;

    // 优惠券开始时间
    private Date start;

    // 优惠券结束时间
    private Date end;
}
