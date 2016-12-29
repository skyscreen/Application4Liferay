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

import com.lenovo.bp.search.portlet.model.Search;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Search in entity cache.
 *
 * @author siyan
 * @see Search
 * @generated
 */
public class SearchCacheModel implements CacheModel<Search>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", journalarticl_id=");
		sb.append(journalarticl_id);
		sb.append(", operat_type=");
		sb.append(operat_type);
		sb.append(", operat_time=");
		sb.append(operat_time);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Search toEntityModel() {
		SearchImpl searchImpl = new SearchImpl();

		searchImpl.setId(id);
		searchImpl.setJournalarticl_id(journalarticl_id);
		searchImpl.setOperat_type(operat_type);

		if (operat_time == Long.MIN_VALUE) {
			searchImpl.setOperat_time(null);
		}
		else {
			searchImpl.setOperat_time(new Date(operat_time));
		}

		searchImpl.setUserId(userId);

		if (structureId == null) {
			searchImpl.setStructureId(StringPool.BLANK);
		}
		else {
			searchImpl.setStructureId(structureId);
		}

		searchImpl.resetOriginalValues();

		return searchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		journalarticl_id = objectInput.readLong();
		operat_type = objectInput.readLong();
		operat_time = objectInput.readLong();
		userId = objectInput.readLong();
		structureId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(journalarticl_id);
		objectOutput.writeLong(operat_type);
		objectOutput.writeLong(operat_time);
		objectOutput.writeLong(userId);

		if (structureId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(structureId);
		}
	}

	public long id;
	public long journalarticl_id;
	public long operat_type;
	public long operat_time;
	public long userId;
	public String structureId;
}