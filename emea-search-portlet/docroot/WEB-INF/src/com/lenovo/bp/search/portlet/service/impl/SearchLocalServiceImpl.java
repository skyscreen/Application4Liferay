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

package com.lenovo.bp.search.portlet.service.impl;

import java.util.List;


import com.lenovo.bp.search.portlet.service.base.SearchLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lenovo.bp.search.portlet.service.SearchLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author siyan
 * @see com.lenovo.bp.search.portlet.service.base.SearchLocalServiceBaseImpl
 * @see com.lenovo.bp.search.portlet.service.SearchLocalServiceUtil
 */
public class SearchLocalServiceImpl extends SearchLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.lenovo.bp.search.portlet.service.SearchLocalServiceUtil} to access the search local service.
	 */
	public List getAddAndModifyDocId(String structureId, String startDateTime, String endDateTime)throws com.liferay.portal.kernel.exception.SystemException{
		return searchPersistence.findBycollectAddAndModifyDocId(structureId,startDateTime,endDateTime);
		
	}
	
	public List getDeletedDocId(String structureId, String startDateTime, String endDateTime)throws com.liferay.portal.kernel.exception.SystemException{
		return searchPersistence.findBycollectDeletedDocId(structureId,startDateTime,endDateTime);
		
	}	
	

	public java.util.List getBycollectRole(
			) throws com.liferay.portal.kernel.exception.SystemException
	{
		return searchPersistence.findBycollectRole();
	}
	
	public java.util.List getBycollectDocument(String docId
			) throws com.liferay.portal.kernel.exception.SystemException
	{
		return searchPersistence.findBycollectDocument(docId);
	}	
}