package com.schenker.docking.scim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity http) {
		http.csrf().disable()
				.authorizeExchange(exchanges -> exchanges.anyExchange().permitAll());
		// use the following for bearer token authorization
//				.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
//				.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		return http.build();
	}
}
