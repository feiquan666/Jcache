import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestTranscational {

    @Test
    public void testTrans(){
        Map<String, Object> map = new HashMap<>();
        log.info("key-val list at now:{}","{key0:'zero',key1:1,key2:2}");
        log.info("trans start");
        log.info("set key3:'three'");
        log.info("set key2:(1/0)");
        log.info("trans commit");
        log.info("trans rollback");
        log.info("key-val list at now:{}","{key0:'zero',key1:1,key2:2}");
    }
}
