package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Buildings;
import com.prprv.mapper.BuildingsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 楼栋管理服务接口实现类
 * @author phj233
 * @since 2023/5/13 15:31
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BuildingsServiceImpl implements BuildingsService{
    final private BuildingsMapper buildingsMapper;

    /**
     * 新增楼栋
     *
     * @param buildings 楼栋信息
     * @return Result
     */
    @Override
    public Result<Object> createBuildings(Buildings buildings) {
        try {
            QueryWrapper<Buildings> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", buildings.getId());
            Buildings selectedBuildings = buildingsMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if (selectedBuildings != null) {
                return ResultUtil.error(ResultEnum.BUILDING_DUPLICATE);
            }
            buildings.setId(null);
            buildingsMapper.insert(buildings);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("新增楼栋失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据楼栋编号查询楼栋信息
     *
     * @param id 楼栋编号
     * @return Result
     */
    @Override
    public Result<Object> selectBuildingsById(Long id) {
        try {
            return ResultUtil.success(buildingsMapper.selectById(id));
        } catch (Exception e) {
            log.error("查询楼栋信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 楼栋列表分页展示
     *
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> selectBuildingsByPage(Integer page, Integer size) {
        try {
            Page<Buildings> buildingsPage = new Page<>(page, size);
            return ResultUtil.success(buildingsMapper.selectPage(buildingsPage, null));
        } catch (Exception e) {
            log.error("查询楼栋列表失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 查询所有楼栋信息
     *
     * @return Result
     */
    @Override
    public Result<Object> selectBuildings() {
        try {
            return ResultUtil.success(buildingsMapper.selectList(null));
        } catch (Exception e) {
            log.error("查询楼栋列表失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 楼栋信息修改
     *
     * @param buildings 楼栋信息
     * @return Result
     */
    @Override
    public Result<Object> updateBuildings(Buildings buildings) {
        try {
            buildingsMapper.updateById(buildings);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("修改楼栋信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 楼栋信息移除
     *
     * @param id 楼栋编号
     * @return Result
     */
    @Override
    public Result<Object> deleteBuildingsById(Long id) {
        try {
            buildingsMapper.deleteById(id);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("删除楼栋信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
