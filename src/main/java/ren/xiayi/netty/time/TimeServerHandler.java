package ren.xiayi.netty.time;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {
	private final AtomicInteger count = new AtomicInteger();

	@SuppressWarnings("deprecation")
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);//read buf data to req

		//测试粘包问题
		String body = new String(req, Charset.forName("UTF-8")).substring(0,
				req.length - System.getProperty("line.separator").length());
		System.out.println("received request content is :" + body + ", counter num is :" + count.incrementAndGet());
		String currentDate = StringUtils.equalsIgnoreCase("now", body) ? new Date().toLocaleString() : "ERROR REQ MSG!";
		ByteBuf copiedBuffer = Unpooled.copiedBuffer(currentDate.getBytes());
		ctx.write(copiedBuffer);
		/*
		 * String body = new String(req, Charsets.UTF_8);
		System.out.println("the request data is :" + body);
		String resp = StringUtils.EMPTY;
		if (StringUtils.equalsIgnoreCase("now", body)) {
			resp = new Date().toLocaleString();
		} else {
			resp = "ERROR REQ MSG!";
		}
		ByteBuf copiedBuffer = Unpooled.copiedBuffer(resp.getBytes());
		ctx.write(copiedBuffer);
		*/
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

}
