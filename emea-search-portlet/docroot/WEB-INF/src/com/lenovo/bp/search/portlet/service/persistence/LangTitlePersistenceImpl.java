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

import com.lenovo.bp.search.portlet.NoSuchLangTitleException;
import com.lenovo.bp.search.portlet.model.LangTitle;
import com.lenovo.bp.search.portlet.model.impl.LangTitleImpl;
import com.lenovo.bp.search.portlet.model.impl.LangTitleModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the lang title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see LangTitlePersistence
 * @see LangTitleUtil
 * @generated
 */
public class LangTitlePersistenceImpl extends BasePersistenceImpl<LangTitle>
	implements LangTitlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LangTitleUtil} to access the lang title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LangTitleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
			LangTitleModelImpl.FINDER_CACHE_ENABLED, LangTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
			LangTitleModelImpl.FINDER_CACHE_ENABLED, LangTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
			LangTitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LangTitlePersistenceImpl() {
		setModelClass(LangTitle.class);
	}

	/**
	 * Caches the lang title in the entity cache if it is enabled.
	 *
	 * @param langTitle the lang title
	 */
	@Override
	public void cacheResult(LangTitle langTitle) {
		EntityCacheUtil.putResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
			LangTitleImpl.class, langTitle.getPrimaryKey(), langTitle);

		langTitle.resetOriginalValues();
	}

	/**
	 * Caches the lang titles in the entity cache if it is enabled.
	 *
	 * @param langTitles the lang titles
	 */
	@Override
	public void cacheResult(List<LangTitle> langTitles) {
		for (LangTitle langTitle : langTitles) {
			if (EntityCacheUtil.getResult(
						LangTitleModelImpl.ENTITY_CACHE_ENABLED,
						LangTitleImpl.class, langTitle.getPrimaryKey()) == null) {
				cacheResult(langTitle);
			}
			else {
				langTitle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lang titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LangTitleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LangTitleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lang title.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LangTitle langTitle) {
		EntityCacheUtil.removeResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
			LangTitleImpl.class, langTitle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LangTitle> langTitles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LangTitle langTitle : langTitles) {
			EntityCacheUtil.removeResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
				LangTitleImpl.class, langTitle.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lang title with the primary key. Does not add the lang title to the database.
	 *
	 * @param locals the primary key for the new lang title
	 * @return the new lang title
	 */
	@Override
	public LangTitle create(String locals) {
		LangTitle langTitle = new LangTitleImpl();

		langTitle.setNew(true);
		langTitle.setPrimaryKey(locals);

		return langTitle;
	}

	/**
	 * Removes the lang title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locals the primary key of the lang title
	 * @return the lang title that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangTitleException if a lang title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangTitle remove(String locals)
		throws NoSuchLangTitleException, SystemException {
		return remove((Serializable)locals);
	}

	/**
	 * Removes the lang title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lang title
	 * @return the lang title that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangTitleException if a lang title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangTitle remove(Serializable primaryKey)
		throws NoSuchLangTitleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LangTitle langTitle = (LangTitle)session.get(LangTitleImpl.class,
					primaryKey);

			if (langTitle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLangTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(langTitle);
		}
		catch (NoSuchLangTitleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LangTitle removeImpl(LangTitle langTitle)
		throws SystemException {
		langTitle = toUnwrappedModel(langTitle);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(langTitle)) {
				langTitle = (LangTitle)session.get(LangTitleImpl.class,
						langTitle.getPrimaryKeyObj());
			}

			if (langTitle != null) {
				session.delete(langTitle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (langTitle != null) {
			clearCache(langTitle);
		}

		return langTitle;
	}

	@Override
	public LangTitle updateImpl(
		com.lenovo.bp.search.portlet.model.LangTitle langTitle)
		throws SystemException {
		langTitle = toUnwrappedModel(langTitle);

		boolean isNew = langTitle.isNew();

		Session session = null;

		try {
			session = openSession();

			if (langTitle.isNew()) {
				session.save(langTitle);

				langTitle.setNew(false);
			}
			else {
				session.merge(langTitle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
			LangTitleImpl.class, langTitle.getPrimaryKey(), langTitle);

		return langTitle;
	}

	protected LangTitle toUnwrappedModel(LangTitle langTitle) {
		if (langTitle instanceof LangTitleImpl) {
			return langTitle;
		}

		LangTitleImpl langTitleImpl = new LangTitleImpl();

		langTitleImpl.setNew(langTitle.isNew());
		langTitleImpl.setPrimaryKey(langTitle.getPrimaryKey());

		langTitleImpl.setLocals(langTitle.getLocals());
		langTitleImpl.setTitle(langTitle.getTitle());

		return langTitleImpl;
	}

	/**
	 * Returns the lang title with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lang title
	 * @return the lang title
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangTitleException if a lang title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangTitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLangTitleException, SystemException {
		LangTitle langTitle = fetchByPrimaryKey(primaryKey);

		if (langTitle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLangTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return langTitle;
	}

	/**
	 * Returns the lang title with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchLangTitleException} if it could not be found.
	 *
	 * @param locals the primary key of the lang title
	 * @return the lang title
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangTitleException if a lang title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangTitle findByPrimaryKey(String locals)
		throws NoSuchLangTitleException, SystemException {
		return findByPrimaryKey((Serializable)locals);
	}

	/**
	 * Returns the lang title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lang title
	 * @return the lang title, or <code>null</code> if a lang title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangTitle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LangTitle langTitle = (LangTitle)EntityCacheUtil.getResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
				LangTitleImpl.class, primaryKey);

		if (langTitle == _nullLangTitle) {
			return null;
		}

		if (langTitle == null) {
			Session session = null;

			try {
				session = openSession();

				langTitle = (LangTitle)session.get(LangTitleImpl.class,
						primaryKey);

				if (langTitle != null) {
					cacheResult(langTitle);
				}
				else {
					EntityCacheUtil.putResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
						LangTitleImpl.class, primaryKey, _nullLangTitle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LangTitleModelImpl.ENTITY_CACHE_ENABLED,
					LangTitleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return langTitle;
	}

	/**
	 * Returns the lang title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locals the primary key of the lang title
	 * @return the lang title, or <code>null</code> if a lang title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangTitle fetchByPrimaryKey(String locals) throws SystemException {
		return fetchByPrimaryKey((Serializable)locals);
	}

	/**
	 * Returns all the lang titles.
	 *
	 * @return the lang titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LangTitle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LangTitle> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<LangTitle> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LangTitle> list = (List<LangTitle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LANGTITLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANGTITLE;

				if (pagination) {
					sql = sql.concat(LangTitleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LangTitle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LangTitle>(list);
				}
				else {
					list = (List<LangTitle>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the lang titles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LangTitle langTitle : findAll()) {
			remove(langTitle);
		}
	}

	/**
	 * Returns the number of lang titles.
	 *
	 * @return the number of lang titles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANGTITLE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the lang title persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lenovo.bp.search.portlet.model.LangTitle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LangTitle>> listenersList = new ArrayList<ModelListener<LangTitle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LangTitle>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LangTitleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LANGTITLE = "SELECT langTitle FROM LangTitle langTitle";
	private static final String _SQL_COUNT_LANGTITLE = "SELECT COUNT(langTitle) FROM LangTitle langTitle";
	private static final String _ORDER_BY_ENTITY_ALIAS = "langTitle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LangTitle exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LangTitlePersistenceImpl.class);
	private static LangTitle _nullLangTitle = new LangTitleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LangTitle> toCacheModel() {
				return _nullLangTitleCacheModel;
			}
		};

	private static CacheModel<LangTitle> _nullLangTitleCacheModel = new CacheModel<LangTitle>() {
			@Override
			public LangTitle toEntityModel() {
				return _nullLangTitle;
			}
		};
}