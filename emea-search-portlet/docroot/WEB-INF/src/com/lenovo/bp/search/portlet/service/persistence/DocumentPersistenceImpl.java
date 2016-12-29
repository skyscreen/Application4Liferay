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

import com.lenovo.bp.search.portlet.NoSuchDocumentException;
import com.lenovo.bp.search.portlet.model.Document;
import com.lenovo.bp.search.portlet.model.impl.DocumentImpl;
import com.lenovo.bp.search.portlet.model.impl.DocumentModelImpl;

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
 * The persistence implementation for the document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see DocumentPersistence
 * @see DocumentUtil
 * @generated
 */
public class DocumentPersistenceImpl extends BasePersistenceImpl<Document>
	implements DocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentUtil} to access the document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, DocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DocumentPersistenceImpl() {
		setModelClass(Document.class);
	}

	/**
	 * Caches the document in the entity cache if it is enabled.
	 *
	 * @param document the document
	 */
	@Override
	public void cacheResult(Document document) {
		EntityCacheUtil.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey(), document);

		document.resetOriginalValues();
	}

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	@Override
	public void cacheResult(List<Document> documents) {
		for (Document document : documents) {
			if (EntityCacheUtil.getResult(
						DocumentModelImpl.ENTITY_CACHE_ENABLED,
						DocumentImpl.class, document.getPrimaryKey()) == null) {
				cacheResult(document);
			}
			else {
				document.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Document document) {
		EntityCacheUtil.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Document> documents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Document document : documents) {
			EntityCacheUtil.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
				DocumentImpl.class, document.getPrimaryKey());
		}
	}

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param id_ the primary key for the new document
	 * @return the new document
	 */
	@Override
	public Document create(long id_) {
		Document document = new DocumentImpl();

		document.setNew(true);
		document.setPrimaryKey(id_);

		return document;
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the document
	 * @return the document that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchDocumentException if a document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document remove(long id_)
		throws NoSuchDocumentException, SystemException {
		return remove((Serializable)id_);
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchDocumentException if a document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document remove(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Document document = (Document)session.get(DocumentImpl.class,
					primaryKey);

			if (document == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(document);
		}
		catch (NoSuchDocumentException nsee) {
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
	protected Document removeImpl(Document document) throws SystemException {
		document = toUnwrappedModel(document);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(document)) {
				document = (Document)session.get(DocumentImpl.class,
						document.getPrimaryKeyObj());
			}

			if (document != null) {
				session.delete(document);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (document != null) {
			clearCache(document);
		}

		return document;
	}

	@Override
	public Document updateImpl(
		com.lenovo.bp.search.portlet.model.Document document)
		throws SystemException {
		document = toUnwrappedModel(document);

		boolean isNew = document.isNew();

		Session session = null;

		try {
			session = openSession();

			if (document.isNew()) {
				session.save(document);

				document.setNew(false);
			}
			else {
				session.merge(document);
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

		EntityCacheUtil.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
			DocumentImpl.class, document.getPrimaryKey(), document);

		return document;
	}

	protected Document toUnwrappedModel(Document document) {
		if (document instanceof DocumentImpl) {
			return document;
		}

		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setNew(document.isNew());
		documentImpl.setPrimaryKey(document.getPrimaryKey());

		documentImpl.setId_(document.getId_());
		documentImpl.setCreateDate(document.getCreateDate());
		documentImpl.setArticleId(document.getArticleId());
		documentImpl.setVersion(document.getVersion());
		documentImpl.setTitle(document.getTitle());
		documentImpl.setContent(document.getContent());

		return documentImpl;
	}

	/**
	 * Returns the document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document
	 * @throws com.lenovo.bp.search.portlet.NoSuchDocumentException if a document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentException, SystemException {
		Document document = fetchByPrimaryKey(primaryKey);

		if (document == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return document;
	}

	/**
	 * Returns the document with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchDocumentException} if it could not be found.
	 *
	 * @param id_ the primary key of the document
	 * @return the document
	 * @throws com.lenovo.bp.search.portlet.NoSuchDocumentException if a document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document findByPrimaryKey(long id_)
		throws NoSuchDocumentException, SystemException {
		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Document document = (Document)EntityCacheUtil.getResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
				DocumentImpl.class, primaryKey);

		if (document == _nullDocument) {
			return null;
		}

		if (document == null) {
			Session session = null;

			try {
				session = openSession();

				document = (Document)session.get(DocumentImpl.class, primaryKey);

				if (document != null) {
					cacheResult(document);
				}
				else {
					EntityCacheUtil.putResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
						DocumentImpl.class, primaryKey, _nullDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DocumentModelImpl.ENTITY_CACHE_ENABLED,
					DocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return document;
	}

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Document fetchByPrimaryKey(long id_) throws SystemException {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the documents.
	 *
	 * @return the documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Document> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Document> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.DocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Document> findAll(int start, int end,
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

		List<Document> list = (List<Document>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENT;

				if (pagination) {
					sql = sql.concat(DocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Document>(list);
				}
				else {
					list = (List<Document>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Document document : findAll()) {
			remove(document);
		}
	}

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
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

				Query q = session.createQuery(_SQL_COUNT_DOCUMENT);

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
	 * Initializes the document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lenovo.bp.search.portlet.model.Document")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Document>> listenersList = new ArrayList<ModelListener<Document>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Document>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DOCUMENT = "SELECT document FROM Document document";
	private static final String _SQL_COUNT_DOCUMENT = "SELECT COUNT(document) FROM Document document";
	private static final String _ORDER_BY_ENTITY_ALIAS = "document.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Document exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocumentPersistenceImpl.class);
	private static Document _nullDocument = new DocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Document> toCacheModel() {
				return _nullDocumentCacheModel;
			}
		};

	private static CacheModel<Document> _nullDocumentCacheModel = new CacheModel<Document>() {
			@Override
			public Document toEntityModel() {
				return _nullDocument;
			}
		};
}