package ren.xiayi.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Charsets;

public class TimeServerHandler extends ChannelHandlerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx, msg);
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);//read buf data to req
		String body = new String(req, Charsets.UTF_8);
		System.out.println("the request data is :" + body);
		String resp = StringUtils.EMPTY;
		if (StringUtils.equalsIgnoreCase("now", body)) {
			resp = new Date().toLocaleString();
		} else {
			resp = "ERROR REQ MSG!";
		}
		ByteBuf copiedBuffer = Unpooled.copiedBuffer(resp.getBytes());
		ctx.write(copiedBuffer);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		flush(ctx);
	}
}
