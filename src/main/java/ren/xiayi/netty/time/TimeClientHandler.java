package ren.xiayi.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.Charset;

public class TimeClientHandler extends ChannelHandlerAdapter {

	private final ByteBuf msg;

	public TimeClientHandler() {
		byte[] reqMsg = "now".getBytes();
		msg = Unpooled.buffer(reqMsg.length);
		msg.writeBytes(reqMsg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(msg);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf result = (ByteBuf) msg;
		int readableBytes = result.readableBytes();
		byte[] bytes = new byte[readableBytes];
		result.readBytes(bytes);
		String resultStr = new String(bytes, Charset.forName("UTF-8"));
		System.out.println("query result is :" + resultStr);

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
	}

}
