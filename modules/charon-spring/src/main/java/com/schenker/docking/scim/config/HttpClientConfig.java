package com.schenker.docking.scim.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Configuration
public class HttpClientConfig {

	@Value("${gxd.apiKey}")
	String apiKey;
	
	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder().addInterceptor(
				new Interceptor() {
					@Override
					public Response intercept(Chain chain) throws IOException {
						Request req = chain.request();
						Request nReq = req.newBuilder().addHeader("X-Api-Key", apiKey).build();
						return chain.proceed(nReq);
					}}).build();
	}
	
}
