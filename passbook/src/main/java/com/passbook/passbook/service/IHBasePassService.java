package com.passbook.passbook.service;

import com.passbook.passbook.vo.PassTemplate;

/**
 * Pass HBase 服务
 */
public interface IHBasePassService {

    /**
     * 将 PassTemplate 写入 HBase
     * @param passTemplate {@link PassTemplate}
     * @return ture/false
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
