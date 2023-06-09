package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 停车位实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("parkingspaces")
public class Parkingspaces {

    /**
     * 车位编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 车位类型
     * A/B
     */
    private String parkingtype;
    /**
     * 所属房产
     */
    private String building;
    /**
     * 车位所属业主
     * 业主id
     */
    private Long owner;
}
