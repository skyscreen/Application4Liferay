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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Search}.
 * </p>
 *
 * @author siyan
 * @see Search
 * @generated
 */
public class SearchWrapper implements Search, ModelWrapper<Search> {
	public SearchWrapper(Search search) {
		_search = search;
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

	/**
	* Returns the primary key of this search.
	*
	* @return the primary key of this search
	*/
	@Override
	public long getPrimaryKey() {
		return _search.getPrimaryKey();
	}

	/**
	* Sets the primary key of this search.
	*
	* @param primaryKey the primary key of this search
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_search.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this search.
	*
	* @return the ID of this search
	*/
	@Override
	public long getId() {
		return _search.getId();
	}

	/**
	* Sets the ID of this search.
	*
	* @param id the ID of this search
	*/
	@Override
	public void setId(long id) {
		_search.setId(id);
	}

	/**
	* Returns the journalarticl_id of this search.
	*
	* @return the journalarticl_id of this search
	*/
	@Override
	public long getJournalarticl_id() {
		return _search.getJournalarticl_id();
	}

	/**
	* Sets the journalarticl_id of this search.
	*
	* @param journalarticl_id the journalarticl_id of this search
	*/
	@Override
	public void setJournalarticl_id(long journalarticl_id) {
		_search.setJournalarticl_id(journalarticl_id);
	}

	/**
	* Returns the operat_type of this search.
	*
	* @return the operat_type of this search
	*/
	@Override
	public long getOperat_type() {
		return _search.getOperat_type();
	}

	/**
	* Sets the operat_type of this search.
	*
	* @param operat_type the operat_type of this search
	*/
	@Override
	public void setOperat_type(long operat_type) {
		_search.setOperat_type(operat_type);
	}

	/**
	* Returns the operat_time of this search.
	*
	* @return the operat_time of this search
	*/
	@Override
	public java.util.Date getOperat_time() {
		return _search.getOperat_time();
	}

	/**
	* Sets the operat_time of this search.
	*
	* @param operat_time the operat_time of this search
	*/
	@Override
	public void setOperat_time(java.util.Date operat_time) {
		_search.setOperat_time(operat_time);
	}

	/**
	* Returns the user ID of this search.
	*
	* @return the user ID of this search
	*/
	@Override
	public long getUserId() {
		return _search.getUserId();
	}

	/**
	* Sets the user ID of this search.
	*
	* @param userId the user ID of this search
	*/
	@Override
	public void setUserId(long userId) {
		_search.setUserId(userId);
	}

	/**
	* Returns the user uuid of this search.
	*
	* @return the user uuid of this search
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _search.getUserUuid();
	}

	/**
	* Sets the user uuid of this search.
	*
	* @param userUuid the user uuid of this search
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_search.setUserUuid(userUuid);
	}

	/**
	* Returns the structure ID of this search.
	*
	* @return the structure ID of this search
	*/
	@Override
	public java.lang.String getStructureId() {
		return _search.getStructureId();
	}

	/**
	* Sets the structure ID of this search.
	*
	* @param structureId the structure ID of this search
	*/
	@Override
	public void setStructureId(java.lang.String structureId) {
		_search.setStructureId(structureId);
	}

	@Override
	public boolean isNew() {
		return _search.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_search.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _search.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_search.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _search.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _search.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_search.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _search.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_search.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_search.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_search.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SearchWrapper((Search)_search.clone());
	}

	@Override
	public int compareTo(com.lenovo.bp.search.portlet.model.Search search) {
		return _search.compareTo(search);
	}

	@Override
	public int hashCode() {
		return _search.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lenovo.bp.search.portlet.model.Search> toCacheModel() {
		return _search.toCacheModel();
	}

	@Override
	public com.lenovo.bp.search.portlet.model.Search toEscapedModel() {
		return new SearchWrapper(_search.toEscapedModel());
	}

	@Override
	public com.lenovo.bp.search.portlet.model.Search toUnescapedModel() {
		return new SearchWrapper(_search.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _search.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _search.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_search.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchWrapper)) {
			return false;
		}

		SearchWrapper searchWrapper = (SearchWrapper)obj;

		if (Validator.equals(_search, searchWrapper._search)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Search getWrappedSearch() {
		return _search;
	}

	@Override
	public Search getWrappedModel() {
		return _search;
	}

	@Override
	public void resetOriginalValues() {
		_search.resetOriginalValues();
	}

	private Search _search;
}