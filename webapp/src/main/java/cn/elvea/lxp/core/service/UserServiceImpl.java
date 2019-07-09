package cn.elvea.lxp.core.service;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.manager.UserManager;
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

    /**
     * @see UserService#findByUsername(String)
     */
    @Override
    public UserDto findByUsername(String username) {
        UserEntity userEntity = this.userManager.findByUsername(username);
        return ConvertUtils.sourceToTarget(userEntity, UserDto.class);
    }

    /**
     * @see UserService#findById(Long)
     */
    @Override
    public UserDto findById(Long id) {
        UserEntity userEntity = this.userManager.findById(id);
        return ConvertUtils.sourceToTarget(userEntity, UserDto.class);
    }

}
