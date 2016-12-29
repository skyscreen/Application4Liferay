
<%@page import="sun.rmi.runtime.NewThreadAction"%>
<%
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
%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.TreeSet"%>
<%@ page import="java.io.StringReader"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page
	import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.search.Hits"%>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@ page import="com.liferay.portal.kernel.xml.Element"%>
<%@ page import="com.liferay.portal.kernel.xml.Node"%>
<%@ page import="com.liferay.portal.kernel.search.Document"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.search.Field"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@ page
	import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page
	import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@ page
	import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@ page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.asset.model.AssetCategory" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
.search-result a:HOVER {
	text-decoration: none;
	font-size: 20px;
	color:#3E8DDD;
}
.search-result a{
	text-decoration: none;
	font-size: 20px;
	color: #4AC0E0;
}

</style>

<%
	String keyWords = "";
	if (request.getAttribute("keyWords") != null) {
		keyWords = (String) request.getAttribute("keyWords");
		if (keyWords.contains(" ")) {
			keyWords = keyWords.substring(1, keyWords.length() - 1);
		}
	}
	
	String newsURL = "";
	if(request.getAttribute("newsLayoutURL") != null){
		newsURL = (String) request.getAttribute("newsLayoutURL");
	}
	
	String promotionURL = "";
	if(request.getAttribute("promotionURL") != null){
		promotionURL = (String) request.getAttribute("promotionURL");
	}
	
	String programURL = "";
	if(request.getAttribute("programURL") != null){
		programURL = (String) request.getAttribute("programURL");
	}
	
	String[] queryTerms = new String[1];
	if (keyWords.contains(" ")) {
		queryTerms = keyWords.split(" ");
	} else {
		queryTerms[0] = keyWords;
	}
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Document document = (Document) row.getObject();
	long groupId = GetterUtil.getLong(document.get(Field.GROUP_ID));
	long classPK = GetterUtil.getLong(document
			.get(Field.ENTRY_CLASS_PK));
	long resourcePrimKey = GetterUtil.getLong(document
			.get(Field.ROOT_ENTRY_CLASS_PK));
	if (resourcePrimKey > 0) {
		classPK = resourcePrimKey;
	}
	JournalArticle journalArticle = JournalArticleLocalServiceUtil
			.getLatestArticle(classPK);
	String articleId = journalArticle.getArticleId();
	String title = journalArticle.getTitle(user.getLocale());
	String summary = journalArticle.getDescription(user.getLocale());
	String structureId = journalArticle.getStructureId();
	DDMStructure curStructure = DDMStructureLocalServiceUtil
			.getStructure(groupId, ClassNameLocalServiceUtil
					.getClassNameId(JournalArticle.class.getName()),
					structureId);
	String structureName = curStructure.getName();
	String[] assetCategoryIds = document.getValues(Field.ASSET_CATEGORY_IDS);
	String portletId = document.get(Field.PORTLET_ID);
	String category = "";
	String URL = "";
	String curGroupURL = "/web" + themeDisplay.getLayout().getGroup().getFriendlyURL();
	if (structureName.contains("News")) {
		category = "News";
		URL = curGroupURL + newsURL + "?article=" + articleId;
	} else if (structureName.contains("Product")) {
		AssetCategory curSearchCategory = null;
		for(String documentAssetCategoryId:assetCategoryIds){
			AssetCategory ac = AssetCategoryLocalServiceUtil.getAssetCategory(Long.valueOf(documentAssetCategoryId));
			if("content".equalsIgnoreCase(ac.getName())){
				curSearchCategory = ac;
				break;
			}
		}
		if(curSearchCategory!=null){
			try{
				Long productCategoryId = curSearchCategory.getParentCategoryId();
				AssetCategory productContentCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.valueOf(productCategoryId));
				String productpath = "/" + productContentCategory.getName().toLowerCase().replaceAll(" & ","-").replaceAll(" ", "-");
				
				Long productBigCategoryId = productContentCategory.getParentCategoryId();
				AssetCategory productBigCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.valueOf(productBigCategoryId));
				String productBigPath = "/" + productBigCategory.getName().toLowerCase().replaceAll(" & ","-").replaceAll(" ", "-");
				
				Long productSummaryCategoryId = productBigCategory.getParentCategoryId();
				AssetCategory productSummaryCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.valueOf(productSummaryCategoryId));
				String productSummaryPath = "/" + productSummaryCategory.getName().toLowerCase().replaceAll(" & ","-").replaceAll(" ", "-");
				URL = curGroupURL+"/products"+productSummaryPath+productBigPath+productpath;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		category = "Product";
		
	} else if (structureName.contains("Price")) {
		category = "PriceList";
		PortletURL renderURL = renderResponse.createRenderURL();
		renderURL.setWindowState(LiferayWindowState.NORMAL);
		renderURL.setPortletMode(LiferayPortletMode.VIEW);
		renderURL.setParameter("type", "1");
		renderURL.setParameter("articleId", String.valueOf(classPK));
		renderURL.setParameter("keyWords", keyWords);
		URL = renderURL.toString();
	} else if (structureName.contains("Promotion")) {
		category = "Promotion";
		URL = curGroupURL + promotionURL + "?article=" + articleId;
	} else if (structureName.contains("Asset")) {
		category = "Sales & Marketing Asset";
		PortletURL renderURL = renderResponse.createRenderURL();
		renderURL.setWindowState(LiferayWindowState.NORMAL);
		renderURL.setPortletMode(LiferayPortletMode.VIEW);
		renderURL.setParameter("type", "2");
		renderURL.setParameter("keyWords", keyWords);
		renderURL.setParameter("articleId", String.valueOf(classPK));
		URL = renderURL.toString();
	}else if (structureName.contains("Programme")) {
		category = "Programme";
		URL = curGroupURL + programURL + "?article=" + articleId;
	}
%>

<div class="search-result">
	<div style="width:80%; float:left; text-align:left;">
		<a target="_blank" href="<%= URL%>">
			<%=StringUtil.highlight(HtmlUtil.escape(title), queryTerms)%>
		</a>
	</div>
	<div style="width:20%; float:left; text-align:right; color:#6F7170; font-size: 12px;">
		<%=category%>
	</div>
	<div style="clear:both;"></div>
	<div style="color:#6F7170; font-size: 14px;">
		<%=StringUtil.highlight(HtmlUtil.escape(summary), queryTerms)%>
	</div>
</div>
