package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Parkingspaces;

/**
 * 停车位管理服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 * @see ParkingspacesServiceImpl
 */
public interface ParkingspacesService {
    /**
     * 新增停车位
     * @param parkingspaces 停车位信息
     * @return Result
     */
    Result<Object> createParkingspaces(Parkingspaces parkingspaces);

    /**
     * 查询所有停车位
     * @return Result
     */
    Result<Object> findAllParkingspaces();

    /**
     * 分页查询停车位
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    Result<Object> findAllParkingspacesByPage(Integer page, Integer size);

    /**
     * 根据业主id查询停车位
     * @param owner 业主id
     * @return Result
     */
    Result<Object> findParkingspacesByOwner(Long owner);

    /**
     * 根据停车位编号查询停车位
     * @param id 停车位编号
     * @return Result
     */
    Result<Object> findParkingspacesById(Long id);

    /**
     * 根据停车位编号删除停车位
     * @param id 停车位编号
     * @return Result
     */
    Result<Object> deleteParkingspacesById(Parkingspaces parkingspaces);

    /**
     * 根据停车位编号修改停车位信息
     * @param parkingspaces 停车位信息
     * @return Result
     */
    Result<Object> updateParkingspaces(Parkingspaces parkingspaces);
}
