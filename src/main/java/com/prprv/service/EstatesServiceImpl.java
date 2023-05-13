package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Estates;
import com.prprv.mapper.EstatesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 小区服务实现类
 * @author phj233
 * @since 2023/5/13 15:17
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EstatesServiceImpl implements EstatesService {
    final private EstatesMapper estatesMapper;

    /**
     * 新增小区
     * @param estates 小区信息
     * @return Result
     */
    @Override
    public Result<Object> createEstates(Estates estates) {
        try {
            QueryWrapper<Estates> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", estates.getId());
            Estates selectedEstates = estatesMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if (selectedEstates != null) {
                return ResultUtil.error(ResultEnum.PROPERTY_DUPLICATE);
            }
            estates.setId(null);
            estatesMapper.insert(estates);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("新增小区失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据ID更新小区信息
     * @param estates 小区信息
     * @return Result
     */
    @Override
    public Result<Object> updateEstates(Estates estates) {
        try {
            estatesMapper.updateById(estates);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("更新小区信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据ID删除小区信息
     * @param estates 小区id
     * @return Result
     */
    @Override
    public Result<Object> deleteEstatesById(Estates estates) {
        Estates selectedEstates = estatesMapper.selectById(estates.getId());
        if (selectedEstates == null) {
            return ResultUtil.error(ResultEnum.PROPERTY_NOT_FOUND);
        }
        try {
            estatesMapper.deleteById(estates.getId());
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("删除小区信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 小区信息展示
     * @return Result
     */
    @Override
    public Result<Object> selectEstates() {
        try {
            return ResultUtil.success(estatesMapper.selectList(null));
        } catch (Exception e) {
            log.error("小区信息展示失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 分页查询小区信息
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> selectAllEstatesByPage(Integer page, Integer size) {
        try {
            Page<Estates> estatesPage = new Page<>(page, size);
            return ResultUtil.success(estatesMapper.selectPage(estatesPage, null));
        } catch (Exception e) {
            log.error("分页查询小区信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据小区id查询小区信息
     * @param estatesId 小区id
     * @return Result
     */
    @Override
    public Result<Object> selectEstatesById(Long estatesId) {
        try {
            return ResultUtil.success(estatesMapper.selectById(estatesId));
        } catch (Exception e) {
            log.error("根据小区id查询小区信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
