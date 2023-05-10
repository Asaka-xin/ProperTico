package com.prprv.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prprv.entity.Estates;
import com.prprv.mapper.EstatesMapper;
import com.prprv.service.EstatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class EstatesServiceImpl implements EstatesService {

    @Autowired
    private EstatesMapper estatesMapper;

    @Override
    public List<Estates> findAll() {
        List<Estates> estates = estatesMapper.selectAll();
        return estates;
    }

    @Override
    public Page<Estates> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Estates.class);//指定查询的表tb_community
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 2;
        if(searchMap != null){
            Example.Criteria criteria = example.createCriteria();//创建查询条件
            //时间区间
            if(StringUtil.isNotEmpty((String) searchMap.get("startTime"))){
                criteria.andGreaterThanOrEqualTo("createTime",searchMap.get("startTime"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("endTime"))){
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
            }
            //名称模糊搜索
            if(StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("name", "%"+(String) searchMap.get("name")+"%");
            }
            //分页
            /*if(StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }*/
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        PageHelper.startPage(pageNum,pageSize);//使用PageHelper插件完成分页
        Page<Estates> estates = (Page<Estates>) estatesMapper.selectByExample(example);
        return estates;
    }

    @Override
    public Boolean add(Estates estates) {
        int row = estatesMapper.insert(estates);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Estates findById(Integer id) {
        return estatesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Estates estates) {
        int row = estatesMapper.updateByPrimaryKeySelective(estates);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updateStatus(String address, Long id) {
        Estates estates = new Estates();
        estates.setId(id);
        estates.setAddress(address);
        int row = estatesMapper.updateByPrimaryKeySelective(estates);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
           estatesMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

}
