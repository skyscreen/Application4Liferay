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

package com.lenovo.bp.search.portlet.service.persistence;

import com.lenovo.bp.search.portlet.RoleUtil;
import com.lenovo.bp.search.portlet.model.Role;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see RolePersistenceImpl
 * @see RoleUtil
 * @generated
 */
public interface RolePersistence extends BasePersistence<Role> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoleUtil} to access the role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the role in the entity cache if it is enabled.
	*
	* @param role the role
	*/
	public void cacheResult(com.lenovo.bp.search.portlet.model.Role role);

	/**
	* Caches the roles in the entity cache if it is enabled.
	*
	* @param roles the roles
	*/
	public void cacheResult(
		java.util.List<com.lenovo.bp.search.portlet.model.Role> roles);

	/**
	* Creates a new role with the primary key. Does not add the role to the database.
	*
	* @param rolePK the primary key for the new role
	* @return the new role
	*/
	public com.lenovo.bp.search.portlet.model.Role create(RolePK rolePK);

	/**
	* Removes the role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rolePK the primary key of the role
	* @return the role that was removed
	* @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lenovo.bp.search.portlet.model.Role remove(RolePK rolePK)
		throws com.lenovo.bp.search.portlet.NoSuchRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lenovo.bp.search.portlet.model.Role updateImpl(
		com.lenovo.bp.search.portlet.model.Role role)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchRoleException} if it could not be found.
	*
	* @param rolePK the primary key of the role
	* @return the role
	* @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lenovo.bp.search.portlet.model.Role findByPrimaryKey(
		RolePK rolePK)
		throws com.lenovo.bp.search.portlet.NoSuchRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rolePK the primary key of the role
	* @return the role, or <code>null</code> if a role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lenovo.bp.search.portlet.model.Role fetchByPrimaryKey(
		RolePK rolePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the roles.
	*
	* @return the roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lenovo.bp.search.portlet.model.Role> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.RoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of roles
	* @param end the upper bound of the range of roles (not inclusive)
	* @return the range of roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lenovo.bp.search.portlet.model.Role> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.RoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of roles
	* @param end the upper bound of the range of roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lenovo.bp.search.portlet.model.Role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of roles.
	*
	* @return the number of roles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}