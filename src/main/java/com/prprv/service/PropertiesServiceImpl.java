package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.Properties;
import com.prprv.mapper.PropertiesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author phj233
 * @since 2023/5/13 14:00
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PropertiesServiceImpl implements PropertiesService{
    final private PropertiesMapper propertiesMapper;

    /**
     * 新增房产
     * @param properties 房产信息
     * @return Result
     */
    @Override
    public Result<Object> createProperties(Properties properties) {
        try{
            QueryWrapper<Properties> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",properties.getName());
            Properties selectedProperty = propertiesMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if(selectedProperty != null){
                return ResultUtil.error(ResultEnum.PROPERTY_DUPLICATE);
            }
            properties.setId(null);
            propertiesMapper.insert(properties);
            return ResultUtil.success();
        }catch (Exception e){
            log.error("新增房产失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 房产列表展示
     * @return Result
     */
    @Override
    public Result<Object> selectProperties() {
        try {
            return ResultUtil.success(propertiesMapper.selectList(null));
        } catch (Exception e) {
            log.error("房产列表展示失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 根据持有人查询房产
     * @param user 持有人名字
     * @return Result
     */
    @Override
    public Result<Object> getPropertiesByUser(String user) {
        try {
            QueryWrapper<Properties> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user",user);
            List<Properties> propertiesList = propertiesMapper.selectList(queryWrapper);
            queryWrapper.clear();
            return ResultUtil.success(propertiesList);
        }catch (Exception e){
            log.error("根据持有人查询房产失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 根据小区查询房产
     * @param estates 小区名字
     * @return Result
     */
    @Override
    public Result<Object> getPropertiesByEstates(String estates) {
        try {
            QueryWrapper<Properties> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("estates",estates);
            List<Properties> propertiesList = propertiesMapper.selectList(queryWrapper);
            queryWrapper.clear();
            return ResultUtil.success(propertiesList);
        }catch (Exception e){
            log.error("根据小区查询房产失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 房产信息查询
     * @param id 房产id
     * @return Result
     */
    @Override
    public Result<Object> getPropertiesById(Long id) {
        try {
            return ResultUtil.success(propertiesMapper.selectById(id));
        }catch (Exception e){
            log.error("房产信息查询失败，原因：{}",e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 分页查询房产
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */
    @Override
    public Result<Object> findAllPropertiesByPage(Integer page, Integer size) {
        try {
            Page<Properties> propertiesPage = new Page<>(page, size);
            return ResultUtil.success(propertiesMapper.selectPage(propertiesPage, null));
        } catch (Exception e) {
            log.error("分页查询房产失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 房产信息修改
     * @param properties 房产信息
     * @return Result
     */
    @Override
    public Result<Object> updateProperties(Properties properties) {
        try {
            propertiesMapper.updateById(properties);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("房产信息修改失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }

    /**
     * 房产信息移除
     * @param properties 房产信息
     * @return Result
     */
    @Override
    public Result<Object> deleteProperties(Properties properties) {
        try {
            propertiesMapper.deleteById(properties.getId());
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("房产信息移除失败，原因：{}", e.getMessage());
            return ResultUtil.error(ResultEnum.ERROR, e.getMessage());
        }
    }
}
