package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Estates;

/**
 * 小区服务管理接口
 * @author Christine
 * @since 2023/5/11
 * @see Estates 小区实体类
 * @see EstatesServiceImpl 小区服务实现类
 */
public interface EstatesService {

    /**
     * 新增小区
     * @param estates 小区信息
     * @return Result
     */
    Result<Object> createEstates(Estates estates);

    /**
     * 更新小区信息
     * @param estates 小区信息
     * @return Result
     */
    Result<Object> updateEstates(Estates estates);

    /**
     * 删除小区信息
     * @param estatesId 小区id
     * @return Result
     */
    Result<Object> deleteEstatesById(Long estatesId);

    /**
     * 小区信息展示
     * @return Result
     */
    Result<Object> selectEstates();

    /**
     * 分页查询小区信息
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    Result<Object> selectAllEstatesByPage(Integer page, Integer size);

    /**
     * 根据小区id查询小区信息
     * @param estatesId 小区id
     * @return Result
     */
    Result<Object> selectEstatesById(Long estatesId);
}
