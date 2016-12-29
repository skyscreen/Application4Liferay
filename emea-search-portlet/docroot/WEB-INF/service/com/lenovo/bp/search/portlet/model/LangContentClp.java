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
public class LangContentClp extends BaseModelImpl<LangContent>
	implements LangContent {
	public LangContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LangContent.class;
	}

	@Override
	public String getModelClassName() {
		return LangContent.class.getName();
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
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String locals = (String)attributes.get("locals");

		if (locals != null) {
			setLocals(locals);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public String getLocals() {
		return _locals;
	}

	@Override
	public void setLocals(String locals) {
		_locals = locals;

		if (_langContentRemoteModel != null) {
			try {
				Class<?> clazz = _langContentRemoteModel.getClass();

				Method method = clazz.getMethod("setLocals", String.class);

				method.invoke(_langContentRemoteModel, locals);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_langContentRemoteModel != null) {
			try {
				Class<?> clazz = _langContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_langContentRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLangContentRemoteModel() {
		return _langContentRemoteModel;
	}

	public void setLangContentRemoteModel(BaseModel<?> langContentRemoteModel) {
		_langContentRemoteModel = langContentRemoteModel;
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

		Class<?> remoteModelClass = _langContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_langContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public LangContent toEscapedModel() {
		return (LangContent)ProxyUtil.newProxyInstance(LangContent.class.getClassLoader(),
			new Class[] { LangContent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LangContentClp clone = new LangContentClp();

		clone.setLocals(getLocals());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(LangContent langContent) {
		String primaryKey = langContent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LangContentClp)) {
			return false;
		}

		LangContentClp langContent = (LangContentClp)obj;

		String primaryKey = langContent.getPrimaryKey();

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
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.lenovo.bp.search.portlet.model.LangContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>locals</column-name><column-value><![CDATA[");
		sb.append(getLocals());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _locals;
	private String _content;
	private BaseModel<?> _langContentRemoteModel;
	private Class<?> _clpSerializerClass = com.lenovo.bp.search.portlet.service.ClpSerializer.class;
}