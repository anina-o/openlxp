package cn.elvea.lxp.core.system.support.auditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * UserAuditor
 *
 * @author elvea
 */
@Slf4j
@Component("userAuditor")
public class UserAuditor implements AuditorAware<Long> {

    /**
     * 获取当前创建或修改的用户
     */
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(1L);
    }

}
