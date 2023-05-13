package com.prprv.controller;

import com.prprv.entity.Estates;
import com.prprv.service.EstatesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/5/13
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/estates")
public class EstatesController {

    private final EstatesService estatesService;

    /**
     * 新增小区接口
     * @param estates 小区信息
     * @return object
     */
    @PostMapping("/create")
    public Object createEstates(@RequestBody Estates estates) {
        return estatesService.createEstates(estates);
    }

    /**
     * 根据ID更新小区信息
     * @param estates 小区信息
     * @return object
     */
    @PostMapping("/update")
    public Object updateEstates(@RequestBody Estates estates) {
        return estatesService.updateEstates(estates);
    }

    /**
     * 根据ID删除小区信息
     * @param estates 小区ID
     * @return object
     */
    @GetMapping("/delete")
    public Object deleteEstates(@RequestBody Estates estates) {
        return estatesService.deleteEstatesById(estates);
    }

    /**
     * 查询小区信息
     * @return object
     */
    @GetMapping("/select")
    public Object selectEstates() {
        return estatesService.selectEstates();
    }

}
