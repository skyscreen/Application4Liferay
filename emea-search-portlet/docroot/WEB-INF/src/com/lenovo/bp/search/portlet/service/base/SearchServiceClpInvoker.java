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

package com.lenovo.bp.search.portlet.service.base;

import com.lenovo.bp.search.portlet.service.SearchServiceUtil;

import java.util.Arrays;

/**
 * @author siyan
 * @generated
 */
public class SearchServiceClpInvoker {
	public SearchServiceClpInvoker() {
		_methodName30 = "getBeanIdentifier";

		_methodParameterTypes30 = new String[] {  };

		_methodName31 = "setBeanIdentifier";

		_methodParameterTypes31 = new String[] { "java.lang.String" };

		_methodName36 = "getAddAndModifyDocId";

		_methodParameterTypes36 = new String[] { "java.lang.String","java.lang.String","java.lang.String"};

		_methodName37 = "getDeletedDocId";

		_methodParameterTypes37 = new String[] { "java.lang.String","java.lang.String","java.lang.String" };

		_methodName38 = "getBycollectRole";

//		_methodParameterTypes38 = new String[] { "long" };
		
		_methodName39 = "getBycollectDocument";
		
		_methodParameterTypes39 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SearchServiceUtil.getBeanIdentifier();
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			SearchServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SearchServiceUtil.getAddAndModifyDocId((java.lang.String)arguments[0],(java.lang.String)arguments[1],(java.lang.String)arguments[2]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SearchServiceUtil.getDeletedDocId((java.lang.String)arguments[0],(java.lang.String)arguments[1],(java.lang.String)arguments[2]);
		}

		if (_methodName38.equals(name) ) {
			return SearchServiceUtil.getBycollectRole();
		}
		
		if (_methodName39.equals(name) && Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SearchServiceUtil.getBycollectDocument((java.lang.String)arguments[0]);
		}		

		throw new UnsupportedOperationException();
	}

	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;	
}