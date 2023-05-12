package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 房产实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("properties")
public class Properties {

    /**
     * 房产号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 房产名
     */
    private String name;
    /**
     * 持有人
     */
    private String user;
    /**
     * 所属小区
     */
    private String estates;
    /**
     * 房产面积
     */
    private Integer area;
}
