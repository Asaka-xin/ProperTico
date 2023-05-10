package com.prprv.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回结果枚举类
 * @author phj233
 * @since 2023/5/10 9:09
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "系统内部异常"),
    BAD_REQUEST(4000, "请求参数不合法或缺失"),
    PROPERTY_NOT_FOUND(4001, "没有找到指定的物业信息"),
    PARKING_NOT_FOUND(4002, "没有找到指定的停车位信息"),
    BUILDING_NOT_FOUND(4003, "没有找到指定的栋楼信息"),
    PROPERTY_DUPLICATE(4004, "物业信息已存在"),
    PARKING_DUPLICATE(4005, "停车位信息已存在"),
    BUILDING_DUPLICATE(4006, "栋楼信息已存在"),
    INVALID_OPERATION(4007, "操作无效或不允许"),
    UNABLE_TO_UPDATE_STATUS(4008, "更新状态失败"),
    UNABLE_TO_CREATE_RECORD(4009, "创建记录失败"),
    UNABLE_TO_DELETE_RECORD(4010, "删除记录失败"),
    UNABLE_TO_RETRIEVE_DATA(4011, "获取数据失败"),
    DATABASE_ERROR(4012, "数据库错误"),
    OWNER_NOT_FOUND(4013, "没有找到指定的业主信息"),
    PAYMENT_NOT_FOUND(4014, "没有找到指定的缴费信息"),
    REPAIR_NOT_FOUND(4015, "没有找到指定的报修信息"),
    COMPLAINT_NOT_FOUND(4016, "没有找到指定的投诉信息"),
    OWNER_DUPLICATE(4017, "业主信息已存在"),
    PAYMENT_DUPLICATE(4018, "缴费信息已存在"),
    REPAIR_DUPLICATE(4019, "报修信息已存在"),
    COMPLAINT_DUPLICATE(4020, "投诉信息已存在"),
    VISITOR_NOT_ALLOWED(4021, "访客未被授权访问"),
    VISITOR_MODULE_DISABLED(4022, "访客模块已被禁用");

    private final Integer code;
    private final String msg;
}
