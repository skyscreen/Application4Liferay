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

import com.lenovo.bp.search.portlet.model.Document;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author siyan
 * @see Document
 * @generated
 */
public class DocumentCacheModel implements CacheModel<Document>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

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
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setId_(id_);

		if (createDate == null) {
			documentImpl.setCreateDate(StringPool.BLANK);
		}
		else {
			documentImpl.setCreateDate(createDate);
		}

		documentImpl.setArticleId(articleId);
		documentImpl.setVersion(version);

		if (title == null) {
			documentImpl.setTitle(StringPool.BLANK);
		}
		else {
			documentImpl.setTitle(title);
		}

		if (content == null) {
			documentImpl.setContent(StringPool.BLANK);
		}
		else {
			documentImpl.setContent(content);
		}

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		createDate = objectInput.readUTF();
		articleId = objectInput.readLong();
		version = objectInput.readDouble();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long id_;
	public String createDate;
	public long articleId;
	public double version;
	public String title;
	public String content;
}