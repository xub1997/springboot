package com.xub.wechat.websocket;

import com.xub.wechat.config.NettyConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WSServer {

	private Logger logger= LoggerFactory.getLogger(this.getClass());


	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	private ServerBootstrap server;


	private volatile static WSServer uniqueSingleton;

	private WSServer() {
		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();
		server = new ServerBootstrap();
		server.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new WSServerInitialzer());
	}

	public static WSServer getInstance() {
		if (null == uniqueSingleton) {
			synchronized (WSServer.class) {
				if (null == uniqueSingleton) {
					uniqueSingleton = new WSServer();
				}
			}
		}
		return uniqueSingleton;
	}

	public void start(int port) {
		try {
			ChannelFuture future = server.bind(port).sync();
			logger.info("netty websocket server 启动完毕...,开启端口：{}",port);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void stop(){
		// 优雅退出，释放线程池资源
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		logger.info("netty websocket server 关闭~~~");
	}
	
}
