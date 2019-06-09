package cn.elvea.openlrs.xapi.service;

import cn.elvea.openlrs.xapi.About;
import org.springframework.stereotype.Service;

/**
 * XAPIServiceImpl
 *
 * @author elvea
 */
@Service
public class XAPIServiceImpl implements XAPIService {

    /**
     * @see XAPIService#about()
     */
    @Override
    public About about() {
        return new About();
    }

}
