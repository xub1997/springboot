package com.xub.wechat.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class WSServer {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	private static class SingletionWSServer {
		static final WSServer instance = new WSServer();
	}

	public static WSServer getInstance() {
		return SingletionWSServer.instance;
	}

	private EventLoopGroup mainGroup;
	private EventLoopGroup subGroup;
	private ServerBootstrap server;
	private ChannelFuture future;

	public WSServer() {
		mainGroup = new NioEventLoopGroup();
		subGroup = new NioEventLoopGroup();
		server = new ServerBootstrap();
		server.group(mainGroup, subGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new WSServerInitialzer());
	}

	public void start() {
		//int port=nettyConfig.getPort();
		int port=8088;
		this.future = server.bind(port);
		logger.error("netty websocket server 启动完毕...,开启端口：{}",port);
	}
	
}
