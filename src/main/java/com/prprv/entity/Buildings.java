package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 楼栋实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("buildings")
public class Buildings {

    /**
     * 楼栋编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 所属小区
     */
    private String estates;
    /**
     * 楼层数
     * 默认20层
     */
    private Integer floor;
}
