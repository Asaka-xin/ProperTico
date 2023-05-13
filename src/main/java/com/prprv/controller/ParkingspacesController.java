package com.prprv.controller;

import com.prprv.entity.Parkingspaces;
import com.prprv.service.ParkingspacesService;
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
@RequestMapping("/parkingspaces")
public class ParkingspacesController {

    private final ParkingspacesService parkingspacesService;

    /**
     * 新增停车位
     * @param parkingspaces 停车位信息
     */
    @PostMapping("/create")
    public Object createParkingspaces(@RequestBody Parkingspaces parkingspaces){
        return parkingspacesService.createParkingspaces(parkingspaces);
    }

    /**
     * 查询所有停车位
     */
    @GetMapping("/findAll")
    public Object findAllParkingspaces(){
        return parkingspacesService.findAllParkingspaces();
    }

    /**
     * 分页查询停车位
     */
    @GetMapping("/findAllByPage")
    public Object findAllParkingspacesByPage(@RequestBody Integer page, Integer size){
//        Todo : 未完成,无法使用
        return null;
    }

    /**
     * 根据业主id查询停车位
     */
    @GetMapping("/findByOwner")
    public Object findParkingspacesByOwner(@RequestBody Long owner){
//        Todo : 未完成
        return null;
    }

    /**
     * 根据停车位编号删除停车位
     */
    @PostMapping("/deleteById")
    public Object deleteParkingspacesById(@RequestBody Parkingspaces parkingspaces){
//        Todo : 未测试
        return parkingspacesService.deleteParkingspacesById(parkingspaces);
    }
}
