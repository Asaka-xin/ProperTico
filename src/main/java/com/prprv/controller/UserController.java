package com.prprv.controller;

import com.prprv.entity.User;
import com.prprv.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Christine
 * @version 1.0
 * @since 2023/5/14
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 分页查询所有用户
     * @param page 页码
     * @param size 每页数量
     */
    @GetMapping("/findAllUserByPage")
    public Object findAllUserByPage(@RequestBody Integer page, Integer size) {
//        Todo : 待完成
        return null;
    }

    /**
     * 删除用户
     * @param id 用户id
     */
    @PostMapping("/deleteUser")
    public Object deleteUser(@RequestBody Long id) {
//        Todo : 未完成
        return null;
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     */
    @PostMapping("/updateUser")
    public Object updateUser(@RequestBody User user) {
//        Todo : 无法使用
        return null;
    }

}
