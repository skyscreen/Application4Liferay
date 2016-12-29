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
 * This class is a wrapper for {@link LangTitle}.
 * </p>
 *
 * @author siyan
 * @see LangTitle
 * @generated
 */
public class LangTitleWrapper implements LangTitle, ModelWrapper<LangTitle> {
	public LangTitleWrapper(LangTitle langTitle) {
		_langTitle = langTitle;
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

	/**
	* Returns the primary key of this lang title.
	*
	* @return the primary key of this lang title
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _langTitle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this lang title.
	*
	* @param primaryKey the primary key of this lang title
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_langTitle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the locals of this lang title.
	*
	* @return the locals of this lang title
	*/
	@Override
	public java.lang.String getLocals() {
		return _langTitle.getLocals();
	}

	/**
	* Sets the locals of this lang title.
	*
	* @param locals the locals of this lang title
	*/
	@Override
	public void setLocals(java.lang.String locals) {
		_langTitle.setLocals(locals);
	}

	/**
	* Returns the title of this lang title.
	*
	* @return the title of this lang title
	*/
	@Override
	public java.lang.String getTitle() {
		return _langTitle.getTitle();
	}

	/**
	* Sets the title of this lang title.
	*
	* @param title the title of this lang title
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_langTitle.setTitle(title);
	}

	@Override
	public boolean isNew() {
		return _langTitle.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_langTitle.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _langTitle.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_langTitle.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _langTitle.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _langTitle.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_langTitle.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _langTitle.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_langTitle.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_langTitle.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_langTitle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LangTitleWrapper((LangTitle)_langTitle.clone());
	}

	@Override
	public int compareTo(com.lenovo.bp.search.portlet.model.LangTitle langTitle) {
		return _langTitle.compareTo(langTitle);
	}

	@Override
	public int hashCode() {
		return _langTitle.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lenovo.bp.search.portlet.model.LangTitle> toCacheModel() {
		return _langTitle.toCacheModel();
	}

	@Override
	public com.lenovo.bp.search.portlet.model.LangTitle toEscapedModel() {
		return new LangTitleWrapper(_langTitle.toEscapedModel());
	}

	@Override
	public com.lenovo.bp.search.portlet.model.LangTitle toUnescapedModel() {
		return new LangTitleWrapper(_langTitle.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _langTitle.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _langTitle.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LangTitleWrapper)) {
			return false;
		}

		LangTitleWrapper langTitleWrapper = (LangTitleWrapper)obj;

		if (Validator.equals(_langTitle, langTitleWrapper._langTitle)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LangTitle getWrappedLangTitle() {
		return _langTitle;
	}

	@Override
	public LangTitle getWrappedModel() {
		return _langTitle;
	}

	@Override
	public void resetOriginalValues() {
		_langTitle.resetOriginalValues();
	}

	private LangTitle _langTitle;
}