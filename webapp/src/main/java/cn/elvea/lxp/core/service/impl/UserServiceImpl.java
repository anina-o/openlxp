package cn.elvea.lxp.core.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.manager.UserManager;
import cn.elvea.lxp.core.service.RoleService;
import cn.elvea.lxp.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author elvea
 */
@Service
public class UserServiceImpl implements UserService {

    private UserManager userManager;

    private RoleService roleService;

    /**
     * @see UserService#findByUsername(String)
     */
    @Override
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.userManager.findByUsername(username);

        UserDto userDto = null;
        if (userEntity != null) {
            userDto = ConvertUtils.sourceToTarget(userEntity, UserDto.class);
            //
            userDto.setRoles(this.roleService.findByUserId(userDto.getId()));
        }
        return userDto;
    }

    /**
     * @see UserService#findById(Long)
     */
    @Override
    public UserDto findById(Long id) {
        UserEntity userEntity = this.userManager.findById(id);
        return ConvertUtils.sourceToTarget(userEntity, UserDto.class);
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}
