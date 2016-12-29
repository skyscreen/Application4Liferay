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

import com.lenovo.bp.search.portlet.model.Search;
import com.lenovo.bp.search.portlet.service.SearchService;
import com.lenovo.bp.search.portlet.service.persistence.DocumentPersistence;
import com.lenovo.bp.search.portlet.service.persistence.RolePersistence;
import com.lenovo.bp.search.portlet.service.persistence.SearchPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the search remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.lenovo.bp.search.portlet.service.impl.SearchServiceImpl}.
 * </p>
 *
 * @author siyan
 * @see com.lenovo.bp.search.portlet.service.impl.SearchServiceImpl
 * @see com.lenovo.bp.search.portlet.service.SearchServiceUtil
 * @generated
 */
public abstract class SearchServiceBaseImpl extends BaseServiceImpl
	implements SearchService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.lenovo.bp.search.portlet.service.SearchServiceUtil} to access the search remote service.
	 */

	/**
	 * Returns the document persistence.
	 *
	 * @return the document persistence
	 */
	public DocumentPersistence getDocumentPersistence() {
		return documentPersistence;
	}

	/**
	 * Sets the document persistence.
	 *
	 * @param documentPersistence the document persistence
	 */
	public void setDocumentPersistence(DocumentPersistence documentPersistence) {
		this.documentPersistence = documentPersistence;
	}

	/**
	 * Returns the role persistence.
	 *
	 * @return the role persistence
	 */
	public RolePersistence getRolePersistence() {
		return rolePersistence;
	}

	/**
	 * Sets the role persistence.
	 *
	 * @param rolePersistence the role persistence
	 */
	public void setRolePersistence(RolePersistence rolePersistence) {
		this.rolePersistence = rolePersistence;
	}

	/**
	 * Returns the search local service.
	 *
	 * @return the search local service
	 */
	public com.lenovo.bp.search.portlet.service.SearchLocalService getSearchLocalService() {
		return searchLocalService;
	}

	/**
	 * Sets the search local service.
	 *
	 * @param searchLocalService the search local service
	 */
	public void setSearchLocalService(
		com.lenovo.bp.search.portlet.service.SearchLocalService searchLocalService) {
		this.searchLocalService = searchLocalService;
	}

	/**
	 * Returns the search remote service.
	 *
	 * @return the search remote service
	 */
	public com.lenovo.bp.search.portlet.service.SearchService getSearchService() {
		return searchService;
	}

	/**
	 * Sets the search remote service.
	 *
	 * @param searchService the search remote service
	 */
	public void setSearchService(
		com.lenovo.bp.search.portlet.service.SearchService searchService) {
		this.searchService = searchService;
	}

	/**
	 * Returns the search persistence.
	 *
	 * @return the search persistence
	 */
	public SearchPersistence getSearchPersistence() {
		return searchPersistence;
	}

	/**
	 * Sets the search persistence.
	 *
	 * @param searchPersistence the search persistence
	 */
	public void setSearchPersistence(SearchPersistence searchPersistence) {
		this.searchPersistence = searchPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Search.class;
	}

	protected String getModelClassName() {
		return Search.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = searchPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DocumentPersistence.class)
	protected DocumentPersistence documentPersistence;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = com.lenovo.bp.search.portlet.service.SearchLocalService.class)
	protected com.lenovo.bp.search.portlet.service.SearchLocalService searchLocalService;
	@BeanReference(type = com.lenovo.bp.search.portlet.service.SearchService.class)
	protected com.lenovo.bp.search.portlet.service.SearchService searchService;
	@BeanReference(type = SearchPersistence.class)
	protected SearchPersistence searchPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SearchServiceClpInvoker _clpInvoker = new SearchServiceClpInvoker();
}