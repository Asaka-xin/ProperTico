package com.prprv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prprv.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @see User
 * @author Christine
 * @version 1.0
 * @since 2023/5/9
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
