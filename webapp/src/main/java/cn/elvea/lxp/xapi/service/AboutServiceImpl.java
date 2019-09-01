package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.model.About;
import org.springframework.stereotype.Service;

/**
 * AboutServiceImpl
 *
 * @author elvea
 */
@Service
public class AboutServiceImpl implements AboutService {

    /**
     * @see AboutService#about()
     */
    @Override
    public About about() {
        return new About();
    }

}
