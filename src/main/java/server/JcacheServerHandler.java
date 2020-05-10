package server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * description: 服务处理
 * date: 2020-05-07 15:59:16
 * @author: 飞拳
 */
@Slf4j
public class JcacheServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        JcacheMessage req = (JcacheMessage) msg;
//        log.info("Received msg: {}",req.toString());
        String tag = req.getData().toString().split("-")[1];
        JcacheMessage jcacheMessage = createMessage(tag);
//        log.info("Send msg: {}",jcacheMessage);
        ctx.writeAndFlush(jcacheMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 创建消息
    */
    private JcacheMessage createMessage(String i){
        JcacheMessage jcacheMessage = new JcacheMessage();
        jcacheMessage.setData("Welcome To Jcache-" + i);
        return jcacheMessage;
    }
}
