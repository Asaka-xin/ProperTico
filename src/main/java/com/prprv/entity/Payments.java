package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * bill table
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("payments")
public class Payments {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String user;
    private LocalDateTime payTime;
    private Integer payAmount;
}
