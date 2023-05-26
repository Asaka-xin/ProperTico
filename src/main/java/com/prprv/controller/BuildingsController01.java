package com.prprv.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.prprv.entity.Buildings;
import com.prprv.service.BuildingsService01;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 * @author suikakv
 * @since 2023/5/13 19:07
 * @version 1.0
 */
@RestController
@RequestMapping("/buildings")
public class BuildingsController01 {
    //自动注入service层
    @Resource
    private BuildingsService01 buildingsService;

    //查询一条数据
    @GetMapping("/{id}")
    public Buildings getId(@PathVariable Long id){
        return buildingsService.getById(id);
    }

    //获取数据用get.查询所有的数据
    @GetMapping("/getAll")
    public List<Buildings> getAll(){
        return buildingsService.list();
    }

    //新增一条数据，用post
    @PostMapping("/insert")
    public boolean insert(@RequestBody Buildings buildings){
        return buildingsService.save(buildings);
    }

    //根据Id更改数据：用put
    @PutMapping("/update")
    public boolean update(@RequestBody Buildings buildings){
        return buildingsService.updateById(buildings);
    }
    //根据id删除数据,用delete
    @DeleteMapping("/{id}")  //根据路径传参
    public boolean delete(@PathVariable Long id){
        return buildingsService.removeById(id);
    }

    //分页查询语句
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Buildings> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return buildingsService.getPage(currentPage,pageSize);
    }
}
