package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 小区实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("estates")
public class Estates {

    /**
     * 小区编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 小区名称
     */
    private String name;
    /**
     * 小区地址
     */
    private String address;
    /**
     * 小区电话
     */
    private Integer esphone;
}
