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
     * 编号
     */
    private String code;

    /**
     * 标题
     */
    private String title;

}
