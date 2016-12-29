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

package com.lenovo.bp.search.portlet;

import com.lenovo.bp.search.portlet.model.Role;
import com.lenovo.bp.search.portlet.service.persistence.RolePK;
import com.lenovo.bp.search.portlet.service.persistence.RolePersistence;
import com.lenovo.bp.search.portlet.service.persistence.RolePersistenceImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the role service. This utility wraps {@link RolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see RolePersistence
 * @see RolePersistenceImpl
 * @generated
 */
public class RoleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Role role) {
		getPersistence().clearCache(role);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Role> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Role> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Role> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Role update(Role role) throws SystemException {
		return getPersistence().update(role);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Role update(Role role, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(role, serviceContext);
	}

	/**
	* Caches the role in the entity cache if it is enabled.
	*
	* @param role the role
	*/
	public static void cacheResult(com.lenovo.bp.search.portlet.model.Role role) {
		getPersistence().cacheResult(role);
	}

	/**
	* Caches the roles in the entity cache if it is enabled.
	*
	* @param roles the roles
	*/
	public static void cacheResult(
		java.util.List<com.lenovo.bp.search.portlet.model.Role> roles) {
		getPersistence().cacheResult(roles);
	}

	/**
	* Creates a new role with the primary key. Does not add the role to the database.
	*
	* @param rolePK the primary key for the new role
	* @return the new role
	*/
	public static com.lenovo.bp.search.portlet.model.Role create(RolePK rolePK) {
		return getPersistence().create(rolePK);
	}

	/**
	* Removes the role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rolePK the primary key of the role
	* @return the role that was removed
	* @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Role remove(RolePK rolePK)
		throws com.lenovo.bp.search.portlet.NoSuchRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(rolePK);
	}

	public static com.lenovo.bp.search.portlet.model.Role updateImpl(
		com.lenovo.bp.search.portlet.model.Role role)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(role);
	}

	/**
	* Returns the role with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchRoleException} if it could not be found.
	*
	* @param rolePK the primary key of the role
	* @return the role
	* @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Role findByPrimaryKey(
		RolePK rolePK)
		throws com.lenovo.bp.search.portlet.NoSuchRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(rolePK);
	}

	/**
	* Returns the role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rolePK the primary key of the role
	* @return the role, or <code>null</code> if a role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Role fetchByPrimaryKey(
		RolePK rolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rolePK);
	}

	/**
	* Returns all the roles.
	*
	* @return the roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Role> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.lenovo.bp.search.portlet.model.Role> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.lenovo.bp.search.portlet.model.Role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of roles.
	*
	* @return the number of roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RolePersistence)PortletBeanLocatorUtil.locate(com.lenovo.bp.search.portlet.service.ClpSerializer.getServletContextName(),
					RolePersistence.class.getName());

			ReferenceRegistry.registerReference(RoleUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RolePersistence persistence) {
	}

	private static RolePersistence _persistence;
}