package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Properties;

/**
 * 房产管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 */
public interface PropertiesService {

    /**
     * 新增房产
     * @param properties 房产信息
     * @return Result
     */
    Result<Object> createProperties(Properties properties);

    /**
     * 房产列表展示
     * @param properties 房产信息
     * @return Result
     */
    Result<Object> selectProperties(Properties properties);

    /**
     * 房产信息修改
     * @param properties 房产信息
     * @return Result
     */
    Result<Object> updateProperties(Properties properties);

    /**
     * 房产信息移除
     * @param properties 房产信息
     * @return Result
     */
    Result<Object> deleteProperties(Properties properties);
}
