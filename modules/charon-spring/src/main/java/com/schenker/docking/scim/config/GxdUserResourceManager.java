package com.schenker.docking.scim.config;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.wso2.charon3.core.extensions.UserManager;
import org.wso2.charon3.core.protocol.SCIMResponse;
import org.wso2.charon3.core.protocol.endpoints.UserResourceManager;

public class GxdUserResourceManager extends UserResourceManager {
	private UserManager userManager;

	public GxdUserResourceManager(UserManager userManager) {
		super();
		this.userManager = userManager;
	}

	public ResponseEntity<String> get(String id, String attributes, String excludeAttributes) {
		return toResponseEntity(super.get(id, userManager, attributes, excludeAttributes));
	}

	public ResponseEntity<String> create(String scimObjectString, String attributes, String excludeAttributes) {
		return toResponseEntity(super.create(scimObjectString, userManager, attributes, excludeAttributes));
	}
	
	public ResponseEntity<String> delete(String id) {
		return toResponseEntity(super.delete(id, userManager));
	}
	
	
	public ResponseEntity<String> listWithGET(String filter, int startIndex, int count, String sortBy,
        String sortOrder, String domainName, String attributes, String excludeAttributes) {
		return toResponseEntity(super.listWithGET(userManager, filter, startIndex, count, sortBy, sortOrder, domainName, attributes, excludeAttributes));
	}
	
	public ResponseEntity<String> listWithGET(String filter, Integer startIndexInt, Integer countInt,
        String sortBy, String sortOrder, String domainName, String attributes, String excludeAttributes) {
		return toResponseEntity(super.listWithGET(userManager, filter, startIndexInt, countInt, sortBy, sortOrder, domainName, attributes, excludeAttributes));
	}
	
	public ResponseEntity<String> listWithPOST(String resourceString) {
		return toResponseEntity(super.listWithPOST(resourceString, userManager));
	}

	public ResponseEntity<String> updateWithPUT(String existingId, String scimObjectString,
                                  	  String attributes, String excludeAttributes) {
		return toResponseEntity(super.updateWithPUT(existingId, scimObjectString, userManager, attributes, excludeAttributes));
	}
	

	public ResponseEntity<String> updateWithPATCH(String existingId, String scimObjectString,
			String attributes, String excludeAttributes) {
		return toResponseEntity(super.updateWithPATCH(existingId, scimObjectString, userManager, attributes, excludeAttributes));
	}

	private ResponseEntity<String> toResponseEntity(SCIMResponse scimResp) {
		MultiValueMap<String, String> mv = new LinkedMultiValueMap<>();
		if (scimResp.getHeaderParamMap() != null) {
			for (Map.Entry<String, String> entry : scimResp.getHeaderParamMap().entrySet()) {
				mv.add(entry.getKey(), entry.getValue());
			}
		}

		return new ResponseEntity<>(scimResp.getResponseMessage(), mv, HttpStatus.valueOf(scimResp.getResponseStatus()));
	}

}