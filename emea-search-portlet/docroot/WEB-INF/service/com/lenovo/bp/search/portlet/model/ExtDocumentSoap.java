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
import java.util.List;

import com.lenovo.bp.search.portlet.model.impl.LangTitleImpl;

/**
 * This class is used by SOAP remote services.
 *
 * @author siyan
 * @generated
 */
public class ExtDocumentSoap implements Serializable {
	public static ExtDocumentSoap toSoapModel(ExtDocument model) {
		ExtDocumentSoap soapModel = new ExtDocumentSoap();

		soapModel.setId_(model.getId_());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setVersion(model.getVersion());
		soapModel.setListLangTitle(model.getListLangTitle());

		return soapModel;
	}

	public static ExtDocumentSoap[] toSoapModels(ExtDocument[] models) {
		ExtDocumentSoap[] soapModels = new ExtDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExtDocumentSoap[][] toSoapModels(ExtDocument[][] models) {
		ExtDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExtDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExtDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExtDocumentSoap[] toSoapModels(List<ExtDocument> models) {
		List<ExtDocumentSoap> soapModels = new ArrayList<ExtDocumentSoap>(models.size());

		for (ExtDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExtDocumentSoap[soapModels.size()]);
	}

	public ExtDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _id_;
	}

	public void setPrimaryKey(long pk) {
		setId_(pk);
	}

	public long getId_() {
		return _id_;
	}

	public void setId_(long id_) {
		_id_ = id_;
	}

	public String getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(String createDate) {
		_createDate = createDate;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		_version = version;
	}
	
	
	public List<LangTitleImpl> getListLangTitle() {
		return _listLangTitle;
	}

	
	public void setListLangTitle(List<LangTitleImpl> listLangTitle) {
		_listLangTitle = listLangTitle;
	}		

	private long _id_;
	private String _createDate;
	private long _articleId;
	private double _version;
	private List<LangTitleImpl> _listLangTitle;
}