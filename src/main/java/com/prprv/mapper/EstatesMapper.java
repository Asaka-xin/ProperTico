package com.prprv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prprv.entity.Estates;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @see Estates
 * @author Christine
 * @version 1.0
 * @since 2023/5/9
 */

@Mapper
public interface EstatesMapper extends BaseMapper<Estates>{
    void deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Estates estates);

    Estates selectByPrimaryKey(Integer id);

    Object selectByExample(Example example);

    List<Estates> selectAll();
}
