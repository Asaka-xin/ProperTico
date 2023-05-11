package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Maintenancerequests;

/**
 * 报修维护服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 */
public interface MaintenancerequestsService {

    /**
     * 创建报修记录
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    Result<Object> createMaintenancerequests(Maintenancerequests maintenancerequests);

    /**
     * 处理报修记录
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    Result<Object> updateMaintenancerequests(Maintenancerequests maintenancerequests);

    /**
     * 查询报修记录
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    Result<Object> getMaintenancerequests(Maintenancerequests maintenancerequests);

    /**
     * 删除报修记录
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    Result<Object> deleteMaintenancerequests(Maintenancerequests maintenancerequests);
}
