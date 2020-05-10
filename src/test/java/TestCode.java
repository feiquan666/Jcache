import entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * description: 服务端客户端收发消息测试
 * date: 2020-05-09 13:20:44
 *
 * @author: 飞拳
 */
@Slf4j
public class TestCode {
    @Test
    public void testBitStreamLength() throws Exception {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUserName("Welcome To Jcache");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        log.info("JDK length: {}", b.length);
        bos.close();
        log.info("------------------------------------------");
        log.info("ByteBuffer length: {}", info.codeC().length);
    }

    @Test
    public void testCodeSpeed() throws Exception {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUserName("Welcome To Jcache");
        int loop = 1_000_000;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long end = System.currentTimeMillis();
        log.info("JDK cost times: {}{}", (end -start), " ms");
        log.info("------------------------------------------");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = info.codeC(buffer);
        }
        end = System.currentTimeMillis();
        log.info("ByteBuffer cost times: {}{}", (end - start), " ms");
    }
}
