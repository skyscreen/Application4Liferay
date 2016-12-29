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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lenovo.bp.search.portlet.model.impl.LangContentImpl;
import com.lenovo.bp.search.portlet.model.impl.LangTitleImpl;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExtDocument}.
 * </p>
 *
 * @author siyan
 * @see ExtDocument
 * @generated
 */
public class ExtDocumentWrapper implements ExtDocument,
	ModelWrapper<ExtDocument> {
	public ExtDocumentWrapper(ExtDocument extDocument) {
		_extDocument = extDocument;
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

	/**
	* Returns the primary key of this ext document.
	*
	* @return the primary key of this ext document
	*/
	@Override
	public long getPrimaryKey() {
		return _extDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ext document.
	*
	* @param primaryKey the primary key of this ext document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_extDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_ of this ext document.
	*
	* @return the id_ of this ext document
	*/
	@Override
	public long getId_() {
		return _extDocument.getId_();
	}

	/**
	* Sets the id_ of this ext document.
	*
	* @param id_ the id_ of this ext document
	*/
	@Override
	public void setId_(long id_) {
		_extDocument.setId_(id_);
	}

	/**
	* Returns the create date of this ext document.
	*
	* @return the create date of this ext document
	*/
	@Override
	public java.lang.String getCreateDate() {
		return _extDocument.getCreateDate();
	}

	/**
	* Sets the create date of this ext document.
	*
	* @param createDate the create date of this ext document
	*/
	@Override
	public void setCreateDate(java.lang.String createDate) {
		_extDocument.setCreateDate(createDate);
	}

	/**
	* Returns the article ID of this ext document.
	*
	* @return the article ID of this ext document
	*/
	@Override
	public long getArticleId() {
		return _extDocument.getArticleId();
	}

	/**
	* Sets the article ID of this ext document.
	*
	* @param articleId the article ID of this ext document
	*/
	@Override
	public void setArticleId(long articleId) {
		_extDocument.setArticleId(articleId);
	}

	/**
	* Returns the version of this ext document.
	*
	* @return the version of this ext document
	*/
	@Override
	public double getVersion() {
		return _extDocument.getVersion();
	}

	/**
	* Sets the version of this ext document.
	*
	* @param version the version of this ext document
	*/
	@Override
	public void setVersion(double version) {
		_extDocument.setVersion(version);
	}
	
	@Override
	public List<LangTitleImpl> getListLangTitle() {
		return _extDocument.getListLangTitle();
	}	
	
	@Override
	public void setListLangTitle(List<LangTitleImpl> listLangTitle) {
		_extDocument.setListLangTitle(listLangTitle);
	}	
	
	@Override
	public List<LangContentImpl> getListLangContent() {
		return _extDocument.getListLangContent();
	}	
	
	@Override
	public void setListLangContent(List<LangContentImpl> listLangContent) {
		_extDocument.setListLangContent(listLangContent);
	}		
	
	
	@Override
	public java.lang.String getUrl() {
		return _extDocument.getUrl();
	}


	@Override
	public void setUrl(java.lang.String url) {
		_extDocument.setUrl(url);
	}	

	@Override
	public boolean isNew() {
		return _extDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_extDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _extDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_extDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _extDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _extDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_extDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _extDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_extDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_extDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_extDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExtDocumentWrapper((ExtDocument)_extDocument.clone());
	}

	@Override
	public int compareTo(
		com.lenovo.bp.search.portlet.model.ExtDocument extDocument) {
		return _extDocument.compareTo(extDocument);
	}

	@Override
	public int hashCode() {
		return _extDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lenovo.bp.search.portlet.model.ExtDocument> toCacheModel() {
		return _extDocument.toCacheModel();
	}

	@Override
	public com.lenovo.bp.search.portlet.model.ExtDocument toEscapedModel() {
		return new ExtDocumentWrapper(_extDocument.toEscapedModel());
	}

	@Override
	public com.lenovo.bp.search.portlet.model.ExtDocument toUnescapedModel() {
		return new ExtDocumentWrapper(_extDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _extDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _extDocument.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtDocumentWrapper)) {
			return false;
		}

		ExtDocumentWrapper extDocumentWrapper = (ExtDocumentWrapper)obj;

		if (Validator.equals(_extDocument, extDocumentWrapper._extDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ExtDocument getWrappedExtDocument() {
		return _extDocument;
	}

	@Override
	public ExtDocument getWrappedModel() {
		return _extDocument;
	}

	@Override
	public void resetOriginalValues() {
		_extDocument.resetOriginalValues();
	}

	private ExtDocument _extDocument;
}