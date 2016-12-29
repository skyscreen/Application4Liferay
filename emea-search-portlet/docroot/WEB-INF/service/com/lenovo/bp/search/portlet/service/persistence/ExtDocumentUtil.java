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

import com.lenovo.bp.search.portlet.model.ExtDocument;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the ext document service. This utility wraps {@link ExtDocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see ExtDocumentPersistence
 * @see ExtDocumentPersistenceImpl
 * @generated
 */
public class ExtDocumentUtil {
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
	public static void clearCache(ExtDocument extDocument) {
		getPersistence().clearCache(extDocument);
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
	public static List<ExtDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExtDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExtDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ExtDocument update(ExtDocument extDocument)
		throws SystemException {
		return getPersistence().update(extDocument);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ExtDocument update(ExtDocument extDocument,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(extDocument, serviceContext);
	}

	/**
	* Caches the ext document in the entity cache if it is enabled.
	*
	* @param extDocument the ext document
	*/
	public static void cacheResult(
		com.lenovo.bp.search.portlet.model.ExtDocument extDocument) {
		getPersistence().cacheResult(extDocument);
	}

	/**
	* Caches the ext documents in the entity cache if it is enabled.
	*
	* @param extDocuments the ext documents
	*/
	public static void cacheResult(
		java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> extDocuments) {
		getPersistence().cacheResult(extDocuments);
	}

	/**
	* Creates a new ext document with the primary key. Does not add the ext document to the database.
	*
	* @param id_ the primary key for the new ext document
	* @return the new ext document
	*/
	public static com.lenovo.bp.search.portlet.model.ExtDocument create(
		long id_) {
		return getPersistence().create(id_);
	}

	/**
	* Removes the ext document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ the primary key of the ext document
	* @return the ext document that was removed
	* @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.ExtDocument remove(
		long id_)
		throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id_);
	}

	public static com.lenovo.bp.search.portlet.model.ExtDocument updateImpl(
		com.lenovo.bp.search.portlet.model.ExtDocument extDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(extDocument);
	}

	/**
	* Returns the ext document with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchExtDocumentException} if it could not be found.
	*
	* @param id_ the primary key of the ext document
	* @return the ext document
	* @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.ExtDocument findByPrimaryKey(
		long id_)
		throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	* Returns the ext document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ the primary key of the ext document
	* @return the ext document, or <code>null</code> if a ext document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lenovo.bp.search.portlet.model.ExtDocument fetchByPrimaryKey(
		long id_) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	* Returns all the ext documents.
	*
	* @return the ext documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ext documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.ExtDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext documents
	* @param end the upper bound of the range of ext documents (not inclusive)
	* @return the range of ext documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ext documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.ExtDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext documents
	* @param end the upper bound of the range of ext documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ext documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ext documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ext documents.
	*
	* @return the number of ext documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExtDocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExtDocumentPersistence)PortletBeanLocatorUtil.locate(com.lenovo.bp.search.portlet.service.ClpSerializer.getServletContextName(),
					ExtDocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(ExtDocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ExtDocumentPersistence persistence) {
	}

	private static ExtDocumentPersistence _persistence;
}