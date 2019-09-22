package cn.elvea.lxp.core.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.form.Register;
import cn.elvea.lxp.core.manager.UserManager;
import cn.elvea.lxp.core.service.RoleService;
import cn.elvea.lxp.core.service.UserService;
import cn.elvea.lxp.core.type.UserStatusTypeEnum;
import cn.elvea.lxp.security.service.SecurityUserService;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author elvea
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserManager userManager;

    @Autowired
    RoleService roleService;

    @Autowired
    SecurityUserService securityService;

    /**
     * @see UserService#findByUsername(String)
     */
    @Override
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.userManager.findByUsername(username);
        return this.getUserDto(userEntity);
    }

    /**
     * @see UserService#findById(Long)
     */
    @Override
    public UserDto findById(Long id) {
        UserEntity userEntity = this.userManager.findById(id);
        return this.getUserDto(userEntity);
    }

    /**
     * 获取用户信息
     * 包含附件关联的信息
     */
    private UserDto getUserDto(@NotNull UserEntity userEntity) {
        UserDto userDto = ConvertUtils.sourceToTarget(userEntity, UserDto.class);
        //
        userDto.setRoleList(this.roleService.findByUserId(userDto.getId()));
        //
        return userDto;
    }

    /**
     * @see UserService#register(Register)
     */
    @Override
    public void register(Register register) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(register.getUsername());
        userEntity.setNickname(userEntity.getUsername());
        userEntity.setFullname(userEntity.getUsername());
        userEntity.setPassword(this.securityService.encryptPassword(register.getPassword()));
        userEntity.setStatus(UserStatusTypeEnum.OK.getValue());
        userEntity.setActive(Boolean.TRUE);
        this.userManager.save(userEntity);

        Long roleId = this.roleService.getDefaultRole().getId();
        this.roleService.assignRoles(userEntity.getId(), Lists.newArrayList(roleId));
        System.out.println(register);
    }

    /**
     * @see UserService#save(UserDto)
     */
    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = ConvertUtils.sourceToTarget(userDto, UserEntity.class);
        this.userManager.save(userEntity);
        if (CollectionUtils.isNotEmpty(userDto.getRoleIdList())) {
            this.roleService.assignRoles(userEntity.getId(), userDto.getRoleIdList());
        }
        return userDto;
    }

}
