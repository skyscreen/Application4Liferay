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

import com.lenovo.bp.search.portlet.NoSuchExtDocumentException;
import com.lenovo.bp.search.portlet.model.ExtDocument;
import com.lenovo.bp.search.portlet.model.impl.ExtDocumentImpl;
import com.lenovo.bp.search.portlet.model.impl.ExtDocumentModelImpl;

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
 * The persistence implementation for the ext document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see ExtDocumentPersistence
 * @see ExtDocumentUtil
 * @generated
 */
public class ExtDocumentPersistenceImpl extends BasePersistenceImpl<ExtDocument>
	implements ExtDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExtDocumentUtil} to access the ext document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExtDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ExtDocumentModelImpl.FINDER_CACHE_ENABLED, ExtDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ExtDocumentModelImpl.FINDER_CACHE_ENABLED, ExtDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ExtDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ExtDocumentPersistenceImpl() {
		setModelClass(ExtDocument.class);
	}

	/**
	 * Caches the ext document in the entity cache if it is enabled.
	 *
	 * @param extDocument the ext document
	 */
	@Override
	public void cacheResult(ExtDocument extDocument) {
		EntityCacheUtil.putResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ExtDocumentImpl.class, extDocument.getPrimaryKey(), extDocument);

		extDocument.resetOriginalValues();
	}

	/**
	 * Caches the ext documents in the entity cache if it is enabled.
	 *
	 * @param extDocuments the ext documents
	 */
	@Override
	public void cacheResult(List<ExtDocument> extDocuments) {
		for (ExtDocument extDocument : extDocuments) {
			if (EntityCacheUtil.getResult(
						ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ExtDocumentImpl.class, extDocument.getPrimaryKey()) == null) {
				cacheResult(extDocument);
			}
			else {
				extDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ext documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExtDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExtDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ext document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExtDocument extDocument) {
		EntityCacheUtil.removeResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ExtDocumentImpl.class, extDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExtDocument> extDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExtDocument extDocument : extDocuments) {
			EntityCacheUtil.removeResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ExtDocumentImpl.class, extDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ext document with the primary key. Does not add the ext document to the database.
	 *
	 * @param id_ the primary key for the new ext document
	 * @return the new ext document
	 */
	@Override
	public ExtDocument create(long id_) {
		ExtDocument extDocument = new ExtDocumentImpl();

		extDocument.setNew(true);
		extDocument.setPrimaryKey(id_);

		return extDocument;
	}

	/**
	 * Removes the ext document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the ext document
	 * @return the ext document that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtDocument remove(long id_)
		throws NoSuchExtDocumentException, SystemException {
		return remove((Serializable)id_);
	}

	/**
	 * Removes the ext document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ext document
	 * @return the ext document that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtDocument remove(Serializable primaryKey)
		throws NoSuchExtDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExtDocument extDocument = (ExtDocument)session.get(ExtDocumentImpl.class,
					primaryKey);

			if (extDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExtDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(extDocument);
		}
		catch (NoSuchExtDocumentException nsee) {
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
	protected ExtDocument removeImpl(ExtDocument extDocument)
		throws SystemException {
		extDocument = toUnwrappedModel(extDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(extDocument)) {
				extDocument = (ExtDocument)session.get(ExtDocumentImpl.class,
						extDocument.getPrimaryKeyObj());
			}

			if (extDocument != null) {
				session.delete(extDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (extDocument != null) {
			clearCache(extDocument);
		}

		return extDocument;
	}

	@Override
	public ExtDocument updateImpl(
		com.lenovo.bp.search.portlet.model.ExtDocument extDocument)
		throws SystemException {
		extDocument = toUnwrappedModel(extDocument);

		boolean isNew = extDocument.isNew();

		Session session = null;

		try {
			session = openSession();

			if (extDocument.isNew()) {
				session.save(extDocument);

				extDocument.setNew(false);
			}
			else {
				session.merge(extDocument);
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

		EntityCacheUtil.putResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ExtDocumentImpl.class, extDocument.getPrimaryKey(), extDocument);

		return extDocument;
	}

	protected ExtDocument toUnwrappedModel(ExtDocument extDocument) {
		if (extDocument instanceof ExtDocumentImpl) {
			return extDocument;
		}

		ExtDocumentImpl extDocumentImpl = new ExtDocumentImpl();

		extDocumentImpl.setNew(extDocument.isNew());
		extDocumentImpl.setPrimaryKey(extDocument.getPrimaryKey());

		extDocumentImpl.setId_(extDocument.getId_());
		extDocumentImpl.setCreateDate(extDocument.getCreateDate());
		extDocumentImpl.setArticleId(extDocument.getArticleId());
		extDocumentImpl.setVersion(extDocument.getVersion());
		extDocumentImpl.setListLangTitle(extDocument.getListLangTitle());

		return extDocumentImpl;
	}

	/**
	 * Returns the ext document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext document
	 * @return the ext document
	 * @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExtDocumentException, SystemException {
		ExtDocument extDocument = fetchByPrimaryKey(primaryKey);

		if (extDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExtDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return extDocument;
	}

	/**
	 * Returns the ext document with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchExtDocumentException} if it could not be found.
	 *
	 * @param id_ the primary key of the ext document
	 * @return the ext document
	 * @throws com.lenovo.bp.search.portlet.NoSuchExtDocumentException if a ext document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtDocument findByPrimaryKey(long id_)
		throws NoSuchExtDocumentException, SystemException {
		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the ext document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext document
	 * @return the ext document, or <code>null</code> if a ext document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ExtDocument extDocument = (ExtDocument)EntityCacheUtil.getResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ExtDocumentImpl.class, primaryKey);

		if (extDocument == _nullExtDocument) {
			return null;
		}

		if (extDocument == null) {
			Session session = null;

			try {
				session = openSession();

				extDocument = (ExtDocument)session.get(ExtDocumentImpl.class,
						primaryKey);

				if (extDocument != null) {
					cacheResult(extDocument);
				}
				else {
					EntityCacheUtil.putResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ExtDocumentImpl.class, primaryKey, _nullExtDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExtDocumentModelImpl.ENTITY_CACHE_ENABLED,
					ExtDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return extDocument;
	}

	/**
	 * Returns the ext document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the ext document
	 * @return the ext document, or <code>null</code> if a ext document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ExtDocument fetchByPrimaryKey(long id_) throws SystemException {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the ext documents.
	 *
	 * @return the ext documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ExtDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ExtDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ExtDocument> findAll(int start, int end,
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

		List<ExtDocument> list = (List<ExtDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXTDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTDOCUMENT;

				if (pagination) {
					sql = sql.concat(ExtDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExtDocument>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ExtDocument>(list);
				}
				else {
					list = (List<ExtDocument>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ext documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ExtDocument extDocument : findAll()) {
			remove(extDocument);
		}
	}

	/**
	 * Returns the number of ext documents.
	 *
	 * @return the number of ext documents
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

				Query q = session.createQuery(_SQL_COUNT_EXTDOCUMENT);

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
	 * Initializes the ext document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lenovo.bp.search.portlet.model.ExtDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExtDocument>> listenersList = new ArrayList<ModelListener<ExtDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExtDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExtDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXTDOCUMENT = "SELECT extDocument FROM ExtDocument extDocument";
	private static final String _SQL_COUNT_EXTDOCUMENT = "SELECT COUNT(extDocument) FROM ExtDocument extDocument";
	private static final String _ORDER_BY_ENTITY_ALIAS = "extDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExtDocument exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExtDocumentPersistenceImpl.class);
	private static ExtDocument _nullExtDocument = new ExtDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ExtDocument> toCacheModel() {
				return _nullExtDocumentCacheModel;
			}
		};

	private static CacheModel<ExtDocument> _nullExtDocumentCacheModel = new CacheModel<ExtDocument>() {
			@Override
			public ExtDocument toEntityModel() {
				return _nullExtDocument;
			}
		};
}