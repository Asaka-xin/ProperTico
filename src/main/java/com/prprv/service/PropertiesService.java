package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Properties;

/**
 * 房产管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 * @see PropertiesServiceImpl
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
     * @return Result
     */
    Result<Object> selectProperties();

    /**
     * 根据持有人查询房产
     * @param user 持有人名字
     * @return Result
     */
    Result<Object> getPropertiesByUser(String user);

    /**
     * 根据小区查询房产
     * @param estates 小区名字
     * @return Result
     */
    Result<Object> getPropertiesByEstates(String estates);

    /**
     * 房产信息查询
     * @param id 房产id
     * @return Result
     */
    Result<Object> getPropertiesById(Long id);

    /**
     * 分页查询房产
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    Result<Object> findAllPropertiesByPage(Integer page, Integer size);

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
