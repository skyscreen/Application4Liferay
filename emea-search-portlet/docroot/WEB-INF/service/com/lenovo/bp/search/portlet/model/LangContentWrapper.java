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
 * This class is a wrapper for {@link LangContent}.
 * </p>
 *
 * @author siyan
 * @see LangContent
 * @generated
 */
public class LangContentWrapper implements LangContent,
	ModelWrapper<LangContent> {
	public LangContentWrapper(LangContent langContent) {
		_langContent = langContent;
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

	/**
	* Returns the primary key of this lang content.
	*
	* @return the primary key of this lang content
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _langContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lang content.
	*
	* @param primaryKey the primary key of this lang content
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_langContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the locals of this lang content.
	*
	* @return the locals of this lang content
	*/
	@Override
	public java.lang.String getLocals() {
		return _langContent.getLocals();
	}

	/**
	* Sets the locals of this lang content.
	*
	* @param locals the locals of this lang content
	*/
	@Override
	public void setLocals(java.lang.String locals) {
		_langContent.setLocals(locals);
	}

	/**
	* Returns the content of this lang content.
	*
	* @return the content of this lang content
	*/
	@Override
	public java.lang.String getContent() {
		return _langContent.getContent();
	}

	/**
	* Sets the content of this lang content.
	*
	* @param content the content of this lang content
	*/
	@Override
	public void setContent(java.lang.String content) {
		_langContent.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _langContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_langContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _langContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_langContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _langContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _langContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_langContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _langContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_langContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_langContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_langContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LangContentWrapper((LangContent)_langContent.clone());
	}

	@Override
	public int compareTo(
		com.lenovo.bp.search.portlet.model.LangContent langContent) {
		return _langContent.compareTo(langContent);
	}

	@Override
	public int hashCode() {
		return _langContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lenovo.bp.search.portlet.model.LangContent> toCacheModel() {
		return _langContent.toCacheModel();
	}

	@Override
	public com.lenovo.bp.search.portlet.model.LangContent toEscapedModel() {
		return new LangContentWrapper(_langContent.toEscapedModel());
	}

	@Override
	public com.lenovo.bp.search.portlet.model.LangContent toUnescapedModel() {
		return new LangContentWrapper(_langContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _langContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _langContent.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LangContentWrapper)) {
			return false;
		}

		LangContentWrapper langContentWrapper = (LangContentWrapper)obj;

		if (Validator.equals(_langContent, langContentWrapper._langContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LangContent getWrappedLangContent() {
		return _langContent;
	}

	@Override
	public LangContent getWrappedModel() {
		return _langContent;
	}

	@Override
	public void resetOriginalValues() {
		_langContent.resetOriginalValues();
	}

	private LangContent _langContent;
}