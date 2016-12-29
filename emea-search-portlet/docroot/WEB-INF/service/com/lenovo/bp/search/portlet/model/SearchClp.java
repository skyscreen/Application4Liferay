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
import com.lenovo.bp.search.portlet.service.SearchLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author siyan
 */
public class SearchClp extends BaseModelImpl<Search> implements Search {
	public SearchClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Search.class;
	}

	@Override
	public String getModelClassName() {
		return Search.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("journalarticl_id", getJournalarticl_id());
		attributes.put("operat_type", getOperat_type());
		attributes.put("operat_time", getOperat_time());
		attributes.put("userId", getUserId());
		attributes.put("structureId", getStructureId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long journalarticl_id = (Long)attributes.get("journalarticl_id");

		if (journalarticl_id != null) {
			setJournalarticl_id(journalarticl_id);
		}

		Long operat_type = (Long)attributes.get("operat_type");

		if (operat_type != null) {
			setOperat_type(operat_type);
		}

		Date operat_time = (Date)attributes.get("operat_time");

		if (operat_time != null) {
			setOperat_time(operat_time);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String structureId = (String)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_searchRemoteModel != null) {
			try {
				Class<?> clazz = _searchRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_searchRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJournalarticl_id() {
		return _journalarticl_id;
	}

	@Override
	public void setJournalarticl_id(long journalarticl_id) {
		_journalarticl_id = journalarticl_id;

		if (_searchRemoteModel != null) {
			try {
				Class<?> clazz = _searchRemoteModel.getClass();

				Method method = clazz.getMethod("setJournalarticl_id",
						long.class);

				method.invoke(_searchRemoteModel, journalarticl_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOperat_type() {
		return _operat_type;
	}

	@Override
	public void setOperat_type(long operat_type) {
		_operat_type = operat_type;

		if (_searchRemoteModel != null) {
			try {
				Class<?> clazz = _searchRemoteModel.getClass();

				Method method = clazz.getMethod("setOperat_type", long.class);

				method.invoke(_searchRemoteModel, operat_type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOperat_time() {
		return _operat_time;
	}

	@Override
	public void setOperat_time(Date operat_time) {
		_operat_time = operat_time;

		if (_searchRemoteModel != null) {
			try {
				Class<?> clazz = _searchRemoteModel.getClass();

				Method method = clazz.getMethod("setOperat_time", Date.class);

				method.invoke(_searchRemoteModel, operat_time);
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

		if (_searchRemoteModel != null) {
			try {
				Class<?> clazz = _searchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_searchRemoteModel, userId);
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
	public String getStructureId() {
		return _structureId;
	}

	@Override
	public void setStructureId(String structureId) {
		_structureId = structureId;

		if (_searchRemoteModel != null) {
			try {
				Class<?> clazz = _searchRemoteModel.getClass();

				Method method = clazz.getMethod("setStructureId", String.class);

				method.invoke(_searchRemoteModel, structureId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSearchRemoteModel() {
		return _searchRemoteModel;
	}

	public void setSearchRemoteModel(BaseModel<?> searchRemoteModel) {
		_searchRemoteModel = searchRemoteModel;
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

		Class<?> remoteModelClass = _searchRemoteModel.getClass();

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

		Object returnValue = method.invoke(_searchRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SearchLocalServiceUtil.addSearch(this);
		}
		else {
			SearchLocalServiceUtil.updateSearch(this);
		}
	}

	@Override
	public Search toEscapedModel() {
		return (Search)ProxyUtil.newProxyInstance(Search.class.getClassLoader(),
			new Class[] { Search.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SearchClp clone = new SearchClp();

		clone.setId(getId());
		clone.setJournalarticl_id(getJournalarticl_id());
		clone.setOperat_type(getOperat_type());
		clone.setOperat_time(getOperat_time());
		clone.setUserId(getUserId());
		clone.setStructureId(getStructureId());

		return clone;
	}

	@Override
	public int compareTo(Search search) {
		long primaryKey = search.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchClp)) {
			return false;
		}

		SearchClp search = (SearchClp)obj;

		long primaryKey = search.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", journalarticl_id=");
		sb.append(getJournalarticl_id());
		sb.append(", operat_type=");
		sb.append(getOperat_type());
		sb.append(", operat_time=");
		sb.append(getOperat_time());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", structureId=");
		sb.append(getStructureId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.lenovo.bp.search.portlet.model.Search");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>journalarticl_id</column-name><column-value><![CDATA[");
		sb.append(getJournalarticl_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operat_type</column-name><column-value><![CDATA[");
		sb.append(getOperat_type());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operat_time</column-name><column-value><![CDATA[");
		sb.append(getOperat_time());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>structureId</column-name><column-value><![CDATA[");
		sb.append(getStructureId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _journalarticl_id;
	private long _operat_type;
	private Date _operat_time;
	private long _userId;
	private String _userUuid;
	private String _structureId;
	private BaseModel<?> _searchRemoteModel;
	private Class<?> _clpSerializerClass = com.lenovo.bp.search.portlet.service.ClpSerializer.class;
}