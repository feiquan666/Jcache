package server;

import lombok.Data;

import java.io.Serializable;

/**
 * description: 消息体
 * date: 2020-05-07 16:18:13
 * @author: 飞拳
 */
@Data
public class JcacheMessage<T> implements Serializable {
    private static final long serialVersionUID = -4618307449701121715L;
    private short magicNumber = 5163;
    private byte version = 0b0001;
    private T data;
}
