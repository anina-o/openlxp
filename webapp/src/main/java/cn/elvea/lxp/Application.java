package cn.elvea.lxp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Application
 *
 * @author elvea
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        disableAccessWarning();
        SpringApplication.run(Application.class, args);
    }

    /**
     * 用于消除高版本JDK下面的警告信息
     */
    @SuppressWarnings("unchecked")
    public static void disableAccessWarning() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
