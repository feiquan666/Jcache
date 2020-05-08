package article;

/**
 * description: 实现自定义序列化
 * date: 2020-05-04 13:03:15
 * @author: 飞拳
 */
public class JSONSerializer implements MySerializer{
    @Override
    public byte getSerializerAlgorithm() {
        return 0;
    }

    @Override
    public byte[] serialize(Object data) {
        return new byte[0];
    }

    @Override
    public Object deSerialize(Class clazz, byte[] bytes) {
        return null;
    }
}
