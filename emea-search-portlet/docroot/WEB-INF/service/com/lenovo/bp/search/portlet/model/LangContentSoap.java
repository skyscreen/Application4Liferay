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
public class LangContentSoap implements Serializable {
	public static LangContentSoap toSoapModel(LangContent model) {
		LangContentSoap soapModel = new LangContentSoap();

		soapModel.setLocals(model.getLocals());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static LangContentSoap[] toSoapModels(LangContent[] models) {
		LangContentSoap[] soapModels = new LangContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LangContentSoap[][] toSoapModels(LangContent[][] models) {
		LangContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LangContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LangContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LangContentSoap[] toSoapModels(List<LangContent> models) {
		List<LangContentSoap> soapModels = new ArrayList<LangContentSoap>(models.size());

		for (LangContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LangContentSoap[soapModels.size()]);
	}

	public LangContentSoap() {
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

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _locals;
	private String _content;
}