package com.schenker.docking.scim.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schenker.docking.scim.config.GxdUserResourceManager;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Controller
@RequestMapping("/scim/v2/Users")
public class UserController {
	
	@Autowired
	GxdUserResourceManager gxdUserResourceManager;
	
//	@GetMapping("/{id}")
//	public Mono<ResponseEntity<String>> ok(@PathVariable("id") String id, 
//			@RequestParam(value = "attributes", required = false)String attributes,
//			@RequestParam(value = "excludedAttributes", required = false)String excludedAttributes) {
//		return Mono.just(gxdUserResourceManager.get(id, excludedAttributes, attributes));
//	}
	
	@PostMapping
	public Mono<ResponseEntity<String>> createUser(@RequestBody String resourceString,
			@RequestParam(value = "attributes", required = false)String attributes,
			@RequestParam(value = "excludedAttributes", required = false)String excludedAttributes) {
		return monoResult(() -> gxdUserResourceManager.create(resourceString, excludedAttributes, attributes));
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<String>> deleteUser(@PathVariable("id")String id){
		return monoResult(() -> (gxdUserResourceManager.delete(id)));
	}
	
	@PutMapping("/{id}")
	public Mono<ResponseEntity<String>> updateUser(@PathVariable("id")String id, 
			                                       @RequestBody String resourceString,
												   @RequestParam(value = "attributes", required = false)String attributes,
												   @RequestParam(value = "excludedAttributes", required = false)String excludedAttributes) {
		return monoResult(() -> gxdUserResourceManager.updateWithPUT(id, resourceString, attributes, excludedAttributes));
	}
	
	private <T> Mono<T> monoResult(Callable<T> callable) {
		return Mono.fromCallable(callable).subscribeOn(Schedulers.boundedElastic());
	}
	
}
