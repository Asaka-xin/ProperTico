package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 报修工单实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("maintenancerequests")
public class Maintenancerequests {

    /**
     * 工单编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户电话
     */
    private Integer phone;
    /**
     * 报修信息
     */
    private String description;
    /**
     * 报修时间
     */
    private LocalDateTime requestTime;
    /**
     * 报修状态
     * 已/待处理
     */
    private String status;
}
