package com.example.demo.api;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

public class ApiConfigClient {
	
	private HttpClient client;
	
	public HttpClient getClient() {
		
		client = HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
				.option(ChannelOption.SO_KEEPALIVE, true)
				.option(EpollChannelOption.TCP_KEEPIDLE, 300)
				.option(EpollChannelOption.TCP_KEEPINTVL, 60)
				.responseTimeout(Duration.ofSeconds(1))
				.doOnConnected(connection ->{
					connection.addHandlerLast(new ReadTimeoutHandler(5000,TimeUnit.MILLISECONDS));
					connection.addHandlerLast(new WriteTimeoutHandler(5000,TimeUnit.MILLISECONDS));
				});
		
		return client;
	}
}
