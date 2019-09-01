package cn.elvea.lxp.config;

import cn.elvea.lxp.common.utils.IdWorker;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Config
 *
 * @author elvea
 */
@Configuration
@ComponentScan("cn.elvea.lxp")
@EnableJpaAuditing(auditorAwareRef = "userAuditor")
@EnableMongoAuditing(auditorAwareRef = "userAuditor")
@EnableCaching
public class Config {

    /**
     * IdWorker
     *
     * @return IdWorker
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

    /**
     * CacheManagerCustomizer
     *
     * @return CacheManagerCustomizer
     */
    @Bean
    public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
        return cacheManager -> cacheManager.setAllowNullValues(false);
    }

}
