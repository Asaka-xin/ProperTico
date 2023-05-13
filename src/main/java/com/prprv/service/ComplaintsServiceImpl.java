package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Complaints;
import com.prprv.mapper.ComplaintsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 投诉管理服务实现类
 * @author phj233
 * @since 2023/5/13 15:22
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ComplaintsServiceImpl implements ComplaintsService{
    final private ComplaintsMapper complaintsMapper;

    /**
     * 创建投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    @Override
    public Result<Object> createComplaints(Complaints complaints) {
        try {
            QueryWrapper<Complaints> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", complaints.getId());
            Complaints selectedComplaints = complaintsMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if (selectedComplaints != null) {
                return ResultUtil.error(ResultEnum.COMPLAINT_DUPLICATE);
            }
            complaintsMapper.insert(complaints);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("创建投诉记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据ID查询投诉记录
     * @param id 投诉编号
     * @return Result
     */
    @Override
    public Result<Object> getComplaintsById(Long id) {
        try {
            return ResultUtil.success(complaintsMapper.selectById(id));
        }catch (Exception e) {
            log.error("查询投诉记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 分页查询投诉记录
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> getAllComplaintsByPage(Integer page, Integer size) {
        try {
            Page<Complaints> complaintsPage = new Page<>(page, size);
            return ResultUtil.success(complaintsMapper.selectPage(complaintsPage, null));
        }catch (Exception e) {
            log.error("分页查询投诉记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 查询所有投诉记录
     * @return Result
     */
    @Override
    public Result<Object> getAllComplaints() {
        try {
            return ResultUtil.success(complaintsMapper.selectList(null));
        }catch (Exception e) {
            log.error("查询所有投诉记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 处理投诉记录
     * @param complaints 投诉信息
     * @return Result
     */
    @Override
    public Result<Object> updateComplaints(Complaints complaints) {
        try {
            complaintsMapper.updateById(complaints);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("处理投诉记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 删除投诉记录
     * @param id 投诉编号
     * @return Result
     */
    @Override
    public Result<Object> deleteComplaints(Long id) {
        try {
            complaintsMapper.deleteById(id);
            return ResultUtil.success();
        }catch (Exception e) {
            log.error("删除投诉记录失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
