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

import com.lenovo.bp.search.portlet.model.LangTitle;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the lang title service. This utility wraps {@link LangTitlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see LangTitlePersistence
 * @see LangTitlePersistenceImpl
 * @generated
 */
public class LangTitleUtil {
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
	public static void clearCache(LangTitle langTitle) {
		getPersistence().clearCache(langTitle);
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
	public static List<LangTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LangTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LangTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LangTitle update(LangTitle langTitle)
		throws SystemException {
		return getPersistence().update(langTitle);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LangTitle update(LangTitle langTitle,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(langTitle, serviceContext);
	}

	/**
	* Caches the lang title in the entity cache if it is enabled.
	*
	* @param langTitle the lang title
	*/
	public static void cacheResult(
		com.lenovo.bp.search.portlet.model.LangTitle langTitle) {
		getPersistence().cacheResult(langTitle);
	}

	/**
	* Caches the lang titles in the entity cache if it is enabled.
	*
	* @param langTitles the lang titles
	*/
	public static void cacheResult(
		java.util.List<com.lenovo.bp.search.portlet.model.LangTitle> langTitles) {
		getPersistence().cacheResult(langTitles);
	}

	/**
	* Creates a new lang title with the primary key. Does not add the lang title to the database.
	*
	* @param locals the primary key for the new lang title
	* @return the new lang title
	*/
	public static com.lenovo.bp.search.portlet.model.LangTitle create(
		java.lang.String locals) {
		return getPersistence().create(locals);
	}

	/**
	* Removes the lang title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locals the primary key of the lang title
	* @return the lang title that was removed
	* @throws com.lenovo.bp.search.portlet.NoSuchLangTitleException if a lang title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.LangTitle remove(
		java.lang.String locals)
		throws com.lenovo.bp.search.portlet.NoSuchLangTitleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(locals);
	}

	public static com.lenovo.bp.search.portlet.model.LangTitle updateImpl(
		com.lenovo.bp.search.portlet.model.LangTitle langTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(langTitle);
	}

	/**
	* Returns the lang title with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchLangTitleException} if it could not be found.
	*
	* @param locals the primary key of the lang title
	* @return the lang title
	* @throws com.lenovo.bp.search.portlet.NoSuchLangTitleException if a lang title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.LangTitle findByPrimaryKey(
		java.lang.String locals)
		throws com.lenovo.bp.search.portlet.NoSuchLangTitleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(locals);
	}

	/**
	* Returns the lang title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locals the primary key of the lang title
	* @return the lang title, or <code>null</code> if a lang title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.LangTitle fetchByPrimaryKey(
		java.lang.String locals)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(locals);
	}

	/**
	* Returns all the lang titles.
	*
	* @return the lang titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.LangTitle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lang titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.LangTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lang titles
	* @param end the upper bound of the range of lang titles (not inclusive)
	* @return the range of lang titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.LangTitle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lang titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.LangTitleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lang titles
	* @param end the upper bound of the range of lang titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lang titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.LangTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lang titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lang titles.
	*
	* @return the number of lang titles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LangTitlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LangTitlePersistence)PortletBeanLocatorUtil.locate(com.lenovo.bp.search.portlet.service.ClpSerializer.getServletContextName(),
					LangTitlePersistence.class.getName());

			ReferenceRegistry.registerReference(LangTitleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LangTitlePersistence persistence) {
	}

	private static LangTitlePersistence _persistence;
}