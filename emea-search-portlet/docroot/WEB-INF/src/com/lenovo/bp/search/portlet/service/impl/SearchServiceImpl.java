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

import java.util.Collections;
import java.util.List;

import com.lenovo.bp.search.portlet.service.SearchLocalServiceUtil;
import com.lenovo.bp.search.portlet.service.base.SearchServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;

/**
 * The implementation of the search remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lenovo.bp.search.portlet.service.SearchService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author siyan
 * @see com.lenovo.bp.search.portlet.service.base.SearchServiceBaseImpl
 * @see com.lenovo.bp.search.portlet.service.SearchServiceUtil
 */
public class SearchServiceImpl extends SearchServiceBaseImpl {
	
	private List<String>invalidUserList = Collections.singletonList("invalid user");
	private String validEmail = "test@liferay.com";
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.lenovo.bp.search.portlet.service.SearchServiceUtil} to access the search remote service.
	 */
	public List getAddAndModifyDocId(String structureId, String startDateTime, String endDateTime) throws PortalException, SystemException {
		if (!isValidServiceUser()) {
		    return invalidUserList;
		}
		return SearchLocalServiceUtil.getAddAndModifyDocId(structureId,startDateTime,endDateTime);
	}
	
	public List getDeletedDocId(String structureId, String startDateTime, String endDateTime) throws PortalException, SystemException {
		if (!isValidServiceUser()) {
		    return invalidUserList;
		}
		return SearchLocalServiceUtil.getDeletedDocId(structureId,startDateTime,endDateTime);
	}	
	
	public List getBycollectRole() throws PortalException, SystemException {
		if (!isValidServiceUser()) {
		    return invalidUserList;
		}
		return SearchLocalServiceUtil.getBycollectRole();
	}	

	public List getBycollectDocument(String docId) throws PortalException, SystemException {
		if (!isValidServiceUser()) {
		    return invalidUserList;
		}
		return SearchLocalServiceUtil.getBycollectDocument(docId);
	}	
	
	private boolean isValidServiceUser(){
		User user;
		try {
			user = getGuestOrUser();
			
			//get from ext-properties
			String validRole = PropsUtil.getProperties().getProperty("service.search.role");
//		    System.out.println("get properties:"+PropsUtil.getProperties().getProperty("service.search.role"));
		    List<Role> roles = user.getRoles();
		    for (int i=0; i<roles.size();i++){
		    	if (roles.get(i).getName().equalsIgnoreCase(validRole)){
		    		return true;
		    	}
		    }
		    return false;
		} catch (Exception e) {
			return false;
		} 

	}
}