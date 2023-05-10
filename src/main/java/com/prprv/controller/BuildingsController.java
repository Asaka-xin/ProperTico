package com.prprv.controller;


import com.github.pagehelper.Page;
import com.prprv.common.MessageConstant;
import com.prprv.common.PageResult;
import com.prprv.common.Result;
import com.prprv.common.StatusCode;
import com.prprv.entity.Buildings;
import com.prprv.service.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
/**
 * @Auth: zhy
 * @Desc:
 */
@RestController
@RequestMapping("/buildings")
public class BuildingsController {
    
    @Autowired
    private BuildingsService buildingsService;

    @RequestMapping("/find")
    public Result find(){
        List<Buildings> all = buildingsService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Buildings> page = buildingsService.search(searchMap);
        return new PageResult(((Page<?>) page).getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Buildings buildings){
        Boolean add = buildingsService.add(buildings);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Buildings buildings = buildingsService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,buildings);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Buildings buildings){
        Boolean add = buildingsService.update(buildings);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = buildingsService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
