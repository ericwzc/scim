package com.schenker.docking.scim.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wso2.charon3.core.extensions.UserManager;
import org.wso2.charon3.core.protocol.endpoints.AbstractResourceManager;

import okhttp3.OkHttpClient;

@Configuration
public class ScimConfig {
	
	@Value("${gxd.scim.user.baseUrl}")
	String userBaseLocation;

	@Bean
	public UserManager userManager(OkHttpClient okHttpClient) {
		return new GxdUserManager(okHttpClient);
	}

	@Bean
	public GxdUserResourceManager gxdUserResourceManager(UserManager userManager) {
		Map<String, String> map = new HashMap<>(); 
		map.put("/Users", userBaseLocation);
		AbstractResourceManager.setEndpointURLMap(map);
		return new GxdUserResourceManager(userManager);
	}
}
