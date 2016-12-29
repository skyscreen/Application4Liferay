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

import java.io.Serializable;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lenovo.bp.search.portlet.model.ExtDocument;
import com.lenovo.bp.search.portlet.model.ExtDocumentModel;
import com.lenovo.bp.search.portlet.model.LangTitle;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

/**
 * The base model implementation for the ExtDocument service. Represents a row in the &quot;search_ExtDocument&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.lenovo.bp.search.portlet.model.ExtDocumentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExtDocumentImpl}.
 * </p>
 *
 * @author siyan
 * @see ExtDocumentImpl
 * @see com.lenovo.bp.search.portlet.model.ExtDocument
 * @see com.lenovo.bp.search.portlet.model.ExtDocumentModel
 * @generated
 */
@JSON(strict = true)
public class ExtDocumentModelImpl extends BaseModelImpl<ExtDocument>
	implements ExtDocumentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ext document model instance should use the {@link com.lenovo.bp.search.portlet.model.ExtDocument} interface instead.
	 */
	public static final String TABLE_NAME = "search_ExtDocument";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "createDate", Types.VARCHAR },
			{ "articleId", Types.BIGINT },
			{ "version", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table search_ExtDocument (id_ LONG not null primary key,createDate VARCHAR(75) null,articleId LONG,version DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table search_ExtDocument";
	public static final String ORDER_BY_JPQL = " ORDER BY extDocument.id_ ASC";
	public static final String ORDER_BY_SQL = " ORDER BY search_ExtDocument.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.lenovo.bp.search.portlet.model.ExtDocument"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.lenovo.bp.search.portlet.model.ExtDocument"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.lenovo.bp.search.portlet.model.ExtDocument"));

	public ExtDocumentModelImpl() {
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
	public Class<?> getModelClass() {
		return ExtDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ExtDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("createDate", getCreateDate());
		attributes.put("articleId", getArticleId());
		attributes.put("version", getVersion());
		attributes.put("title", getListLangTitle());

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

	@JSON
	@Override
	public long getId_() {
		return _id_;
	}

	@Override
	public void setId_(long id_) {
		_id_ = id_;
	}

	@Override
	public String getCreateDate() {
		if (_createDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _createDate;
		}
	}

	@Override
	public void setCreateDate(String createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	@JSON
	@Override
	public double getVersion() {
		return _version;
	}

	@Override
	public void setVersion(double version) {
		_version = version;
	}
	
	
	@JSON
	@Override
	public List<LangTitleImpl> getListLangTitle() {
		return _listLangTitle;
	}

	@Override
	public void setListLangTitle(List<LangTitleImpl> listLangTitle) {
		_listLangTitle = listLangTitle;
	}	
	
	@Override
	public void setListLangContent(List<LangContentImpl> listLangContent) {
		_listLangContent = listLangContent;
	}	
	
	@JSON
	@Override
	public List<LangContentImpl> getListLangContent() {
		return _listLangContent;
	}	
	
	
	@Override
	public void setUrl(String url) {
		_url = url;
	}	
	
	@JSON
	@Override
	public String getUrl() {
		return _url;
	}
	

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ExtDocument.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ExtDocument toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ExtDocument)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ExtDocumentImpl extDocumentImpl = new ExtDocumentImpl();

		extDocumentImpl.setId_(getId_());
		extDocumentImpl.setCreateDate(getCreateDate());
		extDocumentImpl.setArticleId(getArticleId());
		extDocumentImpl.setVersion(getVersion());
		extDocumentImpl.setListLangTitle(getListLangTitle());

		extDocumentImpl.resetOriginalValues();

		return extDocumentImpl;
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

		if (!(obj instanceof ExtDocument)) {
			return false;
		}

		ExtDocument extDocument = (ExtDocument)obj;

		long primaryKey = extDocument.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ExtDocument> toCacheModel() {
		ExtDocumentCacheModel extDocumentCacheModel = new ExtDocumentCacheModel();

		extDocumentCacheModel.id_ = getId_();

		extDocumentCacheModel.createDate = getCreateDate();

		String createDate = extDocumentCacheModel.createDate;

		if ((createDate != null) && (createDate.length() == 0)) {
			extDocumentCacheModel.createDate = null;
		}

		extDocumentCacheModel.articleId = getArticleId();

		extDocumentCacheModel.version = getVersion();
		
		extDocumentCacheModel.title = getListLangTitle();

		return extDocumentCacheModel;
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

	private static ClassLoader _classLoader = ExtDocument.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ExtDocument.class
		};
	private long _id_;
	private String _createDate;
	private long _articleId;
	private double _version;
	private ExtDocument _escapedModel;
	private List<LangTitleImpl> _listLangTitle;
	private List<LangContentImpl> _listLangContent;
	private String _url;
	
}