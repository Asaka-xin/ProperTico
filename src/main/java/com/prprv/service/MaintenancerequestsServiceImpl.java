package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Maintenancerequests;
import com.prprv.mapper.MaintenancerequestsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 报修维护服务接口实现类
 * @author phj233
 * @since 2023/5/13 15:09
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MaintenancerequestsServiceImpl implements MaintenancerequestsService{
    final private MaintenancerequestsMapper maintenancerequestsMapper;

    /**
     * 创建报修记录
     *
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    @Override
    public Result<Object> createMaintenancerequests(Maintenancerequests maintenancerequests) {
        try{
            QueryWrapper<Maintenancerequests> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",maintenancerequests.getId());
            Maintenancerequests selectedMaintenancerequests = maintenancerequestsMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if(selectedMaintenancerequests != null){
                return ResultUtil.error(ResultEnum.REPAIR_DUPLICATE);
            }
            maintenancerequests.setId(null);
            maintenancerequestsMapper.insert(maintenancerequests);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("新增报修记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 更新报修状态
     *
     * @param maintenancerequests 报修维护信息
     * @return Result
     */
    @Override
    public Result<Object> updateMaintenancerequests(Maintenancerequests maintenancerequests) {
        try{
            maintenancerequestsMapper.updateById(maintenancerequests);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("更新报修记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 查询报修记录
     *
     * @return Result
     */
    @Override
    public Result<Object> getMaintenancerequests() {
        try {
            return ResultUtil.success(maintenancerequestsMapper.selectList(null));
        } catch (Exception e) {
            log.error("查询所有报修记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 分页查询报修记录
     *
     * @param page 页码
     * @param size 每页大小
     * @return Result
     */
    @Override
    public Result<Object> getAllMaintenancerequestsByPage(Integer page, Integer size) {
        try{
            Page<Maintenancerequests> maintenancerequestsPage = new Page<>(page,size);
            return ResultUtil.success(maintenancerequestsMapper.selectPage(maintenancerequestsPage,null));
        }catch (Exception e) {
            log.error("分页查询报修记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据工单编号查询报修记录
     *
     * @param id 工单编号
     * @return Result
     */
    @Override
    public Result<Object> getMaintenancerequestsById(Long id) {
        try{
            return ResultUtil.success(maintenancerequestsMapper.selectById(id));
        }catch (Exception e) {
            log.error("根据工单编号查询报修记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 删除报修记录
     *
     * @param id 工单编号
     * @return Result
     */
    @Override
    public Result<Object> deleteMaintenancerequestsById(Long id) {
        try{
            maintenancerequestsMapper.deleteById(id);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("删除报修记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
