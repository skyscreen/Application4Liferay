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

import com.lenovo.bp.search.portlet.NoSuchLangContentException;
import com.lenovo.bp.search.portlet.model.LangContent;
import com.lenovo.bp.search.portlet.model.impl.LangContentImpl;
import com.lenovo.bp.search.portlet.model.impl.LangContentModelImpl;

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
 * The persistence implementation for the lang content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see LangContentPersistence
 * @see LangContentUtil
 * @generated
 */
public class LangContentPersistenceImpl extends BasePersistenceImpl<LangContent>
	implements LangContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LangContentUtil} to access the lang content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LangContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LangContentModelImpl.ENTITY_CACHE_ENABLED,
			LangContentModelImpl.FINDER_CACHE_ENABLED, LangContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LangContentModelImpl.ENTITY_CACHE_ENABLED,
			LangContentModelImpl.FINDER_CACHE_ENABLED, LangContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LangContentModelImpl.ENTITY_CACHE_ENABLED,
			LangContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LangContentPersistenceImpl() {
		setModelClass(LangContent.class);
	}

	/**
	 * Caches the lang content in the entity cache if it is enabled.
	 *
	 * @param langContent the lang content
	 */
	@Override
	public void cacheResult(LangContent langContent) {
		EntityCacheUtil.putResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
			LangContentImpl.class, langContent.getPrimaryKey(), langContent);

		langContent.resetOriginalValues();
	}

	/**
	 * Caches the lang contents in the entity cache if it is enabled.
	 *
	 * @param langContents the lang contents
	 */
	@Override
	public void cacheResult(List<LangContent> langContents) {
		for (LangContent langContent : langContents) {
			if (EntityCacheUtil.getResult(
						LangContentModelImpl.ENTITY_CACHE_ENABLED,
						LangContentImpl.class, langContent.getPrimaryKey()) == null) {
				cacheResult(langContent);
			}
			else {
				langContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lang contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LangContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LangContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lang content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LangContent langContent) {
		EntityCacheUtil.removeResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
			LangContentImpl.class, langContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LangContent> langContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LangContent langContent : langContents) {
			EntityCacheUtil.removeResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
				LangContentImpl.class, langContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lang content with the primary key. Does not add the lang content to the database.
	 *
	 * @param locals the primary key for the new lang content
	 * @return the new lang content
	 */
	@Override
	public LangContent create(String locals) {
		LangContent langContent = new LangContentImpl();

		langContent.setNew(true);
		langContent.setPrimaryKey(locals);

		return langContent;
	}

	/**
	 * Removes the lang content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locals the primary key of the lang content
	 * @return the lang content that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangContentException if a lang content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangContent remove(String locals)
		throws NoSuchLangContentException, SystemException {
		return remove((Serializable)locals);
	}

	/**
	 * Removes the lang content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lang content
	 * @return the lang content that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangContentException if a lang content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangContent remove(Serializable primaryKey)
		throws NoSuchLangContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LangContent langContent = (LangContent)session.get(LangContentImpl.class,
					primaryKey);

			if (langContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLangContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(langContent);
		}
		catch (NoSuchLangContentException nsee) {
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
	protected LangContent removeImpl(LangContent langContent)
		throws SystemException {
		langContent = toUnwrappedModel(langContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(langContent)) {
				langContent = (LangContent)session.get(LangContentImpl.class,
						langContent.getPrimaryKeyObj());
			}

			if (langContent != null) {
				session.delete(langContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (langContent != null) {
			clearCache(langContent);
		}

		return langContent;
	}

	@Override
	public LangContent updateImpl(
		com.lenovo.bp.search.portlet.model.LangContent langContent)
		throws SystemException {
		langContent = toUnwrappedModel(langContent);

		boolean isNew = langContent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (langContent.isNew()) {
				session.save(langContent);

				langContent.setNew(false);
			}
			else {
				session.merge(langContent);
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

		EntityCacheUtil.putResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
			LangContentImpl.class, langContent.getPrimaryKey(), langContent);

		return langContent;
	}

	protected LangContent toUnwrappedModel(LangContent langContent) {
		if (langContent instanceof LangContentImpl) {
			return langContent;
		}

		LangContentImpl langContentImpl = new LangContentImpl();

		langContentImpl.setNew(langContent.isNew());
		langContentImpl.setPrimaryKey(langContent.getPrimaryKey());

		langContentImpl.setLocals(langContent.getLocals());
		langContentImpl.setContent(langContent.getContent());

		return langContentImpl;
	}

	/**
	 * Returns the lang content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lang content
	 * @return the lang content
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangContentException if a lang content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLangContentException, SystemException {
		LangContent langContent = fetchByPrimaryKey(primaryKey);

		if (langContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLangContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return langContent;
	}

	/**
	 * Returns the lang content with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchLangContentException} if it could not be found.
	 *
	 * @param locals the primary key of the lang content
	 * @return the lang content
	 * @throws com.lenovo.bp.search.portlet.NoSuchLangContentException if a lang content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangContent findByPrimaryKey(String locals)
		throws NoSuchLangContentException, SystemException {
		return findByPrimaryKey((Serializable)locals);
	}

	/**
	 * Returns the lang content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lang content
	 * @return the lang content, or <code>null</code> if a lang content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LangContent langContent = (LangContent)EntityCacheUtil.getResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
				LangContentImpl.class, primaryKey);

		if (langContent == _nullLangContent) {
			return null;
		}

		if (langContent == null) {
			Session session = null;

			try {
				session = openSession();

				langContent = (LangContent)session.get(LangContentImpl.class,
						primaryKey);

				if (langContent != null) {
					cacheResult(langContent);
				}
				else {
					EntityCacheUtil.putResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
						LangContentImpl.class, primaryKey, _nullLangContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LangContentModelImpl.ENTITY_CACHE_ENABLED,
					LangContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return langContent;
	}

	/**
	 * Returns the lang content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locals the primary key of the lang content
	 * @return the lang content, or <code>null</code> if a lang content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LangContent fetchByPrimaryKey(String locals)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)locals);
	}

	/**
	 * Returns all the lang contents.
	 *
	 * @return the lang contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LangContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lang contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.LangContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lang contents
	 * @param end the upper bound of the range of lang contents (not inclusive)
	 * @return the range of lang contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LangContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lang contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.LangContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lang contents
	 * @param end the upper bound of the range of lang contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lang contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LangContent> findAll(int start, int end,
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

		List<LangContent> list = (List<LangContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LANGCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANGCONTENT;

				if (pagination) {
					sql = sql.concat(LangContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LangContent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LangContent>(list);
				}
				else {
					list = (List<LangContent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the lang contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LangContent langContent : findAll()) {
			remove(langContent);
		}
	}

	/**
	 * Returns the number of lang contents.
	 *
	 * @return the number of lang contents
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

				Query q = session.createQuery(_SQL_COUNT_LANGCONTENT);

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
	 * Initializes the lang content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lenovo.bp.search.portlet.model.LangContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LangContent>> listenersList = new ArrayList<ModelListener<LangContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LangContent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LangContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LANGCONTENT = "SELECT langContent FROM LangContent langContent";
	private static final String _SQL_COUNT_LANGCONTENT = "SELECT COUNT(langContent) FROM LangContent langContent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "langContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LangContent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LangContentPersistenceImpl.class);
	private static LangContent _nullLangContent = new LangContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LangContent> toCacheModel() {
				return _nullLangContentCacheModel;
			}
		};

	private static CacheModel<LangContent> _nullLangContentCacheModel = new CacheModel<LangContent>() {
			@Override
			public LangContent toEntityModel() {
				return _nullLangContent;
			}
		};
}