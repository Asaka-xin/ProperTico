package com.prprv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prprv.entity.Complaints;
import org.apache.ibatis.annotations.Mapper;

/**
 * @see Complaints
 * @author Christine
 * @version 1.0
 * @since 2023/5/9
 */

@Mapper
public interface ComplaintsMapper extends BaseMapper<Complaints> {
}
