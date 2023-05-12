package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("user")
public class User {

    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户电话
     */
    private Integer phone;
    /**
     * 用户注册时间
     */
    private LocalDateTime createTime;
}
