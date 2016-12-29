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

package com.lenovo.bp.search.portlet.service.http;

import com.lenovo.bp.search.portlet.service.SearchServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.lenovo.bp.search.portlet.service.SearchServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.lenovo.bp.search.portlet.model.SearchSoap}.
 * If the method in the service utility returns a
 * {@link com.lenovo.bp.search.portlet.model.Search}, that is translated to a
 * {@link com.lenovo.bp.search.portlet.model.SearchSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author siyan
 * @see SearchServiceHttp
 * @see com.lenovo.bp.search.portlet.model.SearchSoap
 * @see com.lenovo.bp.search.portlet.service.SearchServiceUtil
 * @generated
 */
public class SearchServiceSoap {
	public static java.util.List getAddAndModifyDocId(String structureId, String startDateTime, String endDateTime)
		throws RemoteException {
		try {
			java.util.List returnValue = SearchServiceUtil.getAddAndModifyDocId(structureId,startDateTime,endDateTime);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.util.List getDeletedDocId(String structureId, String startDateTime, String endDateTime)
		throws RemoteException {
		try {
			java.util.List returnValue = SearchServiceUtil.getDeletedDocId(structureId,startDateTime,endDateTime);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}
	
	public static java.util.List getBycollectRole()
			throws RemoteException {
			try {
				java.util.List returnValue = SearchServiceUtil.getBycollectRole();

				return returnValue;
			}
			catch (Exception e) {
				_log.error(e, e);

				throw new RemoteException(e.getMessage());
			}
		}	
	
	public static java.util.List getBycollectDocument(String docId)
			throws RemoteException {
			try {
				java.util.List returnValue = SearchServiceUtil.getBycollectDocument(docId);

				return returnValue;
			}
			catch (Exception e) {
				_log.error(e, e);

				throw new RemoteException(e.getMessage());
			}
		}	

	private static Log _log = LogFactoryUtil.getLog(SearchServiceSoap.class);
}