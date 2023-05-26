package com.prprv.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prprv.entity.Buildings;
import org.springframework.stereotype.Service;

/**
 * 小区管理接口
 * @author suikakv
 * @since 2023/5/13 19:09
 */
@Service
public interface BuildingsService01 extends IService<Buildings> {
    // 查询所有的分页
    IPage<Buildings> getPage(int currentPage, int pageSize);

    // 先模糊查询，然后在分页。那么返回到浏览器里面，肯定是页的形式返回
    IPage<Buildings> getPage(int currentPage, int pageSize, Buildings buildings);
}
