package com.wangxhu.yixiaoyuan.utils.result;

/**
 * 对请求结果进行封装
 *
 * @param <T>
 */
public class Result<T> {

    /**
     * error code: 成功是0.失败是1
     */
    private Integer code;

    /**
     * 要返回的数据
     */
    private T data;

    /**
     * 本次请求的说明信息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
