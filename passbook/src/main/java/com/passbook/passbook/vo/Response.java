package com.passbook.passbook.vo;

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

    // 空响应
    public static Response success() {
        return new Response();
    }

    // 错误响应
    public static Response failure(String errorMsg) {
        return new Response(-1, errorMsg, null);
    }
}
