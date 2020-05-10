import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.LoadConfig;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * description: 配置加载测试
 * date: 2020-05-09 13:20:29
 *
 * @author: 飞拳
 */
@Slf4j
public class TestLoadConfig {
    {
        LoadConfig.loadConfig();
    }

    @Test
    public void testLoad() {
        Map<String, Object> map = new LinkedHashMap<>(8);
        map.put("port", LoadConfig.getConfig("port"));
        map.put("host", LoadConfig.getConfig("host"));
        map.put("auth.user", LoadConfig.getConfig("auth.user"));
        map.put("undefined", LoadConfig.getConfig("undefined"));
        log.info("#######配置加载测试结果#######");
        log.info(map.toString());
        log.info("#######配置加载测试结果#######");
    }
}
