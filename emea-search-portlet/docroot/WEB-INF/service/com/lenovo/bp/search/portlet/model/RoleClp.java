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

import com.lenovo.bp.search.portlet.service.ClpSerializer;
import com.lenovo.bp.search.portlet.service.RoleLocalServiceUtil;
import com.lenovo.bp.search.portlet.service.persistence.RolePK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author siyan
 */
public class RoleClp extends BaseModelImpl<Role> implements Role {
	public RoleClp() {
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
	public RolePK getPrimaryKey() {
		return new RolePK(_roleId, _userId);
	}

	@Override
	public void setPrimaryKey(RolePK primaryKey) {
		setRoleId(primaryKey.roleId);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new RolePK(_roleId, _userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((RolePK)primaryKeyObj);
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

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_roleRemoteModel != null) {
			try {
				Class<?> clazz = _roleRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_roleRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_roleRemoteModel != null) {
			try {
				Class<?> clazz = _roleRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_roleRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_roleRemoteModel != null) {
			try {
				Class<?> clazz = _roleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_roleRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getScreenName() {
		return _screenName;
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;

		if (_roleRemoteModel != null) {
			try {
				Class<?> clazz = _roleRemoteModel.getClass();

				Method method = clazz.getMethod("setScreenName", String.class);

				method.invoke(_roleRemoteModel, screenName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRoleRemoteModel() {
		return _roleRemoteModel;
	}

	public void setRoleRemoteModel(BaseModel<?> roleRemoteModel) {
		_roleRemoteModel = roleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _roleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_roleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}



	@Override
	public Role toEscapedModel() {
		return (Role)ProxyUtil.newProxyInstance(Role.class.getClassLoader(),
			new Class[] { Role.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RoleClp clone = new RoleClp();

		clone.setRoleId(getRoleId());
		clone.setName(getName());
		clone.setUserId(getUserId());
		clone.setScreenName(getScreenName());

		return clone;
	}

	@Override
	public int compareTo(Role role) {
		RolePK primaryKey = role.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RoleClp)) {
			return false;
		}

		RoleClp role = (RoleClp)obj;

		RolePK primaryKey = role.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{roleId=");
		sb.append(getRoleId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.lenovo.bp.search.portlet.model.Role");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _roleId;
	private String _name;
	private long _userId;
	private String _userUuid;
	private String _screenName;
	private BaseModel<?> _roleRemoteModel;
	private Class<?> _clpSerializerClass = com.lenovo.bp.search.portlet.service.ClpSerializer.class;
}