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

package com.lenovo.bp.search.portlet.model.impl;

import com.lenovo.bp.search.portlet.model.Role;
import com.lenovo.bp.search.portlet.model.RoleModel;
import com.lenovo.bp.search.portlet.model.RoleSoap;
import com.lenovo.bp.search.portlet.service.persistence.RolePK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Role service. Represents a row in the &quot;roleview_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.lenovo.bp.search.portlet.model.RoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RoleImpl}.
 * </p>
 *
 * @author siyan
 * @see RoleImpl
 * @see com.lenovo.bp.search.portlet.model.Role
 * @see com.lenovo.bp.search.portlet.model.RoleModel
 * @generated
 */
@JSON(strict = true)
public class RoleModelImpl extends BaseModelImpl<Role> implements RoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a role model instance should use the {@link com.lenovo.bp.search.portlet.model.Role} interface instead.
	 */
	public static final String TABLE_NAME = "roleview_";
	public static final Object[][] TABLE_COLUMNS = {
			{ "roleId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "screenName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table roleview_ (roleId LONG not null,name VARCHAR(75) null,userId LONG not null,screenName VARCHAR(75) null,primary key (roleId, userId))";
	public static final String TABLE_SQL_DROP = "drop table roleview_";
	public static final String ORDER_BY_JPQL = " ORDER BY role.id.roleId ASC, role.id.userId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY roleview_.roleId ASC, roleview_.userId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.lenovo.bp.search.portlet.model.Role"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.lenovo.bp.search.portlet.model.Role"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Role toModel(RoleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Role model = new RoleImpl();

		model.setRoleId(soapModel.getRoleId());
		model.setName(soapModel.getName());
		model.setUserId(soapModel.getUserId());
		model.setScreenName(soapModel.getScreenName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Role> toModels(RoleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Role> models = new ArrayList<Role>(soapModels.length);

		for (RoleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.lenovo.bp.search.portlet.model.Role"));

	public RoleModelImpl() {
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

	@JSON
	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getScreenName() {
		if (_screenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _screenName;
		}
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	@Override
	public Role toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Role)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RoleImpl roleImpl = new RoleImpl();

		roleImpl.setRoleId(getRoleId());
		roleImpl.setName(getName());
		roleImpl.setUserId(getUserId());
		roleImpl.setScreenName(getScreenName());

		roleImpl.resetOriginalValues();

		return roleImpl;
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

		if (!(obj instanceof Role)) {
			return false;
		}

		Role role = (Role)obj;

		RolePK primaryKey = role.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Role> toCacheModel() {
		RoleCacheModel roleCacheModel = new RoleCacheModel();

		roleCacheModel.roleId = getRoleId();

		roleCacheModel.name = getName();

		String name = roleCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			roleCacheModel.name = null;
		}

		roleCacheModel.userId = getUserId();

		roleCacheModel.screenName = getScreenName();

		String screenName = roleCacheModel.screenName;

		if ((screenName != null) && (screenName.length() == 0)) {
			roleCacheModel.screenName = null;
		}

		return roleCacheModel;
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

	private static ClassLoader _classLoader = Role.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Role.class };
	private long _roleId;
	private String _name;
	private long _userId;
	private String _userUuid;
	private String _screenName;
	private Role _escapedModel;
}