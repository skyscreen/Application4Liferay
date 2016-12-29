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

import com.lenovo.bp.search.portlet.model.Search;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the search service. This utility wraps {@link SearchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see SearchPersistence
 * @see SearchPersistenceImpl
 * @generated
 */
public class SearchUtil {
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
	public static void clearCache(Search search) {
		getPersistence().clearCache(search);
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
	public static List<Search> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Search> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Search> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Search update(Search search) throws SystemException {
		return getPersistence().update(search);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Search update(Search search, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(search, serviceContext);
	}

	/**
	* Returns all the searchs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findBycollectAddAndModifyDocId(
			String structureId, String startDateTime, String endDateTime) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycollectAddAndModifyDocId(structureId,startDateTime,endDateTime);
	}

	/**
	* Returns a range of all the searchs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.SearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of searchs
	* @param end the upper bound of the range of searchs (not inclusive)
	* @return the range of matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findBycollectAddAndModifyDocId(
			String structureId, String startDateTime, String endDateTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectAddAndModifyDocId(structureId,startDateTime, endDateTime, start, end);
	}

	/**
	* Returns an ordered range of all the searchs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.SearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of searchs
	* @param end the upper bound of the range of searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findBycollectAddAndModifyDocId(
			String structureId, String startDateTime, String endDateTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectAddAndModifyDocId(structureId,startDateTime,endDateTime, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search findBycollectAddAndModifyDocId_First(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectAddAndModifyDocId_First(structureId,startDateTime,endDateTime,
			orderByComparator);
	}

	/**
	* Returns the first search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search, or <code>null</code> if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search fetchBycollectAddAndModifyDocId_First(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycollectAddAndModifyDocId_First(structureId,startDateTime,endDateTime,
			orderByComparator);
	}

	/**
	* Returns the last search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search findBycollectAddAndModifyDocId_Last(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectAddAndModifyDocId_Last(structureId,startDateTime,endDateTime,
			orderByComparator);
	}

	/**
	* Returns the last search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search, or <code>null</code> if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search fetchBycollectAddAndModifyDocId_Last(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycollectAddAndModifyDocId_Last(structureId,startDateTime,endDateTime,
			orderByComparator);
	}

	/**
	* Returns the searchs before and after the current search in the ordered set where userId = &#63;.
	*
	* @param id the primary key of the current search
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a search with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search[] findBycollectAddAndModifyDocId_PrevAndNext(
		long id, String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectAddAndModifyDocId_PrevAndNext(id, structureId,startDateTime,endDateTime,
			orderByComparator);
	}

	/**
	* Removes all the searchs where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycollectAddAndModifyDocId(String structureId, String startDateTime, String endDateTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycollectAddAndModifyDocId(structureId,startDateTime,endDateTime);
	}

	/**
	* Returns the number of searchs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycollectAddAndModifyDocId(String structureId, String startDateTime, String endDateTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycollectAddAndModifyDocId(structureId,startDateTime,endDateTime);
	}

	/**
	* Returns all the searchs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findBycollectDeletedDocId(
			String structureId, String startDateTime, String endDateTime) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycollectDeletedDocId(structureId,startDateTime,endDateTime);
	}

	/**
	* Returns a range of all the searchs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.SearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of searchs
	* @param end the upper bound of the range of searchs (not inclusive)
	* @return the range of matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findBycollectDeletedDocId(
			String structureId, String startDateTime, String endDateTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycollectDeletedDocId(structureId,startDateTime,endDateTime, start, end);
	}

	/**
	* Returns an ordered range of all the searchs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.SearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of searchs
	* @param end the upper bound of the range of searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findBycollectDeletedDocId(
			String structureId, String startDateTime, String endDateTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectDeletedDocId(structureId,startDateTime,endDateTime, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search findBycollectDeletedDocId_First(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectDeletedDocId_First(structureId,startDateTime,endDateTime, orderByComparator);
	}

	/**
	* Returns the first search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search, or <code>null</code> if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search fetchBycollectDeletedDocId_First(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycollectDeletedDocId_First(structureId,startDateTime,endDateTime, orderByComparator);
	}

	/**
	* Returns the last search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search findBycollectDeletedDocId_Last(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectDeletedDocId_Last(structureId,startDateTime,endDateTime, orderByComparator);
	}

	/**
	* Returns the last search in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search, or <code>null</code> if a matching search could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search fetchBycollectDeletedDocId_Last(
			String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycollectDeletedDocId_Last(structureId,startDateTime,endDateTime, orderByComparator);
	}

	/**
	* Returns the searchs before and after the current search in the ordered set where userId = &#63;.
	*
	* @param id the primary key of the current search
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a search with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search[] findBycollectDeletedDocId_PrevAndNext(
		long id, String structureId, String startDateTime, String endDateTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycollectDeletedDocId_PrevAndNext(id, structureId,startDateTime,endDateTime,
			orderByComparator);
	}

	/**
	* Removes all the searchs where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycollectDeletedDocId(String structureId, String startDateTime, String endDateTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycollectDeletedDocId(structureId,startDateTime,endDateTime);
	}

	/**
	* Returns the number of searchs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching searchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycollectDeletedDocId(String structureId, String startDateTime, String endDateTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycollectDeletedDocId(structureId,startDateTime,endDateTime);
	}

	/**
	* Caches the search in the entity cache if it is enabled.
	*
	* @param search the search
	*/
	public static void cacheResult(
		com.lenovo.bp.search.portlet.model.Search search) {
		getPersistence().cacheResult(search);
	}

	/**
	* Caches the searchs in the entity cache if it is enabled.
	*
	* @param searchs the searchs
	*/
	public static void cacheResult(
		java.util.List<com.lenovo.bp.search.portlet.model.Search> searchs) {
		getPersistence().cacheResult(searchs);
	}

	/**
	* Creates a new search with the primary key. Does not add the search to the database.
	*
	* @param id the primary key for the new search
	* @return the new search
	*/
	public static com.lenovo.bp.search.portlet.model.Search create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the search with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the search
	* @return the search that was removed
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a search with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search remove(long id)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.lenovo.bp.search.portlet.model.Search updateImpl(
		com.lenovo.bp.search.portlet.model.Search search)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(search);
	}

	/**
	* Returns the search with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchSearchException} if it could not be found.
	*
	* @param id the primary key of the search
	* @return the search
	* @throws com.lenovo.bp.search.portlet.NoSuchSearchException if a search with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search findByPrimaryKey(
		long id)
		throws com.lenovo.bp.search.portlet.NoSuchSearchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the search with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the search
	* @return the search, or <code>null</code> if a search with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.Search fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the searchs.
	*
	* @return the searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the searchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.SearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of searchs
	* @param end the upper bound of the range of searchs (not inclusive)
	* @return the range of searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the searchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.SearchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of searchs
	* @param end the upper bound of the range of searchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of searchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.Search> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the searchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of searchs.
	*
	* @return the number of searchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SearchPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SearchPersistence)PortletBeanLocatorUtil.locate(com.lenovo.bp.search.portlet.service.ClpSerializer.getServletContextName(),
					SearchPersistence.class.getName());

			ReferenceRegistry.registerReference(SearchUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SearchPersistence persistence) {
	}

	private static SearchPersistence _persistence;
}