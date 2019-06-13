package cn.elvea.lxp.core.exception;

/**
 * 服务异常
 *
 * @author elvea
 */
public class ServiceException extends RuntimeException {

    public ServiceException(Throwable ex) {
        super(ex);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable ex) {
        super(message, ex);
    }

}
