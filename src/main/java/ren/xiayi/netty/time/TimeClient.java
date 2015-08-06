package ren.xiayi.netty.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class TimeClient {

	public void connect(String host, int port) {
		EventLoopGroup clientGroup = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(clientGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new StringDecoder()).addLast(new LineBasedFrameDecoder(1024))
									.addLast(new TimeClientHandler());
						}
					});

			ChannelFuture future = bootstrap.connect(host, port).sync();
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			clientGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		int port = 8080;
		String host = "127.0.0.1";
		if (ArrayUtils.isNotEmpty(args)) {
			host = args[0];
			port = NumberUtils.toInt(args[1]);
		}
		TimeClient client = new TimeClient();
		client.connect(host, port);
	}
}
