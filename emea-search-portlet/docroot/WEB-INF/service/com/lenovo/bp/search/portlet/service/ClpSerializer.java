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

package com.lenovo.bp.search.portlet.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.lenovo.bp.search.portlet.model.DocumentClp;
import com.lenovo.bp.search.portlet.model.ExtDocumentClp;
import com.lenovo.bp.search.portlet.model.LangContentClp;
import com.lenovo.bp.search.portlet.model.LangTitleClp;
import com.lenovo.bp.search.portlet.model.RoleClp;
import com.lenovo.bp.search.portlet.model.SearchClp;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

/**
 * @author siyan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass("com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get", new Class<?>[] { String.class });

				String portletPropsServletContextName = (String) getMethod.invoke(null,
						"emea-search-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get("emea-search-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				} catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info("Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "emea-search-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DocumentClp.class.getName())) {
			return translateInputDocument(oldModel);
		}

		if (oldModelClassName.equals(RoleClp.class.getName())) {
			return translateInputRole(oldModel);
		}

		if (oldModelClassName.equals(SearchClp.class.getName())) {
			return translateInputSearch(oldModel);
		}

		if (oldModelClassName.equals(ExtDocumentClp.class.getName())) {
			return translateInputExtDocument(oldModel);
		}

		if (oldModelClassName.equals(LangTitleClp.class.getName())) {
			return translateInputLangTitle(oldModel);
		}

		if (oldModelClassName.equals(LangContentClp.class.getName())) {
			return translateInputLangContent(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDocument(BaseModel<?> oldModel) {
		DocumentClp oldClpModel = (DocumentClp) oldModel;

		BaseModel<?> newModel = oldClpModel.getDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRole(BaseModel<?> oldModel) {
		RoleClp oldClpModel = (RoleClp) oldModel;

		BaseModel<?> newModel = oldClpModel.getRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSearch(BaseModel<?> oldModel) {
		SearchClp oldClpModel = (SearchClp) oldModel;

		BaseModel<?> newModel = oldClpModel.getSearchRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputExtDocument(BaseModel<?> oldModel) {
		ExtDocumentClp oldClpModel = (ExtDocumentClp) oldModel;

		BaseModel<?> newModel = oldClpModel.getExtDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	/*
	 * public static Object translateInputLangContent(BaseModel<?> oldModel) {
	 * LangContentClp oldClpModel = (LangContentClp)oldModel;
	 * 
	 * BaseModel<?> newModel = oldClpModel.getLangContentRemoteModel();
	 * 
	 * newModel.setModelAttributes(oldClpModel.getModelAttributes());
	 * 
	 * return newModel; }
	 */

	public static Object translateInputLangTitle(BaseModel<?> oldModel) {
		LangTitleClp oldClpModel = (LangTitleClp) oldModel;

		BaseModel<?> newModel = oldClpModel.getLangTitleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLangContent(BaseModel<?> oldModel) {
		LangContentClp oldClpModel = (LangContentClp) oldModel;

		BaseModel<?> newModel = oldClpModel.getLangContentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>) obj);
		} else if (obj instanceof List<?>) {
			return translateInput((List<Object>) obj);
		} else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.lenovo.bp.search.portlet.model.impl.DocumentImpl")) {
			return translateOutputDocument(oldModel);
		} else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod("getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput", BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass
						.getMethod("get" + oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null, oldRemoteModel);

				return newModel;
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lenovo.bp.search.portlet.model.impl.RoleImpl")) {
			return translateOutputRole(oldModel);
		} else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod("getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput", BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass
						.getMethod("get" + oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null, oldRemoteModel);

				return newModel;
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lenovo.bp.search.portlet.model.impl.SearchImpl")) {
			return translateOutputSearch(oldModel);
		} else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod("getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput", BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass
						.getMethod("get" + oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null, oldRemoteModel);

				return newModel;
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lenovo.bp.search.portlet.model.impl.ExtDocumentImpl")) {
			return translateOutputExtDocument(oldModel);
		} else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod("getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput", BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass
						.getMethod("get" + oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null, oldRemoteModel);

				return newModel;
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lenovo.bp.search.portlet.model.impl.LangTitleImpl")) {
			return translateOutputLangTitle(oldModel);
		} else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod("getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput", BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass
						.getMethod("get" + oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null, oldRemoteModel);

				return newModel;
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lenovo.bp.search.portlet.model.impl.LangContentImpl")) {
			return translateOutputLangTitle(oldModel);
		} else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod("getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput", BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass
						.getMethod("get" + oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null, oldRemoteModel);

				return newModel;
			} catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>) obj);
		} else if (obj instanceof List<?>) {
			return translateOutput((List<Object>) obj);
		} else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(
						unsyncByteArrayOutputStream.unsafeGetByteArray(), 0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable) objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			} catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			} catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.lenovo.bp.search.portlet.NoSuchDocumentException")) {
			return new com.lenovo.bp.search.portlet.NoSuchDocumentException();
		}

		if (className.equals("com.lenovo.bp.search.portlet.NoSuchRoleException")) {
			return new com.lenovo.bp.search.portlet.NoSuchRoleException();
		}

		if (className.equals("com.lenovo.bp.search.portlet.NoSuchSearchException")) {
			return new com.lenovo.bp.search.portlet.NoSuchSearchException();
		}

		return throwable;
	}

	public static Object translateOutputDocument(BaseModel<?> oldModel) {
		DocumentClp newModel = new DocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRole(BaseModel<?> oldModel) {
		RoleClp newModel = new RoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRoleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSearch(BaseModel<?> oldModel) {
		SearchClp newModel = new SearchClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSearchRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputExtDocument(BaseModel<?> oldModel) {
		ExtDocumentClp newModel = new ExtDocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExtDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLangTitle(BaseModel<?> oldModel) {
		LangTitleClp newModel = new LangTitleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLangTitleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLangContent(BaseModel<?> oldModel) {
		LangContentClp newModel = new LangContentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLangContentRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}