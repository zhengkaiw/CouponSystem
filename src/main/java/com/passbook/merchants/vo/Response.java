package com.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的响应对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer errorCode = 0;

    private String errorMsg = "";

    private Object data;

    public Response(Object data) {
        this.data = data;
    }
}
