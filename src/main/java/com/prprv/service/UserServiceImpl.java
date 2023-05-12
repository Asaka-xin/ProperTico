package com.prprv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prprv.common.result.Result;
import com.prprv.common.result.ResultEnum;
import com.prprv.common.result.ResultUtil;
import com.prprv.entity.User;
import com.prprv.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户管理实现类
 * @author phj233
 * @since 2023/5/12 15:33
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    final private UserMapper userMapper;
    @Override
    public Result<Object> register(User user) {
        try{
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",user.getName());
            User selectUser = userMapper.selectOne(queryWrapper);
            queryWrapper.clear();
            if(selectUser != null){
                return ResultUtil.error(ResultEnum.OWNER_DUPLICATE);
            }
            user.setId(null);
            userMapper.insert(user);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    @Override
    public Result<Object> findAllUserByPage(Integer page, Integer size) {
        try {
            Page<User> userPage = new Page<>(page, size);
            return ResultUtil.success(userMapper.selectPage(userPage, null));
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }

    /**
     * 查询所有用户
     *
     * @return Result
     */
    @Override
    public Result<Object> findAllUser() {
        try {
            return ResultUtil.success(userMapper.selectList(null));
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.ERROR,e.getMessage());
        }
    }
}
