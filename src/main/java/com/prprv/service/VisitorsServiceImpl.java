package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Visitors;
import com.prprv.mapper.VisitorsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 访客管理服务接口
 * @author phj233
 * @since 2023/5/12 16:46
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class VisitorsServiceImpl implements VisitorsService{
     final private VisitorsMapper visitorsMapper;
    /**
     * 创建访客记录
     *
     * @param visitors 访客信息
     * @return Result
     */
    @Override
    public Result<Object> createVisitors(Visitors visitors) {
        try {
            visitors.setId(null);
            visitorsMapper.insert(visitors);
            return ResultUtil.success();
        }catch (Exception e){
            log.error("创建访客记录失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }

    }

    /**
     * 查询访客记录
     *
     * @param name 访客名字
     * @return Result
     */
    @Override
    public Result<Object> getVisitors(String name) {
        try {
            QueryWrapper<Visitors> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",name);
            List<Visitors> visitorsList = visitorsMapper.selectList(queryWrapper);
            queryWrapper.clear();
            return ResultUtil.success(visitorsList);
        }catch (Exception e){
            log.error("查询访客记录失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 分页查询访客记录
     *
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> findAllVisitorsByPage(Integer page, Integer size) {
        try{
            Page<Visitors> visitorsPage = new Page<>(page, size);
            return ResultUtil.success(visitorsMapper.selectPage(visitorsPage,null));
        }catch (Exception e){
            log.error("分页查询访客记录失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 查询所有访客记录
     *
     * @return Result
     */
    @Override
    public Result<Object> findAllVisitors() {
        try{
            return ResultUtil.success(visitorsMapper.selectList(null));
        }catch (Exception e){
            log.error("查询所有访客记录失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 删除访客记录
     *
     * @param id 序列号
     */
    @Override
    public Result<Object> deleteVisitors(Long id) {
        try{
            visitorsMapper.deleteById(id);
            return ResultUtil.success();
        }catch (Exception e){
            log.error("删除访客记录失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }
}
