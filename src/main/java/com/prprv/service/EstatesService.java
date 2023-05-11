package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Estates;

/**
 * 小区服务管理接口
 * @author Christine
 * @since 2023/5/11
 * @see Estates
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
     * @param estates 小区信息
     * @return Result
     */
    Result<Object> deleteEstates(Estates estates);

    /**
     * 小区信息展示
     * @param estates 小区信息
     * @return Result
     */
    Result<Object> selectEstates(Estates estates);

}
