package ren.xiayi.netty.cbc.service.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import ren.xiayi.netty.cbc.processer.DataProcesser;

public class CBCPayClientHandler extends ChannelInboundHandlerAdapter {

	private String data;

	public CBCPayClientHandler(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public CBCPayClientHandler(String data, DataProcesser dataProcesser) {
		this.data = data;
		this.dataProcesser = dataProcesser;
	}

	private DataProcesser dataProcesser;

	public DataProcesser getDataProcesser() {
		return dataProcesser;
	}

	public void setDataProcesser(DataProcesser dataProcesser) {
		this.dataProcesser = dataProcesser;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		ctx.writeAndFlush(data);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		String resData = (String) msg;
		dataProcesser.processData(resData + "</TX>");
		ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}