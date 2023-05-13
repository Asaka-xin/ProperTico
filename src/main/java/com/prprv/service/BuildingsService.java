package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Buildings;

/**
 * 楼栋管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 * @see BuildingsServiceImpl
 */
public interface BuildingsService {

    /**
     * 新增楼栋
     * @param buildings 楼栋信息
     * @return Result
     */
    Result<Object> createBuildings(Buildings buildings);

    /**
     * 根据楼栋编号查询楼栋信息
     * @param id 楼栋编号
     * @return Result
     */
    Result<Object> selectBuildingsById(Long id);

    /**
     * 楼栋列表分页展示
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    Result<Object> selectBuildingsByPage(Integer page, Integer size);

    /**
     * 查询所有楼栋信息
     * @return Result
     */
    Result<Object> selectBuildings();

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
    Result<Object> deleteBuildingsById(Buildings buildings);
}
