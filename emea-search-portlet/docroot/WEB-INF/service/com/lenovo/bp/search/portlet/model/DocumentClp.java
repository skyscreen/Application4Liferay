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
public class DocumentClp extends BaseModelImpl<Document> implements Document {
	public DocumentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id_;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("createDate", getCreateDate());
		attributes.put("articleId", getArticleId());
		attributes.put("version", getVersion());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ = (Long)attributes.get("id_");

		if (id_ != null) {
			setId_(id_);
		}

		String createDate = (String)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Double version = (Double)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getId_() {
		return _id_;
	}

	@Override
	public void setId_(long id_) {
		_id_ = id_;

		if (_documentRemoteModel != null) {
			try {
				Class<?> clazz = _documentRemoteModel.getClass();

				Method method = clazz.getMethod("setId_", long.class);

				method.invoke(_documentRemoteModel, id_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(String createDate) {
		_createDate = createDate;

		if (_documentRemoteModel != null) {
			try {
				Class<?> clazz = _documentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", String.class);

				method.invoke(_documentRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_articleId = articleId;

		if (_documentRemoteModel != null) {
			try {
				Class<?> clazz = _documentRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleId", long.class);

				method.invoke(_documentRemoteModel, articleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVersion() {
		return _version;
	}

	@Override
	public void setVersion(double version) {
		_version = version;

		if (_documentRemoteModel != null) {
			try {
				Class<?> clazz = _documentRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", double.class);

				method.invoke(_documentRemoteModel, version);
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

		if (_documentRemoteModel != null) {
			try {
				Class<?> clazz = _documentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_documentRemoteModel, title);
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

		if (_documentRemoteModel != null) {
			try {
				Class<?> clazz = _documentRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_documentRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDocumentRemoteModel() {
		return _documentRemoteModel;
	}

	public void setDocumentRemoteModel(BaseModel<?> documentRemoteModel) {
		_documentRemoteModel = documentRemoteModel;
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

		Class<?> remoteModelClass = _documentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_documentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public Document toEscapedModel() {
		return (Document)ProxyUtil.newProxyInstance(Document.class.getClassLoader(),
			new Class[] { Document.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DocumentClp clone = new DocumentClp();

		clone.setId_(getId_());
		clone.setCreateDate(getCreateDate());
		clone.setArticleId(getArticleId());
		clone.setVersion(getVersion());
		clone.setTitle(getTitle());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(Document document) {
		long primaryKey = document.getPrimaryKey();

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

		if (!(obj instanceof DocumentClp)) {
			return false;
		}

		DocumentClp document = (DocumentClp)obj;

		long primaryKey = document.getPrimaryKey();

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

		sb.append("{id_=");
		sb.append(getId_());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.lenovo.bp.search.portlet.model.Document");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_</column-name><column-value><![CDATA[");
		sb.append(getId_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_;
	private String _createDate;
	private long _articleId;
	private double _version;
	private String _title;
	private String _content;
	private BaseModel<?> _documentRemoteModel;
	private Class<?> _clpSerializerClass = com.lenovo.bp.search.portlet.service.ClpSerializer.class;
}