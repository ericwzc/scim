package com.schenker.docking.scim.config;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.charon3.core.exceptions.BadRequestException;
import org.wso2.charon3.core.exceptions.CharonException;
import org.wso2.charon3.core.exceptions.ConflictException;
import org.wso2.charon3.core.exceptions.ForbiddenException;
import org.wso2.charon3.core.exceptions.NotFoundException;
import org.wso2.charon3.core.exceptions.NotImplementedException;
import org.wso2.charon3.core.extensions.UserManager;
import org.wso2.charon3.core.objects.Group;
import org.wso2.charon3.core.objects.User;
import org.wso2.charon3.core.utils.codeutils.SearchRequest;

class GxdUserManager implements UserManager {

	private static Logger logger = LoggerFactory.getLogger(UserManager.class);

	@Override
	public User createUser(User user, Map<String, Boolean> requiredAttributes)
			throws CharonException, ConflictException, BadRequestException, ForbiddenException {
		logger.info("user created successfully:{}", user);
		return user;
	}

	@Override
	public User getUser(String id, Map<String, Boolean> requiredAttributes)
			throws CharonException, BadRequestException, NotFoundException {
		User user = new User();
		user.setId(id);
		user.setUserName("vindula");
		user.setSchema("urn:ietf:params:scim:schemas:core:2.0:User");
		user.setLastModifiedInstant(Instant.now());
		return user;
	}

	@Override
	public void deleteUser(String userId)
			throws NotFoundException, CharonException, NotImplementedException, BadRequestException {
		logger.info("user with id {} deleted successfully", userId);
	}

	@Override
	public List<Object> listUsersWithPost(SearchRequest searchRequest, Map<String, Boolean> requiredAttributes)
			throws CharonException, NotImplementedException, BadRequestException {
		throw new CharonException("listUsersWithPost not implemented");
	}

	@Override
	public User updateUser(User updatedUser, Map<String, Boolean> requiredAttributes)
			throws NotImplementedException, CharonException, BadRequestException, NotFoundException {
		logger.info("updated user successfully:{}", updatedUser);
		return updatedUser;
	}

	@Override
	public User getMe(String userName, Map<String, Boolean> requiredAttributes)
			throws CharonException, BadRequestException, NotFoundException {
		throw new CharonException("getMe not implemented");
	}

	@Override
	public User createMe(User user, Map<String, Boolean> requiredAttributes)
			throws CharonException, ConflictException, BadRequestException, ForbiddenException {
		throw new CharonException("createMe not implemented");
	}

	@Override
	public void deleteMe(String userName)
			throws NotFoundException, CharonException, NotImplementedException, BadRequestException {
		throw new CharonException("deleteMe not implemented");
	}

	@Override
	public User updateMe(User updatedUser, Map<String, Boolean> requiredAttributes)
			throws NotImplementedException, CharonException, BadRequestException, NotFoundException {
		throw new CharonException("updateMe not implemented");
	}

	@Override
	public Group createGroup(Group group, Map<String, Boolean> requiredAttributes)
			throws CharonException, ConflictException, NotImplementedException, BadRequestException {
		throw new CharonException("createGroup not implemented");
	}

	@Override
	public Group getGroup(String id, Map<String, Boolean> requiredAttributes)
			throws NotImplementedException, BadRequestException, CharonException, NotFoundException {
		throw new CharonException("getGroup not implemented");
	}

	@Override
	public void deleteGroup(String id)
			throws NotFoundException, CharonException, NotImplementedException, BadRequestException {
		throw new CharonException("getGroup not implemented");
	}

	@Override
	public Group updateGroup(Group oldGroup, Group newGroup, Map<String, Boolean> requiredAttributes)
			throws NotImplementedException, BadRequestException, CharonException, NotFoundException {
		throw new CharonException("updateGroup not implemented");
	}

	@Override
	public List<Object> listGroupsWithPost(SearchRequest searchRequest, Map<String, Boolean> requiredAttributes)
			throws NotImplementedException, BadRequestException, CharonException {
		throw new CharonException("listGroupWithPost not implemented");
	}

}