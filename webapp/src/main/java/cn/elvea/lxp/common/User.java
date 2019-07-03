package cn.elvea.lxp.common;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 登录用户
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户角色
     */
    private List<String> roles = Lists.newArrayList();
    /**
     * 用户权限
     */
    private List<String> authorities = Lists.newArrayList();
}
