package cn.elvea.lxp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * SecurityServiceImpl
 *
 * @author elvea
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @see SecurityService#encryptPassword(String)
     */
    @Override
    public String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }

    /**
     * @see SecurityService#isPasswordMatch(String, String)
     */
    @Override
    public boolean isPasswordMatch(String presentedPassword, String encodedPassword) {
        return this.passwordEncoder.matches(presentedPassword, encodedPassword);
    }

}
