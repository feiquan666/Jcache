import practice.encode.UserInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class PerformTestUserInfo {
    public static void main(String[] args) throws IOException {
        UserInfo userInfo = UserInfo.builder().userId(100).userName("Welcome to Netty").build();
        int loop = 1000000;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        long sta = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(userInfo);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("JDK: " + (end - sta) + "ms");

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        sta = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = userInfo.codeC(buffer);
        }
        end = System.currentTimeMillis();
        System.out.println("byte: " + (end - sta) + "ms");
    }
}
