
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
 String pAuth = com.liferay.portal.security.auth.AuthTokenUtil.getToken(request);
 out.println("pAuth:"+pAuth);
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
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
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
<%@ page
	import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="java.util.Locale"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String keyWords = "";
	String filter = "0";
	String sort = "1";
	String delta = "5";
	int num = 5;
	Hits hits = (Hits) request.getAttribute("hits");
	List<Document> entries = new ArrayList<Document>();
	if (request.getAttribute("keyWords") != null){
		keyWords = (String) request.getAttribute("keyWords");
		if(keyWords.contains(" ")){
			keyWords = keyWords.substring(1, keyWords.length()-1);
		}
	}
	if (request.getAttribute("filter") != null){
		filter = (String) request.getAttribute("filter");
	}
	if (request.getAttribute("sort") != null){
		sort = (String) request.getAttribute("sort");
	}
	if (request.getAttribute("delta") != null){
		delta = (String) request.getAttribute("delta");
		num = Integer.parseInt(delta);
	}
	
	
	//get checked structures from configuration
	PortletPreferences prefs = renderRequest.getPreferences();
	String selectDdm = prefs.getValue("selectDdm", "");
	String structrueNames[] = selectDdm.split(",");
	List<String> structrueNamesList = new ArrayList<String>();
	for(int i=0;i<structrueNames.length;i++){
		structrueNamesList.add(structrueNames[i]);
	}
	//out.println("====================================="+structrueNamesList.size());
	List<String> structrueNameList = new ArrayList<String>();
	for(int i= 0;i<structrueNamesList.size();i++){
		if (!structrueNamesList.get(i).trim().equals("")){
		DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getDDMStructure(Long.valueOf(structrueNamesList.get(i)));
		String ddmStructureName = ddmStructure.getName(Locale.getDefault());
		structrueNameList.add(ddmStructureName);
		}
	}
	
	/*
	 for(int i=0;i<structrueNameList.size();i++){
		System.out.println(structrueNameList.get(i));
	} 
	 */

%>
<input id="portletId" type="hidden"
	value="<%=themeDisplay.getPortletDisplay().getId() %>" />

<div
	style="border: 1px solid #C4BEB6; padding-top: 20px; padding-left: 100px;">

	<aui:input id="keywordsArea" inlineLabel="left" name="keyWords"
		label="Search again:" value="<%= keyWords%>" />
	<br/>
	<aui:select id="filterArea" inlineLabel="left" name="category"
		label="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspFilter by:">
		<option value="0" selected="selected">Select</option>
		<%
			for(int i=0;i<structrueNameList.size();i++){
				String structrueName = structrueNameList.get(i);
				String filter1 = "";
				if(structrueName.equals("News Content")){
					filter1 = "1";
				}else if(structrueName.equals("Product With Downloads")){
					filter1 = "2";
				}else if(structrueName.equals("Price List Content")){
					filter1 = "3";
				}else if(structrueName.equals("Promotion Content")){
					filter1 = "4";
				}else if(structrueName.equals("AssetsSearchStructure")){
					filter1 = "5";
				}else if(structrueName.equals("Programme Content Structure")){
					filter1 = "6";
				}
				
		%>
			<option value="<%=filter1 %>" <%if(filter.equals(filter1)){%>selected="selected"<%} %>><%=structrueNameList.get(i) %></option>
		<%
			}
		%>
		
	</aui:select>
	<br/>
	<aui:select id="sortArea" inlineLabel="left" name="sort"
		label="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSort by:">
		<%if(sort.equals("1")){ %>
		<option value="1" selected="selected">name A-Z</option>
		<%}else{ %>
		<option value="1">name A-Z</option>
		<%} %>
		<%if(sort.equals("2")){ %>
		<option value="2" selected="selected">name Z-A</option>
		<%}else{ %>
		<option value="2">name Z-A</option>
		<%} %>
		<%if(sort.equals("3")){ %>
		<option value="3" selected="selected">date A-Z</option>
		<%}else{ %>
		<option value="3">date A-Z</option>
		<%} %>
		<%if(sort.equals("4")){ %>
		<option value="4" selected="selected">date Z-A</option>
		<%}else{ %>
		<option value="4">date Z-A</option>
		<%} %>
	</aui:select>
	<aui:button-row>
		<aui:button style="width:200px;" name="submitButton" type="submit" value="Search"
			cssClass="btn-primary"
			onClick='<%=renderResponse.getNamespace() + "doSearch();"%>' />
	</aui:button-row>

