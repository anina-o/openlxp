package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.system.dto.UserDto;
import cn.elvea.lxp.core.system.entity.UserEntity;
import cn.elvea.lxp.core.system.form.Register;
import cn.elvea.lxp.core.system.manager.UserManager;
import cn.elvea.lxp.core.system.service.RoleService;
import cn.elvea.lxp.core.system.service.UserService;
import cn.elvea.lxp.core.system.type.UserStatusTypeEnum;
import cn.elvea.lxp.core.security.service.SecurityUserService;
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
    private UserManager userManager;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityUserService securityService;

    /**
     * @see UserService#findUserByUsername(String)
     */
    @Override
    public UserDto findUserByUsername(String username) {
        UserEntity userEntity = this.userManager.findUserByUsername(username);
        return this.getUserDto(userEntity);
    }

    /**
     * @see UserService#findUserByEmail(String)
     */
    @Override
    public UserDto findUserByEmail(String username) {
        UserEntity userEntity = this.userManager.findUserByEmail(username);
        return this.getUserDto(userEntity);
    }

    /**
     * @see UserService#findUserByMobile(String)
     */
    @Override
    public UserDto findUserByMobile(String username) {
        UserEntity userEntity = this.userManager.findUserByMobile(username);
        return this.getUserDto(userEntity);
    }

    /**
     * @see UserService#findById(Long)
     */
    @Override
    public UserDto findById(Long id) {
        UserEntity userEntity = this.userManager.findUserById(id);
        return this.getUserDto(userEntity);
    }

    /**
     * 获取用户信息
     * 包含附件关联的信息
     */
    private UserDto getUserDto(@NotNull UserEntity userEntity) {
        UserDto userDto = ConvertUtils.sourceToTarget(userEntity, UserDto.class);
        //
        userDto.setRoleList(this.roleService.findRolesByUserId(userDto.getId()));
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
        this.userManager.saveUser(userEntity);

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
        this.userManager.saveUser(userEntity);
        if (CollectionUtils.isNotEmpty(userDto.getRoleIdList())) {
            this.roleService.assignRoles(userEntity.getId(), userDto.getRoleIdList());
        }
        return userDto;
    }

}
