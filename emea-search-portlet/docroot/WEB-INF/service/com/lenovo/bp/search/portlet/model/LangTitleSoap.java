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

/**
 * This class is used by SOAP remote services.
 *
 * @author siyan
 * @generated
 */
public class LangTitleSoap implements Serializable {
	public static LangTitleSoap toSoapModel(LangTitle model) {
		LangTitleSoap soapModel = new LangTitleSoap();

		soapModel.setLocals(model.getLocals());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static LangTitleSoap[] toSoapModels(LangTitle[] models) {
		LangTitleSoap[] soapModels = new LangTitleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LangTitleSoap[][] toSoapModels(LangTitle[][] models) {
		LangTitleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LangTitleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LangTitleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LangTitleSoap[] toSoapModels(List<LangTitle> models) {
		List<LangTitleSoap> soapModels = new ArrayList<LangTitleSoap>(models.size());

		for (LangTitle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LangTitleSoap[soapModels.size()]);
	}

	public LangTitleSoap() {
	}

	public String getPrimaryKey() {
		return _locals;
	}

	public void setPrimaryKey(String pk) {
		setLocals(pk);
	}

	public String getLocals() {
		return _locals;
	}

	public void setLocals(String locals) {
		_locals = locals;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _locals;
	private String _title;
}