</div>
<%if(hits != null && hits.getLength() > 0){ %>
<div style="margin-bottom: 20px;">
	<br/>
	<h4>Search Result:</h4>
	<%
	String[] queryTerms = new String [1];
	if (keyWords.contains(" ")){
		queryTerms = keyWords.split(" ");
	}else{
		queryTerms[0] = keyWords;
	}
	
%>

	<% for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);
		entries.add(doc);
		long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
		long resourcePrimKey = GetterUtil.getLong(doc.get(Field.ROOT_ENTRY_CLASS_PK));
		if (resourcePrimKey > 0) {
			classPK = resourcePrimKey;
		}
		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(classPK);
		String title = journalArticle.getTitle(user.getLocale());
		journalArticle.getStructureId();
		
%>

	<%}%>
	<%
  	PortletURL iteratorportletURL =  PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	iteratorportletURL.setWindowState(LiferayWindowState.NORMAL);
	iteratorportletURL.setPortletMode(LiferayPortletMode.VIEW);
%>

	<liferay-ui:search-container delta="<%= num %>"
		emptyResultsMessage="Nothing Found.">
		<liferay-ui:search-container-results total="<%= hits.getLength() %>"
			results="<%= entries %>" />
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.search.Document"
			escapedModel="<%= false %>" keyProperty="UID" modelVar="document"
			stringKey="<%= true %>">
			<liferay-ui:search-container-column-jsp path="/html/result.jsp" />
		</liferay-ui:search-container-row>
		<%
				iteratorportletURL.setParameter("_delta", String.valueOf(delta));
				if (sort != null && !sort.equals("")) {
					iteratorportletURL.setParameter("_emeasearch_WAR_emeasearchportlet_sort", sort);	
				}
				if (filter  != null && !filter .equals("")) {
					iteratorportletURL.setParameter("_emeasearch_WAR_emeasearchportlet_category", filter);	
				}
				if (keyWords != null && !keyWords.equals("")) {
					iteratorportletURL.setParameter("_emeasearch_WAR_emeasearchportlet_keyWords", keyWords);	
				}
				iteratorportletURL.setParameter("javax.portlet.render", "doView");	
				searchContainer.setIteratorURL(iteratorportletURL);  
				%>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	</liferay-ui:search-container>
</div>
<%}else{ %>
<div class="alert alert-warning" style="margin-top: 20px;">
Nothing Found!
</div>

<%} %>

<aui:script use="liferay-portlet-url">
Liferay.provide(
  window,
  '<portlet:namespace />doSearch',
  function() {
  		var keyWords = document.getElementById("_emeasearch_WAR_emeasearchportlet_keywordsArea").value;
  		var filter = document.getElementById("_emeasearch_WAR_emeasearchportlet_filterArea").value;
  		var sort = document.getElementById("_emeasearch_WAR_emeasearchportlet_sortArea").value;
		var portletId = document.getElementById("portletId").value;
		var renderURL = Liferay.PortletURL.createRenderURL();
		renderURL.setPortletId(portletId);
		if(keyWords != null && keyWords!= ""){
			renderURL.setParameter("keyWords", keyWords);
		}
		if(filter != null && filter!= ""){
			renderURL.setParameter("category", filter);
		}
		if(sort != null && sort!= ""){
			renderURL.setParameter("sort", sort);
		}
		window.location.href = renderURL.toString();
   }
  );
</aui:script>





