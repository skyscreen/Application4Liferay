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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lenovo.bp.search.portlet.service.http.SearchServiceSoap}.
 *
 * @author siyan
 * @see com.lenovo.bp.search.portlet.service.http.SearchServiceSoap
 * @generated
 */
public class SearchSoap implements Serializable {
	public static SearchSoap toSoapModel(Search model) {
		SearchSoap soapModel = new SearchSoap();

		soapModel.setId(model.getId());
		soapModel.setJournalarticl_id(model.getJournalarticl_id());
		soapModel.setOperat_type(model.getOperat_type());
		soapModel.setOperat_time(model.getOperat_time());
		soapModel.setUserId(model.getUserId());
		soapModel.setStructureId(model.getStructureId());

		return soapModel;
	}

	public static SearchSoap[] toSoapModels(Search[] models) {
		SearchSoap[] soapModels = new SearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SearchSoap[][] toSoapModels(Search[][] models) {
		SearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SearchSoap[] toSoapModels(List<Search> models) {
		List<SearchSoap> soapModels = new ArrayList<SearchSoap>(models.size());

		for (Search model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SearchSoap[soapModels.size()]);
	}

	public SearchSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getJournalarticl_id() {
		return _journalarticl_id;
	}

	public void setJournalarticl_id(long journalarticl_id) {
		_journalarticl_id = journalarticl_id;
	}

	public long getOperat_type() {
		return _operat_type;
	}

	public void setOperat_type(long operat_type) {
		_operat_type = operat_type;
	}

	public Date getOperat_time() {
		return _operat_time;
	}

	public void setOperat_time(Date operat_time) {
		_operat_time = operat_time;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getStructureId() {
		return _structureId;
	}

	public void setStructureId(String structureId) {
		_structureId = structureId;
	}

	private long _id;
	private long _journalarticl_id;
	private long _operat_type;
	private Date _operat_time;
	private long _userId;
	private String _structureId;
}