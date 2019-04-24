package com.wangxhu.yixiaoyuan.utils.result;

/**
 * 对请求结果的封装类
 */
public class ResultBuilder {

    /**
     * 成功请求的结果封装
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setData(data);
        result.setMessage("success");
        return result;
    }


    /**
     * 成功请求的结果封装
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return success(null);
    }


    /**
     * 失败请求的结果封装
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail() {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setData(null);
        result.setMessage("fail");
        return result;
    }


    /**
     * 失败请求结果封装
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setData(null);
        result.setMessage(msg);
        return result;
    }
}
