
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
<%@ page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@ page import="com.liferay.portal.model.Group" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String articleId = request.getParameter("articleId");
	JournalArticle journalArticle = JournalArticleLocalServiceUtil
			.getLatestArticle(Long.parseLong(articleId));
	String type = request.getParameter("type");
	String myContent = journalArticle.getContentByLocale(themeDisplay.getLanguageId());
	com.liferay.portal.kernel.xml.Document document = null;
	document = SAXReaderUtil.read(new StringReader(myContent));
	String title = journalArticle.getTitle(user.getLocale());
	
	
%>
<div>
<%
if(type.equals("1")){
	Node docNode = document.selectSingleNode("/root/dynamic-element[@name='PriceList_T1']/dynamic-content");
	String docURL = docNode.getText();
%>
<h3>
<%=title %>
</h3>
<div>
	<div class="span3">
		<img src="/lenovo-private-theme/images/file_system/large/spreadsheet.png">
	</div>
	<div class="span9">
		<h4>
			<%= title %>
		</h4>
		<%= journalArticle.getDescription() %>
		<a href="<%= docURL%>">
			<img src="/lenovo-private-theme/images/LIST_down.icon.png">
		</a>
	</div>
</div>
<%}else if (type.equals("2")){
	Node docNode = document.selectSingleNode("/root/dynamic-element[@name='Documents_and_Media1619']/dynamic-content");
	String docURL = docNode.getText();
	Node desNode = document.selectSingleNode("/root/dynamic-element[@name='Text_Box2167']/dynamic-content");
	String description = desNode.getText();
	String thumbnailSrc = "";
	if(!"".equals(docURL)){
		String fileUUIDtmp = docURL.split("/")[5];
		String fileUUID = "";
		int endIndex = fileUUIDtmp.indexOf("?");
		if(endIndex != -1){
			fileUUID = fileUUIDtmp.substring(0, endIndex);
		}else{
			fileUUID = fileUUIDtmp;
		}
		if(!"".equals(fileUUID)){
			long companyId = PortalUtil.getCompanyId(renderRequest);
			Group globalGroup = GroupLocalServiceUtil.fetchFriendlyURLGroup(companyId,"/global");
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntryByUuidAndGroupId(fileUUID, globalGroup.getGroupId());
			if(fileEntry!=null){
				thumbnailSrc = DLUtil.getThumbnailSrc(fileEntry,  null, themeDisplay);
			}
		}
	}
%>
<h3>
	<%=title %>
</h3>
<div>
	<div class="span3">
		<img src="<%=thumbnailSrc %>">
	</div>
	<div class="span9" style="border-top: 1px solid #C4BEB6;">
		<h4>
			<%= title %>
		</h4>
		<%= description %>
		<a href="<%= docURL%>">
			<img src="/lenovo-private-theme/images/LIST_down.icon.png">
		</a>
	</div>
</div>
<%}%>
</div>