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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lenovo.bp.search.portlet.service.http.RoleServiceSoap}.
 *
 * @author siyan
 * @see com.lenovo.bp.search.portlet.service.http.RoleServiceSoap
 * @generated
 */
public class RoleSoap implements Serializable {
	public static RoleSoap toSoapModel(Role model) {
		RoleSoap soapModel = new RoleSoap();

		soapModel.setRoleId(model.getRoleId());
		soapModel.setName(model.getName());
		soapModel.setUserId(model.getUserId());
		soapModel.setScreenName(model.getScreenName());

		return soapModel;
	}

	public static RoleSoap[] toSoapModels(Role[] models) {
		RoleSoap[] soapModels = new RoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RoleSoap[][] toSoapModels(Role[][] models) {
		RoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RoleSoap[] toSoapModels(List<Role> models) {
		List<RoleSoap> soapModels = new ArrayList<RoleSoap>(models.size());

		for (Role model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RoleSoap[soapModels.size()]);
	}

	public RoleSoap() {
	}

	public long getPrimaryKey() {
		return _roleId;
	}

	public void setPrimaryKey(long pk) {
		setRoleId(pk);
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	private long _roleId;
	private String _name;
	private long _userId;
	private String _screenName;
}