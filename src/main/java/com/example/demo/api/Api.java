package com.example.demo.api;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;

import reactor.netty.http.client.HttpClient;

@SuppressWarnings("unused")
public class Api {

	private Logger logger = Logger.getLogger(Api.class.getName());
	
	private HttpClient client;
	private String apiUrl;
	private String path ="";
	private JSONObject params;
	private String authorizationHeader = "";
	private String valueResponse;
	private ApiConfigClient config;
	private WebClient.Builder webclientBuilder;
	
	
	public String getApiUrl() {return apiUrl;}
	public void setApiUrl(String apiUrl) {this.apiUrl = apiUrl;}
	public void setPath(String path) {this.path = path;}
	public void setWebclientBuilder(WebClient.Builder webclientBuilder) {this.webclientBuilder = webclientBuilder;}
	public void setAuthorizationHeader(String authorizationHeader) {this.authorizationHeader = authorizationHeader;}
	public String getValueResponse() {return valueResponse;}
	
	
	private void initConfig() {
		logger.log(Level.INFO,"Starting the API configuration");
		config = new ApiConfigClient();
		client = config.getClient();
	}
	
	private void sendGet() {
		logger.log(Level.INFO,"Api url: {0}",this.apiUrl);
		logger.log(Level.INFO,"Path: {0}",this.path);
		WebClient build = webclientBuilder.clientConnector(new ReactorClientHttpConnector(client))
		.baseUrl(this.apiUrl+this.path)
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.defaultUriVariables(Collections.singletonMap("url", this.apiUrl+this.path))
		.build();
	
		JsonNode block = build.method(HttpMethod.GET).uri("/")
				.retrieve().bodyToMono(JsonNode.class).block();
		valueResponse = block.get("name").toString();
		logger.log(Level.INFO,"Break point");
	}
	
	public void initGet() {
		initConfig();
		sendGet();
	}
	
	
}
