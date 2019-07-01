package cn.elvea.lxp.common.exception;

/**
 * 系统异常
 *
 * @author elvea
 */
public class SystemException extends RuntimeException {

    public SystemException(Throwable ex) {
        super(ex);
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable ex) {
        super(message, ex);
    }

}
