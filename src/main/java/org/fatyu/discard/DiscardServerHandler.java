package org.fatyu.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg)
            throws Exception {
        super.channelRead(ctx, msg);

        final ByteBuf byteBuf = (ByteBuf)msg;
        while(byteBuf.isReadable()){
            System.out.println((char)byteBuf.readByte());
            System.out.flush();
        }
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));

        byteBuf.release();
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause)
            throws Exception {
        // TODO Auto-generated method stub
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }

}
