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
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author siyan
 * @see Document
 * @generated
 */
public class DocumentWrapper implements Document, ModelWrapper<Document> {
	public DocumentWrapper(Document document) {
		_document = document;
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

	/**
	* Returns the primary key of this document.
	*
	* @return the primary key of this document
	*/
	@Override
	public long getPrimaryKey() {
		return _document.getPrimaryKey();
	}

	/**
	* Sets the primary key of this document.
	*
	* @param primaryKey the primary key of this document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_document.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_ of this document.
	*
	* @return the id_ of this document
	*/
	@Override
	public long getId_() {
		return _document.getId_();
	}

	/**
	* Sets the id_ of this document.
	*
	* @param id_ the id_ of this document
	*/
	@Override
	public void setId_(long id_) {
		_document.setId_(id_);
	}

	/**
	* Returns the create date of this document.
	*
	* @return the create date of this document
	*/
	@Override
	public java.lang.String getCreateDate() {
		return _document.getCreateDate();
	}

	/**
	* Sets the create date of this document.
	*
	* @param createDate the create date of this document
	*/
	@Override
	public void setCreateDate(java.lang.String createDate) {
		_document.setCreateDate(createDate);
	}

	/**
	* Returns the article ID of this document.
	*
	* @return the article ID of this document
	*/
	@Override
	public long getArticleId() {
		return _document.getArticleId();
	}

	/**
	* Sets the article ID of this document.
	*
	* @param articleId the article ID of this document
	*/
	@Override
	public void setArticleId(long articleId) {
		_document.setArticleId(articleId);
	}

	/**
	* Returns the version of this document.
	*
	* @return the version of this document
	*/
	@Override
	public double getVersion() {
		return _document.getVersion();
	}

	/**
	* Sets the version of this document.
	*
	* @param version the version of this document
	*/
	@Override
	public void setVersion(double version) {
		_document.setVersion(version);
	}

	/**
	* Returns the title of this document.
	*
	* @return the title of this document
	*/
	@Override
	public java.lang.String getTitle() {
		return _document.getTitle();
	}

	/**
	* Sets the title of this document.
	*
	* @param title the title of this document
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_document.setTitle(title);
	}

	/**
	* Returns the content of this document.
	*
	* @return the content of this document
	*/
	@Override
	public java.lang.String getContent() {
		return _document.getContent();
	}

	/**
	* Sets the content of this document.
	*
	* @param content the content of this document
	*/
	@Override
	public void setContent(java.lang.String content) {
		_document.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _document.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_document.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _document.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_document.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _document.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _document.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_document.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _document.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_document.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_document.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_document.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentWrapper((Document)_document.clone());
	}

	@Override
	public int compareTo(com.lenovo.bp.search.portlet.model.Document document) {
		return _document.compareTo(document);
	}

	@Override
	public int hashCode() {
		return _document.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lenovo.bp.search.portlet.model.Document> toCacheModel() {
		return _document.toCacheModel();
	}

	@Override
	public com.lenovo.bp.search.portlet.model.Document toEscapedModel() {
		return new DocumentWrapper(_document.toEscapedModel());
	}

	@Override
	public com.lenovo.bp.search.portlet.model.Document toUnescapedModel() {
		return new DocumentWrapper(_document.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _document.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _document.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentWrapper)) {
			return false;
		}

		DocumentWrapper documentWrapper = (DocumentWrapper)obj;

		if (Validator.equals(_document, documentWrapper._document)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Document getWrappedDocument() {
		return _document;
	}

	@Override
	public Document getWrappedModel() {
		return _document;
	}

	@Override
	public void resetOriginalValues() {
		_document.resetOriginalValues();
	}

	private Document _document;
}