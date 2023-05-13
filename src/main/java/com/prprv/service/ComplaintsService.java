package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Complaints;

/**
 * 投诉管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 * @see ComplaintsServiceImpl
 */
public interface ComplaintsService {

    /**
     * 创建投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    Result<Object> createComplaints(Complaints complaints);

    /**
     * 查询投诉记录
     * @param id 投诉编号
     * @return Result
     */
    Result<Object> getComplaintsById(Long id);

    /**
     * 分页查询投诉记录
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    Result<Object> getAllComplaintsByPage(Integer page, Integer size);

    /**
     * 查询所有投诉记录
     * @return Result
     */
    Result<Object> getAllComplaints();
    /**
     * 处理投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    Result<Object> updateComplaints(Complaints complaints);

    /**
     * 删除投诉记录
     * @param id 投诉编号
     * @return Result
     */
    Result<Object> deleteComplaints(Long id);
}
