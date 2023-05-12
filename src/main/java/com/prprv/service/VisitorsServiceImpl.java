package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
}
