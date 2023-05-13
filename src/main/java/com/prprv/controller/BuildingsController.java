package com.prprv.controller;

import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Buildings;
import com.prprv.service.BuildingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/5/13
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/buildings")
public class BuildingsController {

    private final BuildingsService buildingsService;

    /**
     * 新增楼栋
     * @param buildings 楼栋信息
     * @return Result
     */
    @PostMapping("/create")
    public Object createBuildings(@RequestBody Buildings buildings) {
        return ResultUtil.success(buildingsService.createBuildings(buildings));
    }

    /**
     * 查询所有楼栋信息
     * @return Result
     */
    @GetMapping("/list")
    public Object selectBuildingsList() {
        return ResultUtil.success(buildingsService.selectBuildings());
    }

    /**
     * 根据ID更新楼栋信息
     * @param buildings 楼栋信息
     * @return Result
     */
    @PostMapping("/update")
    public Object updateBuildings(@RequestBody Buildings buildings) {
        return ResultUtil.success(buildingsService.updateBuildings(buildings));
    }

    /**
     * 根据ID删除楼栋信息
     * @param buildings 楼栋ID
     */
    @GetMapping("/delete")
    public Object deleteBuildings(@RequestBody Buildings buildings) {
        return buildingsService.deleteBuildingsById(buildings);
    }

    /**
     * 根据ID查询楼栋信息
     * @return Result
     */
    @GetMapping("/select")
    public Object selectBuildingsById() {
//        Todo: 2023/5/13 待完成
        return null;
    }

    /**
     * 楼栋列表分页展示
     * @return Result
     */
    @GetMapping("/listPage")
    public Object selectBuildingsListPage() {
//        Todo: 2023/5/13 待完成
        return null;
    }
}
