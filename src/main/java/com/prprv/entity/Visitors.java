package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 访客实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("visitors")
public class Visitors {

    /**
     * 序列号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 访问小区
     */
    private String estates;
    /**
     * 访问时间
     */
    private LocalDateTime visitTime;
}
