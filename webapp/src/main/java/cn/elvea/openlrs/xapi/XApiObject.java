package cn.elvea.openlrs.xapi;

/**
 * XApiObject
 *
 * @author elvea
 */
public interface XApiObject extends XApiJsonObject {

    /**
     * 获取对象类型
     *
     * @return 对象类型
     */
    String getObjectType();

}
