package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Payments;

/**
 * 缴费管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 */
public interface PaymentsService {

    /**
     * 创建缴费记录
     * @param payments 缴费信息
     * @return Result
     */
    Result<Object> createPayments(Payments payments);

    /**
     * 查询缴费记录
     * @param payments 缴费信息
     * @return Result
     */
    Result<Object> getPayments(Payments payments);
}
