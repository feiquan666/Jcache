package util;

import org.yaml.snakeyaml.Yaml;
import server.ServerMain;

import java.io.InputStream;
import java.util.LinkedHashMap;

/**
 * description: 加载配置文件
 * date: 获取指定属性
 * @author: 飞拳
 */
public class LoadConfig {

    public static LinkedHashMap<String, ?> I_CONFIG;

    public static void loadConfig(){
        InputStream reader = ServerMain.class.getResourceAsStream("/jcache.yml");
        I_CONFIG = new Yaml().loadAs(reader, LinkedHashMap.class);
    }

    public static String getConfig(String configKey) {
        String result = getValue(I_CONFIG, configKey);
        return result;

    }

    private static String getValue(LinkedHashMap<String, ?> map, String configKey){
        String result = "";
        String[] configKeys = configKey.split("\\.");

        LinkedHashMap<String, ?> linkedHashMap = map;
        for (String key : configKeys) {
            Object o = linkedHashMap.get(key);
            if (o != null) {
                if(o instanceof LinkedHashMap){
                    linkedHashMap = (LinkedHashMap<String, ?>) o;
                }else{
                    result = o.toString();
                }
            } else {
                continue;
            }
        }
        return result;
    }
}
