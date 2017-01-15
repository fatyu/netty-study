package ren.xiayi.netty.cbc.service.socket;

import java.nio.charset.Charset;
import java.util.UUID;

import com.thoughtworks.xstream.XStream;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import ren.xiayi.netty.cbc.entity.req.TX;
import ren.xiayi.netty.cbc.processer.DataProcesser;
import ren.xiayi.netty.utils.XmlUtils;

public class CBCPayClient {
	private String host;
	private int port;

	public CBCPayClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void send(String data, DataProcesser dataProcesser) throws InterruptedException {
		Bootstrap bootstrap = new Bootstrap();
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		try {
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new StringEncoder(Charset.forName("GB18030")));
							String delimiter = "</TX>";
							ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(delimiter.getBytes());
							ch.pipeline().addLast(new DelimiterBasedFrameDecoder(65535, wrappedBuffer));
							ch.pipeline().addLast(new StringDecoder(Charset.forName("GB18030")));
							ch.pipeline().addLast(new CBCPayClientHandler(data, dataProcesser));
						}
					});
			ChannelFuture future = bootstrap.connect(host, port).sync();
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		TX tx = new TX();
		tx.setCUST_ID(UUID.randomUUID().toString());
		tx.setLANGUAGE("CN");
		XStream xStream = ren.xiayi.netty.utils.XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", TX.class);
		String data = XmlUtils.toXml(xStream, tx);
		new CBCPayClient("127.0.0.1", 12345).send(data, resData -> System.out.println("processer handle data......"));
	}
}
