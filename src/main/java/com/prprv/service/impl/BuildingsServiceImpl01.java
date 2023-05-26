package com.prprv.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prprv.entity.Buildings;
import com.prprv.mapper.BuildingsMapper;
import com.prprv.service.BuildingsService01;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
/**
 * 小区管理接口实现类
 * @author suikakv
 * @since 2023/5/13 19:10
 * @see BuildingsService01
 */
@Service
public class BuildingsServiceImpl01 extends ServiceImpl<BuildingsMapper, Buildings> implements BuildingsService01 {
    @Resource
    private BuildingsMapper buildingsMapper;

    // 查询所有的分页
    @Override
    public IPage<Buildings> getPage(int currentPage, int pageSize) {
        IPage<Buildings> page = new Page<>(currentPage, pageSize);
        buildingsMapper.selectPage(page, null);
        return page;
    }

    // 先模糊查询，然后在分页。那么返回到浏览器里面，肯定是页的形式返回
    @Override
    public IPage<Buildings> getPage(int currentPage, int pageSize, Buildings buildings) {
        LambdaQueryWrapper<Buildings> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Strings.isNotEmpty(buildings.getId()), Buildings::getId, buildings.getId());
        lqw.like(Strings.isNotEmpty(buildings.getEstates()), Buildings::getEstates, buildings.getEstates());

        //如果得到的数据不为空，那么执行模糊查询，where book:getName like %book.getName%
        //分页
        IPage<Buildings> page = new Page<>(currentPage, pageSize);
        buildingsMapper.selectPage(page, lqw);
        return page;
    }
}
