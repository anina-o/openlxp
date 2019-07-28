package cn.elvea.lxp.core.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.form.Register;
import cn.elvea.lxp.core.repository.UserRepository;
import cn.elvea.lxp.core.service.RoleService;
import cn.elvea.lxp.core.service.UserService;
import cn.elvea.lxp.core.type.UserStatusType;
import cn.elvea.lxp.security.service.SecurityService;
import com.google.common.collect.Lists;
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
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    SecurityService securityService;

    /**
     * @see UserService#findByUsername(String)
     */
    @Override
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username);

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
        UserEntity userEntity = this.userRepository.findById(id).get();
        return ConvertUtils.sourceToTarget(userEntity, UserDto.class);
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
        userEntity.setStatus(UserStatusType.OK.getValue());
        userEntity.setActive(Boolean.TRUE);
        this.userRepository.save(userEntity);

        Long roleId = this.roleService.getDefaultRole().getId();
        this.roleService.assignRoles(userEntity.getId(), Lists.newArrayList(roleId));
        System.out.println(register);
    }

}
