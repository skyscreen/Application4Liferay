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

import com.lenovo.bp.search.portlet.model.Role;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Role in entity cache.
 *
 * @author siyan
 * @see Role
 * @generated
 */
public class RoleCacheModel implements CacheModel<Role>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{roleId=");
		sb.append(roleId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Role toEntityModel() {
		RoleImpl roleImpl = new RoleImpl();

		roleImpl.setRoleId(roleId);

		if (name == null) {
			roleImpl.setName(StringPool.BLANK);
		}
		else {
			roleImpl.setName(name);
		}

		roleImpl.setUserId(userId);

		if (screenName == null) {
			roleImpl.setScreenName(StringPool.BLANK);
		}
		else {
			roleImpl.setScreenName(screenName);
		}

		roleImpl.resetOriginalValues();

		return roleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roleId = objectInput.readLong();
		name = objectInput.readUTF();
		userId = objectInput.readLong();
		screenName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(roleId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(userId);

		if (screenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenName);
		}
	}

	public long roleId;
	public String name;
	public long userId;
	public String screenName;
}