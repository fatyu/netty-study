package org.fatyu.discard;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class DiscardClient {
    private  String host = "127.0.0.1";
    private  int port=8080;
    private  int msgSize=256;
    public DiscardClient(final String host, final int port, final int msgSize) {
        this.host = host;
        this.port = port;
        this.msgSize = msgSize;
    }



    public void run(){
        final EventLoopGroup group = new NioEventLoopGroup();
        final Bootstrap bs = new Bootstrap();
        bs.group(group).channel(NioSocketChannel.class).handler(new DiscardClientHandler(msgSize));
        final ChannelFuture future  = bs.connect(host, port);
        try {
            future.channel().closeFuture().sync();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }finally{
            group.shutdownGracefully();
        }
    }

    public static void main(final String[] args) {
        final String host = "127.0.0.1";
        final int port=8080;
        final int msgSize=256;
        new DiscardClient(host,port,msgSize).run();
    }


}
