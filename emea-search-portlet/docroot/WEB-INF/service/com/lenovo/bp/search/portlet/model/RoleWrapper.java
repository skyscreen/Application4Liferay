/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lenovo.bp.search.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Role}.
 * </p>
 *
 * @author siyan
 * @see Role
 * @generated
 */
public class RoleWrapper implements Role, ModelWrapper<Role> {
	public RoleWrapper(Role role) {
		_role = role;
	}

	@Override
	public Class<?> getModelClass() {
		return Role.class;
	}

	@Override
	public String getModelClassName() {
		return Role.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("name", getName());
		attributes.put("userId", getUserId());
		attributes.put("screenName", getScreenName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}
	}

	/**
	* Returns the primary key of this role.
	*
	* @return the primary key of this role
	*/
	@Override
	public com.lenovo.bp.search.portlet.service.persistence.RolePK getPrimaryKey() {
		return _role.getPrimaryKey();
	}

	/**
	* Sets the primary key of this role.
	*
	* @param primaryKey the primary key of this role
	*/
	@Override
	public void setPrimaryKey(
		com.lenovo.bp.search.portlet.service.persistence.RolePK primaryKey) {
		_role.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the role ID of this role.
	*
	* @return the role ID of this role
	*/
	@Override
	public long getRoleId() {
		return _role.getRoleId();
	}

	/**
	* Sets the role ID of this role.
	*
	* @param roleId the role ID of this role
	*/
	@Override
	public void setRoleId(long roleId) {
		_role.setRoleId(roleId);
	}

	/**
	* Returns the name of this role.
	*
	* @return the name of this role
	*/
	@Override
	public java.lang.String getName() {
		return _role.getName();
	}

	/**
	* Sets the name of this role.
	*
	* @param name the name of this role
	*/
	@Override
	public void setName(java.lang.String name) {
		_role.setName(name);
	}

	/**
	* Returns the user ID of this role.
	*
	* @return the user ID of this role
	*/
	@Override
	public long getUserId() {
		return _role.getUserId();
	}

	/**
	* Sets the user ID of this role.
	*
	* @param userId the user ID of this role
	*/
	@Override
	public void setUserId(long userId) {
		_role.setUserId(userId);
	}

	/**
	* Returns the user uuid of this role.
	*
	* @return the user uuid of this role
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role.getUserUuid();
	}

	/**
	* Sets the user uuid of this role.
	*
	* @param userUuid the user uuid of this role
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_role.setUserUuid(userUuid);
	}

	/**
	* Returns the screen name of this role.
	*
	* @return the screen name of this role
	*/
	@Override
	public java.lang.String getScreenName() {
		return _role.getScreenName();
	}

	/**
	* Sets the screen name of this role.
	*
	* @param screenName the screen name of this role
	*/
	@Override
	public void setScreenName(java.lang.String screenName) {
		_role.setScreenName(screenName);
	}

	@Override
	public boolean isNew() {
		return _role.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_role.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _role.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_role.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _role.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _role.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_role.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _role.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_role.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_role.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_role.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RoleWrapper((Role)_role.clone());
	}

	@Override
	public int compareTo(com.lenovo.bp.search.portlet.model.Role role) {
		return _role.compareTo(role);
	}

	@Override
	public int hashCode() {
		return _role.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lenovo.bp.search.portlet.model.Role> toCacheModel() {
		return _role.toCacheModel();
	}

	@Override
	public com.lenovo.bp.search.portlet.model.Role toEscapedModel() {
		return new RoleWrapper(_role.toEscapedModel());
	}

	@Override
	public com.lenovo.bp.search.portlet.model.Role toUnescapedModel() {
		return new RoleWrapper(_role.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _role.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _role.toXmlString();
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RoleWrapper)) {
			return false;
		}

		RoleWrapper roleWrapper = (RoleWrapper)obj;

		if (Validator.equals(_role, roleWrapper._role)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Role getWrappedRole() {
		return _role;
	}

	@Override
	public Role getWrappedModel() {
		return _role;
	}

	@Override
	public void resetOriginalValues() {
		_role.resetOriginalValues();
	}

	private Role _role;
}