package client;


import util.LoadConfig;

/**
 * description: 客户端主方法
 * date: 2020-05-07 15:13:47
 * @author: 飞拳
 */
public class ClientMain {
    public static void main(String[] args) throws Exception {
        int port = 7811;
        String host = "localhost";
        if (args != null && args.length > 0){
            try {
                port = Integer.parseInt(LoadConfig.getConfig("port"));
                host = LoadConfig.getConfig("host");
            }catch (Exception e){

            }
        }
        new ClientStartUp().connect(port, host);
    }
}
