package com.huamiao.common.entity;

import com.huamiao.common.enums.IErrorCode;
import com.huamiao.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈一句话功能简述〉<br>
 * 〈通用返回前端api〉
 *
 * @author ZZH
 * @create 2021/4/22
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo<T> {

    /**
     * 状态码
     */
    private long code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     *
     * @param data 获取的数据
     * @param message 提示信息
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> success(T data, String message) {
        return new ResponseVo<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     *
     * @param message 提示信息
     * @param <T>
     * @return
     */

    public static <T> ResponseVo<T> failed(String message) {
        return new ResponseVo<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> failed() {
        return new ResponseVo<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResponseVo<T> failed(IErrorCode errorCode) {
        return new ResponseVo<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> ResponseVo<T> failed(IErrorCode errorCode, String message) {
        return new ResponseVo<T>(errorCode.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResponseVo<T> validateFailed(String message) {
        return new ResponseVo<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseVo<T> unauthorized(T data) {
        return new ResponseVo<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseVo<T> forbidden(T data) {
        return new ResponseVo<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}