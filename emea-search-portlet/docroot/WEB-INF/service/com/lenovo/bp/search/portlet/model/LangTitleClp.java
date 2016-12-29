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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author siyan
 */
public class LangTitleClp extends BaseModelImpl<LangTitle> implements LangTitle {
	public LangTitleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LangTitle.class;
	}

	@Override
	public String getModelClassName() {
		return LangTitle.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _locals;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setLocals(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _locals;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locals", getLocals());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String locals = (String)attributes.get("locals");

		if (locals != null) {
			setLocals(locals);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public String getLocals() {
		return _locals;
	}

	@Override
	public void setLocals(String locals) {
		_locals = locals;

		if (_langTitleRemoteModel != null) {
			try {
				Class<?> clazz = _langTitleRemoteModel.getClass();

				Method method = clazz.getMethod("setLocals", String.class);

				method.invoke(_langTitleRemoteModel, locals);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_langTitleRemoteModel != null) {
			try {
				Class<?> clazz = _langTitleRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_langTitleRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLangTitleRemoteModel() {
		return _langTitleRemoteModel;
	}

	public void setLangTitleRemoteModel(BaseModel<?> langTitleRemoteModel) {
		_langTitleRemoteModel = langTitleRemoteModel;
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

		Class<?> remoteModelClass = _langTitleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_langTitleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public LangTitle toEscapedModel() {
		return (LangTitle)ProxyUtil.newProxyInstance(LangTitle.class.getClassLoader(),
			new Class[] { LangTitle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LangTitleClp clone = new LangTitleClp();

		clone.setLocals(getLocals());
		clone.setTitle(getTitle());

		return clone;
	}

	@Override
	public int compareTo(LangTitle langTitle) {
		String primaryKey = langTitle.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LangTitleClp)) {
			return false;
		}

		LangTitleClp langTitle = (LangTitleClp)obj;

		String primaryKey = langTitle.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{locals=");
		sb.append(getLocals());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.lenovo.bp.search.portlet.model.LangTitle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>locals</column-name><column-value><![CDATA[");
		sb.append(getLocals());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _locals;
	private String _title;
	private BaseModel<?> _langTitleRemoteModel;
	private Class<?> _clpSerializerClass = com.lenovo.bp.search.portlet.service.ClpSerializer.class;
}