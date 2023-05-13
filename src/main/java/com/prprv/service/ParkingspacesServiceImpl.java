package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Parkingspaces;
import com.prprv.mapper.ParkingspacesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 停车位接口服务层实现类
 * @author phj233
 * @since 2023/5/13 14:52
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ParkingspacesServiceImpl implements ParkingspacesService{
    final private ParkingspacesMapper parkingspacesMapper;
    /**
     * 新增停车位
     *
     * @param parkingspaces 停车位信息
     * @return Result
     */
    @Override
    public Result<Object> createParkingspaces(Parkingspaces parkingspaces) {
        try {
            QueryWrapper<Parkingspaces> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",parkingspaces.getId());
            Parkingspaces selectedParkingspaces = parkingspacesMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if(selectedParkingspaces != null){
                ResultUtil.error(ResultEnum.PARKING_DUPLICATE);
            }
            parkingspaces.setId(null);
            parkingspacesMapper.insert(parkingspaces);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("新增停车位失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 查询所有停车位
     *
     * @return Result
     */
    @Override
    public Result<Object> findAllParkingspaces() {
        try {
            return ResultUtil.success(parkingspacesMapper.selectList(null));
        } catch (Exception e) {
            log.error("查询所有停车位失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 分页查询停车位
     *
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> findAllParkingspacesByPage(Integer page, Integer size) {
        try {
            Page<Parkingspaces> parkingspacesPage = new Page<>(page,size);
            return ResultUtil.success(parkingspacesMapper.selectPage(parkingspacesPage,null));
        } catch (Exception e) {
            log.error("分页查询停车位失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据业主id查询停车位
     *
     * @param owner 业主id
     * @return Result
     */
    @Override
    public Result<Object> findParkingspacesByOwner(Long owner) {
        try {
            QueryWrapper<Parkingspaces> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("owner",owner);
            List<Parkingspaces> parkingspacesList = parkingspacesMapper.selectList(queryWrapper);
            queryWrapper.clear();
            return ResultUtil.success(parkingspacesList);
        } catch (Exception e) {
            log.error("根据业主id查询停车位失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据停车位编号查询停车位
     *
     * @param id 停车位编号
     * @return Result
     */
    @Override
    public Result<Object> findParkingspacesById(Long id) {
        try{
            return ResultUtil.success(parkingspacesMapper.selectById(id));
        }catch (Exception e) {
            log.error("根据停车位编号查询停车位失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据停车位编号删除停车位
     *
     * @param id 停车位编号
     * @return Result
     */
    @Override
    public Result<Object> deleteParkingspacesById(Long id) {
        try{
            parkingspacesMapper.deleteById(id);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("根据停车位编号删除停车位失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据停车位编号修改停车位信息
     *
     * @param parkingspaces 停车位信息
     * @return Result
     */
    @Override
    public Result<Object> updateParkingspaces(Parkingspaces parkingspaces) {
        try {
            parkingspacesMapper.updateById(parkingspaces);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("根据停车位编号修改停车位信息失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
