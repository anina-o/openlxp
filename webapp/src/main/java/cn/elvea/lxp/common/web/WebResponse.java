package cn.elvea.lxp.common.web;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * WebResponse
 *
 * @author elvea
 */
@Setter
@Getter
public class WebResponse<E> implements Serializable {
    public final static int SUCCESS = 1;
    public final static int ERROR = 0;

    /**
     * 状态编码
     */
    private int code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private E data;

    public static WebResponse success() {
        return new WebResponse(SUCCESS);
    }

    public static <T> WebResponse<T> success(T data) {
        WebResponse<T> result = new WebResponse<>(SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> WebResponse<T> error(String message) {
        WebResponse<T> result = new WebResponse<>(ERROR);
        result.setMessage(message);
        return result;
    }

    private WebResponse(int code) {
        this.code = code;
    }

}
