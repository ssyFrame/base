package com.zhangzhao.frame.common;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ZhangZhao
 * @date 2018/6/3 15:02
 */
public class JSONResult {
    /**
     *定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    public static JSONResult errorException(String msg){
        return new JSONResult(555,msg,null);
    }

    public static JSONResult ok(){
        return new JSONResult();
    }

    public JSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
