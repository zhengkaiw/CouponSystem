package com.passbook.passbook.service;

import com.passbook.passbook.vo.Feedback;
import com.passbook.passbook.vo.Response;

/**
 * 评论功能，即用户评论相关功能实现
 */
public interface IFeedbackService {

    // 创建评论
    Response createFeedback(Feedback feedback);

    Response getFeedback(Long userId);
}
