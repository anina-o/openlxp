package cn.elvea.lxp.modules.xapi.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * XAPIResponse
 *
 * @author elvea
 */
@Setter
@Getter
public class XAPIResponse<E> implements Serializable {
    public final static int SUCCESS = 1;
    public final static int ERROR = 0;

    /**
     * 状态编码
     */
    private int code;
    /**
     * 信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    /**
     * 数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private E data;

    public static XAPIResponse success() {
        return new XAPIResponse(SUCCESS);
    }

    public static <T> XAPIResponse<T> success(T data) {
        XAPIResponse<T> result = new XAPIResponse<>(SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> XAPIResponse<T> error(String message) {
        XAPIResponse<T> result = new XAPIResponse<>(ERROR);
        result.setMessage(message);
        return result;
    }

    private XAPIResponse(int code) {
        this.code = code;
    }

}
