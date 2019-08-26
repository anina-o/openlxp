package cn.elvea.lxp.xapi;

/**
 * XApiObject
 *
 * @author elvea
 */
public interface AbstractObject extends AbstractJsonObject {

    /**
     * 获取对象类型
     *
     * @return 对象类型
     */
    String getObjectType();

}
