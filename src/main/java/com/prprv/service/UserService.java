package com.prprv.service;

import com.prprv.common.result.Result;
import com.prprv.entity.User;

/**
 * 用户信息管理
 * @author Christine
 * @version 1.0
 * @since 2023/5/11
 */
public interface UserService {
    /**
     * 用户注册
     * @param user 用户信息
     * @return Result
     */
    Result<Object> register(User user);

    /**
     * 分页查询用户
     * @param page 页码
     * @param size 每页数量
     * @return Result
     */

    Result<Object> findAllUserByPage(Integer page, Integer size);

    /**
     * 查询所有用户
     * @return Result
     */
    Result<Object> findAllUser();
}
