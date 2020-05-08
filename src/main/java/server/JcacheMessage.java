package server;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 消息体
 * date: 2020-05-07 16:18:13
 * @author: 飞拳
 */
//@Data
//@NoArgsConstructor
//@Builder
public class JcacheMessage {
    private short magicNumber = 5163;
    private byte version = 0b0001;
    private Object data;
}
