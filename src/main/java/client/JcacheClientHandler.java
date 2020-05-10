package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import server.JcacheMessage;

import java.util.Scanner;

/**
 * description: 服务处理
 * date: 2020-05-07 15:59:16
 *
 * @author: 飞拳
 */
@Slf4j
public class JcacheClientHandler extends ChannelInboundHandlerAdapter {


    public JcacheClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        log.info("Received msg: {}", msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
