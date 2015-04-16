package org.fatyu.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final Object msg) throws Exception {

    }

    private final int             msgSize;
    private ByteBuf               buffer;
    private ChannelHandlerContext ctx;

    public DiscardClientHandler(final int msgSize) {
        if (msgSize <= 0) {
            throw new IllegalArgumentException("msgSize:" + msgSize);
        }
        this.msgSize = msgSize;
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;

        // Initialize the message.
        buffer = ctx.alloc().directBuffer(msgSize).writeZero(msgSize);

        // Send the initial messages.
        generateTraffic();
    }

    @Override
    public void channelInactive(final ChannelHandlerContext ctx) throws Exception {
        buffer.release();
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) throws Exception {
        ctx.close();
    }

    private void generateTraffic() {
        ctx.writeAndFlush(buffer.duplicate().retain()).addListener(trafficGenerator);
    }

    private final ChannelFutureListener trafficGenerator = new ChannelFutureListener() {
        @Override
        public void operationComplete(final ChannelFuture future)
                throws Exception {
            if (future.isSuccess()) {
                generateTraffic();
            }
        }
    };

}
