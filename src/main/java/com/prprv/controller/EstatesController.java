package com.prprv.controller;


import com.github.pagehelper.Page;
import com.prprv.common.MessageConstant;
import com.prprv.common.PageResult;
import com.prprv.common.Result;
import com.prprv.common.StatusCode;
import com.prprv.entity.Estates;
import com.prprv.service.EstatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auth: zhy
 * @Desc: 小区管理控制层:只负责接收前端浏览器发送的请求和请求参数，调用service层获取业务逻辑加工处理后的数据
 */
@RestController
@RequestMapping("/estates")
public class EstatesController {
    
    @Autowired
    private EstatesService estatesService;

    @RequestMapping("/find")
    public Result find(){
        List<Estates> all = estatesService.findAll();
        return new Result(false,200,"请求成功adasdasdas",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Estates> page = estatesService.search(searchMap);
        return new PageResult(page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Estates estates){
        Boolean add = estatesService.add(estates);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Estates estates = estatesService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,estates);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Estates estates){
        Boolean add = estatesService.update(estates);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }
    // /community/updateStatus/0/1
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String address, @PathVariable("id") long id){
        Boolean flag = estatesService.updateStatus(address,id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = estatesService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
