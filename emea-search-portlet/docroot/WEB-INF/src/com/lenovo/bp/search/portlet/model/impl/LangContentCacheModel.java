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

import com.lenovo.bp.search.portlet.model.LangContent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LangContent in entity cache.
 *
 * @author siyan
 * @see LangContent
 * @generated
 */
public class LangContentCacheModel implements CacheModel<LangContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{locals=");
		sb.append(locals);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LangContent toEntityModel() {
		LangContentImpl langContentImpl = new LangContentImpl();

		if (locals == null) {
			langContentImpl.setLocals(StringPool.BLANK);
		}
		else {
			langContentImpl.setLocals(locals);
		}

		if (content == null) {
			langContentImpl.setContent(StringPool.BLANK);
		}
		else {
			langContentImpl.setContent(content);
		}

		langContentImpl.resetOriginalValues();

		return langContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locals = objectInput.readUTF();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (locals == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locals);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public String locals;
	public String content;
}