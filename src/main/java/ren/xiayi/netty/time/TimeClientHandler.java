package ren.xiayi.netty.time;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter {
	private final AtomicInteger count = new AtomicInteger();

	private byte[] reqMsg;

	public TimeClientHandler() {
		reqMsg = ("now" + System.getProperty("line.separator")).getBytes();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ByteBuf msg;
		for (int i = 0; i < 100; i++) {
			msg = Unpooled.buffer(reqMsg.length);
			msg.writeBytes(reqMsg);
			ctx.writeAndFlush(msg);
		}
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf result = (ByteBuf) msg;
		int readableBytes = result.readableBytes();
		byte[] bytes = new byte[readableBytes];
		result.readBytes(bytes);
		String resultStr = new String(bytes, Charset.forName("UTF-8"));
		System.out.println("query result is :" + resultStr + "    the counter num is " + count.incrementAndGet());
	}

}
