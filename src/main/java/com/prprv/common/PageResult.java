package com.prprv.common;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Auth: zhy
 * @Desc: 分页-标准返回结果
 */
public class PageResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -6250130355901431732L;

    //是否成功
    //返回码
    //返回消息
    private Object data;

    /**
     * 功能描述:
     *
     * @param data    结果集列表
     * @param total   总条数
     */
    public PageResult(Object data, Long total) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
