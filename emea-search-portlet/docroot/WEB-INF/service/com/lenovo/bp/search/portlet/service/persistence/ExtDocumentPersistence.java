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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the ext document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see ExtDocumentPersistenceImpl
 * @see ExtDocumentUtil
 * @generated
 */
public interface ExtDocumentPersistence extends BasePersistence<ExtDocument> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtDocumentUtil} to access the ext document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ext document in the entity cache if it is enabled.
	*
	* @param extDocument the ext document
	*/
	public void cacheResult(
		com.lenovo.bp.search.portlet.model.ExtDocument extDocument);

	/**
	* Caches the ext documents in the entity cache if it is enabled.
	*
	* @param extDocuments the ext documents
	*/
	public void cacheResult(
		java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> extDocuments);

	/**
	* Creates a new ext document with the primary key. Does not add the ext document to the database.
	*
	* @param id_ the primary key for the new ext document
	* @return the new ext document
	*/
	public com.lenovo.bp.search.portlet.model.ExtDocument create(long id_);

	/**
	* Removes the ext document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ the primary key of the ext document
	* @return the ext document that was removed
	* @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lenovo.bp.search.portlet.model.ExtDocument remove(long id_)
		throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lenovo.bp.search.portlet.model.ExtDocument updateImpl(
		com.lenovo.bp.search.portlet.model.ExtDocument extDocument)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ext document with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchExtDocumentException} if it could not be found.
	*
	* @param id_ the primary key of the ext document
	* @return the ext document
	* @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lenovo.bp.search.portlet.model.ExtDocument findByPrimaryKey(
		long id_)
		throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ext document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_ the primary key of the ext document
	* @return the ext document, or <code>null</code> if a ext document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lenovo.bp.search.portlet.model.ExtDocument fetchByPrimaryKey(
		long id_) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ext documents.
	*
	* @return the ext documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lenovo.bp.search.portlet.model.ExtDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ext documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ext documents.
	*
	* @return the number of ext documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}