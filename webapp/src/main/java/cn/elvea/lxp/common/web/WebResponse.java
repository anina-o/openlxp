package cn.elvea.lxp.common.web;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private int status;
    /**
     * 信息
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    /**
     * 数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    public WebResponse(int status) {
        this.status = status;
    }

}
