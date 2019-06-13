package cn.elvea.lxp.common.web;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.Serializable;
import java.util.Map;

/**
 * WebRequest
 */
@Getter
@Setter
public class WebRequest implements Serializable {
    /**
     * 当前页码
     */
    private int page;
    /**
     * 每页记录数
     */
    private int limit;
    /**
     * 排序列
     */
    private String sort;
    /**
     * 排序方式
     */
    private String order;
    /**
     * 关键字
     */
    private String q;
    /**
     * 请求参数
     */
    private Map<String, String> params = Maps.newHashMap();

    public WebRequest() {
    }

    public WebRequest(NativeWebRequest webRequest) {
    }

}
