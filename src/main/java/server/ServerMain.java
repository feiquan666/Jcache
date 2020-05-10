package server;

import org.yaml.snakeyaml.Yaml;
import util.LoadConfig;

import java.io.InputStream;
import java.util.LinkedHashMap;

/**
 * description: 服务端主方法
 * date: 2020-05-07 15:13:07
 * @author: 飞拳
 */

public class ServerMain {
    public static void main(String[] args) throws Exception {
        LoadConfig.loadConfig();
        int port = 7811;
        try {
            port = Integer.parseInt(LoadConfig.getConfig("port"));
        }catch (Exception e){

        }
        new ServerStartUp(port).bind();
    }


}
