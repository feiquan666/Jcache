package article;

import java.util.BitSet;

/**
 * description: 自定义序列化接口
 * date: 2020-05-04 13:00:09
 * @author: 飞拳
 */
public interface MySerializer<T> {
    byte JSON_SERIALIZER = 0x000_000_01;

    MySerializer DEFAULT = new JSONSerializer();
    /**
     * description:
     * date: 2020-05-04 13:33:23
     * @author: 飞拳
     * @param
     * @return: byte
    */
    byte getSerializerAlgorithm();

    /**
     * description: 编码
     * date: 2020-05-04 13:37:13
     * @author: 飞拳
     * @param data
     * @return: byte[]
    */
    byte[] serialize(Object data);

    /**
     * description: 解码
     * date: 2020-05-04 13:37:25
     * @author: 飞拳
     * @param clazz
     * @param bytes
     * @return: T
    */
    <T> T deSerialize(Class<T> clazz, byte[] bytes);
}
