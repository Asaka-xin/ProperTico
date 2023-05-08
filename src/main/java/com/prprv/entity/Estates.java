package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * estate table
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("estates")
public class Estates {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String address;
    private Integer esphone;
}
