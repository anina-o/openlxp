package cn.elvea.lxp.core.support.auditor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * UserAuditor
 *
 * @author elvea
 */
@Configuration
@Slf4j
public class UserAuditor implements AuditorAware<Long> {

    /**
     * 获取当前创建或修改的用户
     */
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(1L);
    }

}
