package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * description: 编码
 * date: 2020-05-07 15:58:07
 * @author: 飞拳
 */
public class JenCoder extends MessageToByteEncoder {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        JcacheMessage m = (JcacheMessage) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeBytes(encoded);
        ctx.write(encoded, promise);
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {

    }
}
