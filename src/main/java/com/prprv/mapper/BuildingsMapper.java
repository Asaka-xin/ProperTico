package com.prprv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prprv.entity.Buildings;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @see Buildings
 * @author Christine
 * @version 1.0
 * @since 2023/5/9
 */

@Mapper
public interface BuildingsMapper extends BaseMapper<Buildings> {
    void deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buildings buildings);

    Buildings selectByPrimaryKey(Integer id);

    Object selectByExample(Example example);

    List<Buildings> selectAll();
}
