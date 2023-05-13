package com.prprv.controller;

import com.prprv.entity.Maintenancerequests;
import com.prprv.service.MaintenancerequestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/5/14
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/maintenancerequests")
public class MaintenancerequestsController {

    private final MaintenancerequestsService maintenancerequestsService;

    /**
     * 创建报修记录
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    @PostMapping("/create")
    public Object createMaintenancerequests(@RequestBody Maintenancerequests maintenancerequests) {
        return maintenancerequestsService.createMaintenancerequests(maintenancerequests);
    }

    /**
     * 更新报修状态
     * @return Result
     */
    @PostMapping("/update")
    public Object updateMaintenancerequests(@RequestBody Maintenancerequests maintenancerequests) {
        return maintenancerequestsService.updateMaintenancerequests(maintenancerequests);
    }

    /**
     * 查询报修记录
     */
    @GetMapping("/list")
    public Object getMaintenancerequests() {
        return maintenancerequestsService.getMaintenancerequests();
    }

    /**
     * 删除报修记录
     */
    @PostMapping("/delete")
    public Object deleteMaintenancerequestsById(@RequestBody Maintenancerequests maintenancerequests) {
        return maintenancerequestsService.deleteMaintenancerequestsById(maintenancerequests);
    }

    /**
     * 分页查询报修记录
     */
    @GetMapping("/list/{page}/{size}")
    public Object getAllMaintenancerequestsByPage() {
//        Todo : 待完成
        return null;
    }

    /**
     * 根据工单编号查询报修记录
     * @param id 工单编号
     * @return Result
     */
    @GetMapping("/list/{id}")
    public Object getMaintenancerequestsById() {
//        Todo : 待完成
        return null;
    }
}
