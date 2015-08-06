package ren.xiayi.netty.time;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class TimeServer {

	private static int port = 8080;

	public void bind(int port) {
		EventLoopGroup parentGroup = new NioEventLoopGroup();
		EventLoopGroup childGroup = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(parentGroup, childGroup).childHandler(new ChildChannelHandler())
				.option(ChannelOption.SO_BACKLOG, 1024).channel(NioServerSocketChannel.class);
		try {
			ChannelFuture f = bootstrap.bind(port).sync();//bind port and sync success
			f.channel().closeFuture().sync();//block server
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (ArrayUtils.isNotEmpty(args)) {
			port = NumberUtils.toInt(args[0]);
		}
		new TimeServer().bind(port);//启动服务端
	}

	class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ch.pipeline().addLast(new TimeServerHandler()).addLast(new LineBasedFrameDecoder(1024))
					.addLast(new StringDecoder());
		}

	}
}
