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

import com.lenovo.bp.search.portlet.NoSuchRoleException;
import com.lenovo.bp.search.portlet.RoleUtil;
import com.lenovo.bp.search.portlet.model.Role;
import com.lenovo.bp.search.portlet.model.impl.RoleImpl;
import com.lenovo.bp.search.portlet.model.impl.RoleModelImpl;

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
 * The persistence implementation for the role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author siyan
 * @see RolePersistence
 * @see RoleUtil
 * @generated
 */
public class RolePersistenceImpl extends BasePersistenceImpl<Role>
	implements RolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RoleUtil} to access the role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RoleModelImpl.ENTITY_CACHE_ENABLED,
			RoleModelImpl.FINDER_CACHE_ENABLED, RoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RoleModelImpl.ENTITY_CACHE_ENABLED,
			RoleModelImpl.FINDER_CACHE_ENABLED, RoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RoleModelImpl.ENTITY_CACHE_ENABLED,
			RoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RolePersistenceImpl() {
		setModelClass(Role.class);
	}

	/**
	 * Caches the role in the entity cache if it is enabled.
	 *
	 * @param role the role
	 */
	@Override
	public void cacheResult(Role role) {
		EntityCacheUtil.putResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
			RoleImpl.class, role.getPrimaryKey(), role);

		role.resetOriginalValues();
	}

	/**
	 * Caches the roles in the entity cache if it is enabled.
	 *
	 * @param roles the roles
	 */
	@Override
	public void cacheResult(List<Role> roles) {
		for (Role role : roles) {
			if (EntityCacheUtil.getResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
						RoleImpl.class, role.getPrimaryKey()) == null) {
				cacheResult(role);
			}
			else {
				role.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Role role) {
		EntityCacheUtil.removeResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
			RoleImpl.class, role.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Role> roles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Role role : roles) {
			EntityCacheUtil.removeResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
				RoleImpl.class, role.getPrimaryKey());
		}
	}

	/**
	 * Creates a new role with the primary key. Does not add the role to the database.
	 *
	 * @param rolePK the primary key for the new role
	 * @return the new role
	 */
	@Override
	public Role create(RolePK rolePK) {
		Role role = new RoleImpl();

		role.setNew(true);
		role.setPrimaryKey(rolePK);

		return role;
	}

	/**
	 * Removes the role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rolePK the primary key of the role
	 * @return the role that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role remove(RolePK rolePK)
		throws NoSuchRoleException, SystemException {
		return remove((Serializable)rolePK);
	}

	/**
	 * Removes the role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role
	 * @return the role that was removed
	 * @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role remove(Serializable primaryKey)
		throws NoSuchRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Role role = (Role)session.get(RoleImpl.class, primaryKey);

			if (role == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(role);
		}
		catch (NoSuchRoleException nsee) {
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
	protected Role removeImpl(Role role) throws SystemException {
		role = toUnwrappedModel(role);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(role)) {
				role = (Role)session.get(RoleImpl.class, role.getPrimaryKeyObj());
			}

			if (role != null) {
				session.delete(role);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (role != null) {
			clearCache(role);
		}

		return role;
	}

	@Override
	public Role updateImpl(com.lenovo.bp.search.portlet.model.Role role)
		throws SystemException {
		role = toUnwrappedModel(role);

		boolean isNew = role.isNew();

		Session session = null;

		try {
			session = openSession();

			if (role.isNew()) {
				session.save(role);

				role.setNew(false);
			}
			else {
				session.merge(role);
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

		EntityCacheUtil.putResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
			RoleImpl.class, role.getPrimaryKey(), role);

		return role;
	}

	protected Role toUnwrappedModel(Role role) {
		if (role instanceof RoleImpl) {
			return role;
		}

		RoleImpl roleImpl = new RoleImpl();

		roleImpl.setNew(role.isNew());
		roleImpl.setPrimaryKey(role.getPrimaryKey());

		roleImpl.setRoleId(role.getRoleId());
		roleImpl.setName(role.getName());
		roleImpl.setUserId(role.getUserId());
		roleImpl.setScreenName(role.getScreenName());

		return roleImpl;
	}

	/**
	 * Returns the role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the role
	 * @return the role
	 * @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRoleException, SystemException {
		Role role = fetchByPrimaryKey(primaryKey);

		if (role == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return role;
	}

	/**
	 * Returns the role with the primary key or throws a {@link com.lenovo.bp.search.portlet.NoSuchRoleException} if it could not be found.
	 *
	 * @param rolePK the primary key of the role
	 * @return the role
	 * @throws com.lenovo.bp.search.portlet.NoSuchRoleException if a role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role findByPrimaryKey(RolePK rolePK)
		throws NoSuchRoleException, SystemException {
		return findByPrimaryKey((Serializable)rolePK);
	}

	/**
	 * Returns the role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role
	 * @return the role, or <code>null</code> if a role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Role role = (Role)EntityCacheUtil.getResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
				RoleImpl.class, primaryKey);

		if (role == _nullRole) {
			return null;
		}

		if (role == null) {
			Session session = null;

			try {
				session = openSession();

				role = (Role)session.get(RoleImpl.class, primaryKey);

				if (role != null) {
					cacheResult(role);
				}
				else {
					EntityCacheUtil.putResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
						RoleImpl.class, primaryKey, _nullRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RoleModelImpl.ENTITY_CACHE_ENABLED,
					RoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return role;
	}

	/**
	 * Returns the role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rolePK the primary key of the role
	 * @return the role, or <code>null</code> if a role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role fetchByPrimaryKey(RolePK rolePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)rolePK);
	}

	/**
	 * Returns all the roles.
	 *
	 * @return the roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.RoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @return the range of roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lenovo.bp.search.portlet.model.impl.RoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of roles
	 * @param end the upper bound of the range of roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role> findAll(int start, int end,
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

		List<Role> list = (List<Role>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROLE;

				if (pagination) {
					sql = sql.concat(RoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Role>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Role>(list);
				}
				else {
					list = (List<Role>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Role role : findAll()) {
			remove(role);
		}
	}

	/**
	 * Returns the number of roles.
	 *
	 * @return the number of roles
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

				Query q = session.createQuery(_SQL_COUNT_ROLE);

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
	 * Initializes the role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lenovo.bp.search.portlet.model.Role")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Role>> listenersList = new ArrayList<ModelListener<Role>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Role>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ROLE = "SELECT role FROM Role role";
	private static final String _SQL_COUNT_ROLE = "SELECT COUNT(role) FROM Role role";
	private static final String _ORDER_BY_ENTITY_ALIAS = "role.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Role exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RolePersistenceImpl.class);
	private static Role _nullRole = new RoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Role> toCacheModel() {
				return _nullRoleCacheModel;
			}
		};

	private static CacheModel<Role> _nullRoleCacheModel = new CacheModel<Role>() {
			@Override
			public Role toEntityModel() {
				return _nullRole;
			}
		};
}