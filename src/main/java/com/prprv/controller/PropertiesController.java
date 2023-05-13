package com.prprv.controller;

import com.prprv.common.result.Result;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Properties;
import com.prprv.service.PropertiesService;
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
@RequestMapping("/properties")
public class PropertiesController {

    private final PropertiesService propertiesService;

    /**
     * 新增房产
     * @param properties 房产信息
     * @return Object
     */
    @PostMapping("/create")
    public Object createProperties(@RequestBody Properties properties) {
        return propertiesService.createProperties(properties);
    }

    /**
     * 房产列表展示
     * @return Result
     */
    @GetMapping("/list")
    public Object selectProperties() {
        return propertiesService.selectProperties();
    }

    /**
     * 根据持有人查询房产
     * @param user 持有人名字
     * @return Result
     */
    @GetMapping("/user")
    public Object getPropertiesByUser(@RequestParam String user) {
//        Todo : 未完成
        return null;
    }

    /**
     * 根据ID查询房产
     */
    @GetMapping("/id")
    public Object getPropertiesById(@RequestParam Long id) {
//        Todo : 未完成
        return null;
    }

    /**
     * 分页查询房产
     */
    @GetMapping("/page")
    public Object findAllPropertiesByPage(@RequestParam Integer page, @RequestParam Integer size) {
//        Todo: 未完成
        return null;
    }

    /**
     * 房产信息修改
     * @param properties 房产信息
     * @return Result
     */
    @PostMapping("/update")
    public Object updateProperties(@RequestBody Properties properties) {
        return propertiesService.updateProperties(properties);
    }

    /**
     * 房产信息删除
     * @param id 房产id
     * @return Result
     */
    @PostMapping("/delete")
    public Object deleteProperties(@RequestParam Properties properties) {
        return propertiesService.deleteProperties(properties);
    }

}
