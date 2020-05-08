package server;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.LinkedHashMap;

/**
 * description: 服务端主方法
 * date: 2020-05-07 15:13:07
 * @author: 飞拳
 */

public class Main {
    public static LinkedHashMap<String, ?> I_CONFIG;

    public static void main(String[] args) throws Exception {
        loadConfig();
        int port = 7811;
        try {
            port = Integer.parseInt(getConfig("port"));
        }catch (Exception e){

        }
        new StartUp(port).run();
    }

    private static void loadConfig(){
        InputStream reader = Main.class.getResourceAsStream("/jcache.yml");
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
