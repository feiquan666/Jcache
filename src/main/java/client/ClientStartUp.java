package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;
import server.JcacheMessage;

import java.util.Scanner;

/**
 * description: 启动类
 * date: 2020-05-07 15:48:34
 * @author: 飞拳
 */
@Slf4j
public class ClientStartUp {
    public void connect(int port, String host) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    new ObjectDecoder(
                                            1024,
                                            ClassResolvers.cacheDisabled(this.getClass().getClassLoader()
                                            )
                                    )
                                    ,new ObjectEncoder(),
                                    new JcacheClientHandler());
                        }
                    });
            ChannelFuture f = b.connect(host, port).sync();
            Channel channel = f.channel();
//            Scanner scanner = new Scanner(System.in);
            int loop = 3_000_000;
            long start = System.currentTimeMillis();
            for (int i = 0; i < loop; i++) {
                JcacheMessage msg = createMessage("Go To Jcache");
//                log.info("Send msg: {}", "Go To Jcache");
                channel.writeAndFlush(msg);
            }
            long end = System.currentTimeMillis();
            log.info("million times cost times: {}{}", (end - start), " ms");
        }finally {
            group.shutdownGracefully();
        }
    }
    /**
     * 创建消息
     */
    private JcacheMessage createMessage(String i) {
        JcacheMessage jcacheMessage = new JcacheMessage();
        jcacheMessage.setData("Go To Jcache-" + i);
        return jcacheMessage;
    }
}
