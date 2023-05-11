package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Buildings;

/**
 * 楼栋管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 */
public interface BuildingsService {

    /**
     * 新增楼栋
     * @param buildings 楼栋信息
     * @return Result
     */
    Result<Object> createBuildings(Buildings buildings);

    /**
     * 楼栋列表展示
     * @param buildings 楼栋信息
     * @return Result
     */
    Result<Object> selectBuildings(Buildings buildings);

    /**
     * 楼栋信息修改
     * @param buildings 楼栋信息
     * @return Result
     */
    Result<Object> updateBuildings(Buildings buildings);

    /**
     * 楼栋信息移除
     * @param buildings 楼栋信息
     * @return Result
     */
    Result<Object> deleteBuildings(Buildings buildings);
}
