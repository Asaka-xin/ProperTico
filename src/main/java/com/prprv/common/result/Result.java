package com.prprv.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回结果类
 * @param <T> 返回数据类型
 * @since 2023/5/10 9:08
 * @author phj233
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
}