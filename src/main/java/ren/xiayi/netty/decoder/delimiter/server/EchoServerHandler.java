package ren.xiayi.netty.decoder.delimiter.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

@Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {

	int counter = 0;

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String requestBody = msg.toString();
		System.out.println("This is " + ++counter + " times receive client:[" + requestBody + "]");
		requestBody += "$_";
		ByteBuf responseMsg = Unpooled.copiedBuffer(requestBody.getBytes());
		ctx.writeAndFlush(responseMsg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}

}
