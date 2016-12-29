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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

import com.lenovo.bp.search.portlet.model.ExtDocument;
import com.lenovo.bp.search.portlet.model.LangTitle;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

/**
 * The cache model class for representing ExtDocument in entity cache.
 *
 * @author siyan
 * @see ExtDocument
 * @generated
 */
public class ExtDocumentCacheModel implements CacheModel<ExtDocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_=");
		sb.append(id_);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExtDocument toEntityModel() {
		ExtDocumentImpl extDocumentImpl = new ExtDocumentImpl();

		extDocumentImpl.setId_(id_);

		if (createDate == null) {
			extDocumentImpl.setCreateDate(StringPool.BLANK);
		}
		else {
			extDocumentImpl.setCreateDate(createDate);
		}

		extDocumentImpl.setArticleId(articleId);
		extDocumentImpl.setVersion(version);
		extDocumentImpl.setListLangTitle(title);

		extDocumentImpl.resetOriginalValues();

		return extDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		createDate = objectInput.readUTF();
		articleId = objectInput.readLong();
		version = objectInput.readDouble();
//		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_);

		if (createDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createDate);
		}

		objectOutput.writeLong(articleId);
		objectOutput.writeDouble(version);
	}

	public long id_;
	public String createDate;
	public long articleId;
	public double version;
	public List<LangTitleImpl> title;
}