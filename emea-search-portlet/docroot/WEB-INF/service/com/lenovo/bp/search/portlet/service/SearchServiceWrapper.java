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

package com.lenovo.bp.search.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchService}.
 *
 * @author siyan
 * @see SearchService
 * @generated
 */
public class SearchServiceWrapper implements SearchService,
	ServiceWrapper<SearchService> {
	public SearchServiceWrapper(SearchService searchService) {
		_searchService = searchService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _searchService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_searchService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _searchService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List getAddAndModifyDocId(String structureId, String startDateTime, String endDateTime)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchService.getAddAndModifyDocId(structureId,startDateTime,endDateTime);
	}

	@Override
	public java.util.List getDeletedDocId(String structureId, String startDateTime, String endDateTime)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchService.getDeletedDocId(structureId,startDateTime,endDateTime);
	}

	@Override
	public java.util.List getBycollectRole()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchService.getBycollectRole();
	}
	
	@Override
	public java.util.List getBycollectDocument(String docId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchService.getBycollectDocument(docId);
	}	

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SearchService getWrappedSearchService() {
		return _searchService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSearchService(SearchService searchService) {
		_searchService = searchService;
	}

	@Override
	public SearchService getWrappedService() {
		return _searchService;
	}

	@Override
	public void setWrappedService(SearchService searchService) {
		_searchService = searchService;
	}

	private SearchService _searchService;
}