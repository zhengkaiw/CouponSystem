package com.passbook.passbook.service;

import com.passbook.passbook.vo.Response;
import com.passbook.passbook.vo.User;

/**
 * 用户服务，创建 User 服务
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     */
    Response createUser(User user) throws Exception;
}
