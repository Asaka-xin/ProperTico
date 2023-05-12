package com.prprv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 缴费记录实体类
 * @author Christine
 * @version 1.0
 * @since 2023/5/8
 */

@Data
@AllArgsConstructor
@TableName("payments")
public class Payments {

    /**
     * 缴费编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 缴费户号
     */
    private String user;
    /**
     * 缴费时间
     */
    private LocalDateTime payTime;
    /**
     * 缴费金额
     */
    private Integer payAmount;
}
