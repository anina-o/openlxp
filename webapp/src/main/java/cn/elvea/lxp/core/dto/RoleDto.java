package cn.elvea.lxp.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * UserDto
 *
 * @author elvea
 */
@Getter
@Setter
public class RoleDto implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 标题
     */
    private String title;
    /**
     * 多语言文本
     */
    private String label;
}
