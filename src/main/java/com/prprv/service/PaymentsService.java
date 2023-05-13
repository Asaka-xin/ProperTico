package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Payments;

/**
 * 缴费管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 * @see PaymentsServiceImpl
 */
public interface PaymentsService {

    /**
     * 创建缴费记录
     * @param payments 缴费信息
     * @return Result
     */
    Result<Object> createPayments(Payments payments);

    /**
     * 查询所有缴费记录
     * @return Result
     */
    Result<Object> findAllPayments();

    /**
     * 分页查询缴费记录
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    Result<Object> findAllPaymentsByPage(Integer page, Integer size);

    /**
     * 根据缴费人查询缴费记录
     * @param user 缴费户号
     * @return Result
     */
    Result<Object> findPaymentsByUser(String user);

    /**
     * 删除缴费记录
     * @param id 缴费编号
     */
    Result<Object> deletePaymentsById(Long id);


}
