package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Complaints;

/**
 * 投诉管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
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
     * @param complaints 投诉信息
     * @return Result
     */
    Result<Object> getComplaints(Complaints complaints);

    /**
     * 处理投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    Result<Object> updateComplaints(Complaints complaints);

    /**
     * 删除投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    Result<Object> deleteComplaints(Complaints complaints);
}
