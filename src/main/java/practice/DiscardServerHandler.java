package practice;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * description: 丢弃服务示例程序
 * date: 2020-04-30 14:50:57
 * @author: 飞拳
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        /**
         * discard the receive data silently
         * 默默地丢弃接收到的数据
        */
        ctx.write(msg);
        ctx.flush();
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            System.out.println(in.toString(CharsetUtil.UTF_8));
//        }finally {
//            // 或者 in.release()
//            ReferenceCountUtil.release(msg);
//        }
    }

    /**
     * 当出现异常时，关闭channel
    */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
