package com.prprv.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.prprv.entity.Estates;
import com.prprv.service.EstatesService01;
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
@RequestMapping("/estates")
public class EstatesController01 {
    //自动注入service层
    @Resource
    private EstatesService01 estatesService;

    //查询一条数据
    @GetMapping("/{id}")
    public Estates getId(@PathVariable Long id){
        return estatesService.getById(id);
    }

    //获取数据用get.查询所有的数据
    @GetMapping("/getAll")
    public List<Estates> getAll(){
        return estatesService.list();
    }

    //新增一条数据，用post
    @PostMapping("/insert")
    public boolean insert(@RequestBody Estates estates){
        return estatesService.save(estates);
    }

    //根据Id更改数据：用put
    @PutMapping("/update")
    public boolean update(@RequestBody Estates estates){
        return estatesService.updateById(estates);
    }
    //根据id删除数据,用delete
    @DeleteMapping("/{id}")  //根据路径传参
    public boolean delete(@PathVariable Long id){
        return estatesService.removeById(id);
    }

    //分页查询语句
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Estates> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return estatesService.getPage(currentPage,pageSize);
    }
}
