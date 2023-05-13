package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.Maintenancerequests;

/**
 * 报修维护服务接口
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 * @see MaintenancerequestsServiceImpl
 */
public interface MaintenancerequestsService {

    /**
     * 创建报修记录
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    Result<Object> createMaintenancerequests(Maintenancerequests maintenancerequests);

    /**
     * 更新报修状态
     * @return Result
     */
    Result<Object> updateMaintenancerequests(Maintenancerequests maintenancerequests);

    /**
     * 查询报修记录
     * @return Result
     */
    Result<Object> getMaintenancerequests();

    /**
     * 分页查询报修记录
     * @return Result
     */
    Result<Object> getAllMaintenancerequestsByPage(Integer page, Integer size);

    /**
     * 根据工单编号查询报修记录
     * @param id 工单编号
     * @return Result
     */
    Result<Object> getMaintenancerequestsById(Long id);
    /**
     * 删除报修记录
     *
     * @param id 工单编号
     * @return Result
     */
    Result<Object> deleteMaintenancerequestsById(Maintenancerequests maintenancerequests);
}
