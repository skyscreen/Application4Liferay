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
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lenovo.bp.search.portlet.model.impl.LangContentImpl;
import com.lenovo.bp.search.portlet.model.impl.LangTitleImpl;
import com.lenovo.bp.search.portlet.service.ClpSerializer;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

/**
 * @author siyan
 */
public class ExtDocumentClp extends BaseModelImpl<ExtDocument>
	implements ExtDocument {
	public ExtDocumentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ExtDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ExtDocument.class.getName();
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
	}

	@Override
	public long getId_() {
		return _id_;
	}

	@Override
	public void setId_(long id_) {
		_id_ = id_;

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setId_", long.class);

				method.invoke(_extDocumentRemoteModel, id_);
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

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", String.class);

				method.invoke(_extDocumentRemoteModel, createDate);
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

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleId", long.class);

				method.invoke(_extDocumentRemoteModel, articleId);
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

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", double.class);

				method.invoke(_extDocumentRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}
	
	@Override
	public List<LangTitleImpl> getListLangTitle() {
		return _listLangTitle;
	}	

	@Override
	public void setListLangTitle(List<LangTitleImpl> listLangTitle) {
		_listLangTitle = listLangTitle;

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setListLangTitle", List.class);

				method.invoke(_extDocumentRemoteModel, listLangTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}
	
	@Override
	public List<LangContentImpl> getListLangContent() {
		return _listLangContent;
	}	

	@Override
	public void setListLangContent(List<LangContentImpl> listLangContent) {
		_listLangContent = listLangContent;

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setListLangContent", List.class);

				method.invoke(_extDocumentRemoteModel, listLangContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}	
	
	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_extDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _extDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_extDocumentRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}	
	
	public BaseModel<?> getExtDocumentRemoteModel() {
		return _extDocumentRemoteModel;
	}

	public void setExtDocumentRemoteModel(BaseModel<?> extDocumentRemoteModel) {
		_extDocumentRemoteModel = extDocumentRemoteModel;
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

		Class<?> remoteModelClass = _extDocumentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_extDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public ExtDocument toEscapedModel() {
		return (ExtDocument)ProxyUtil.newProxyInstance(ExtDocument.class.getClassLoader(),
			new Class[] { ExtDocument.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExtDocumentClp clone = new ExtDocumentClp();

		clone.setId_(getId_());
		clone.setCreateDate(getCreateDate());
		clone.setArticleId(getArticleId());
		clone.setVersion(getVersion());

		return clone;
	}

	@Override
	public int compareTo(ExtDocument extDocument) {
		long primaryKey = extDocument.getPrimaryKey();

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

		if (!(obj instanceof ExtDocumentClp)) {
			return false;
		}

		ExtDocumentClp extDocument = (ExtDocumentClp)obj;

		long primaryKey = extDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id_=");
		sb.append(getId_());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.lenovo.bp.search.portlet.model.ExtDocument");
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_;
	private String _createDate;
	private long _articleId;
	private double _version;
	private List<LangTitleImpl> _listLangTitle;
	private List<LangContentImpl> _listLangContent;
	private String _url;
	private BaseModel<?> _extDocumentRemoteModel;
	private Class<?> _clpSerializerClass = com.lenovo.bp.search.portlet.service.ClpSerializer.class;
}