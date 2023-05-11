package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Visitors;

/**
 * 访客管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 */
public interface VisitorsService {

    /**
     * 创建访客记录
     * @param visitors 访客信息
     * @return Result
     */
    Result<Object> createVisitors(Visitors visitors);

    /**
     * 查询访客记录
     * @param visitors 访客信息
     * @return Result
     */
    Result<Object> getVisitors(Visitors visitors);
}
