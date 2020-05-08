package server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import practice.UnixTime;

/**
 * description: 服务处理
 * date: 2020-05-07 15:59:16
 * @author: 飞拳
 */
public class JcacheServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
//        ChannelFuture f = ctx.writeAndFlush(JcacheMessage.builder().data("Welcome To Jcache").build());
//        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
