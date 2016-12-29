<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ page import="java.util.Locale"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
	List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.getStructures(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(JournalArticle.class), -1,-1);
	List<String> ddmStructuresList = new ArrayList<String>();
	for (int k = 0; k < ddmStructures.size(); k++) {
		String structureId = String.valueOf(ddmStructures.get(k).getStructureId());
		ddmStructuresList.add(structureId);
	}
	
	PortletPreferences prefs = renderRequest.getPreferences();
	String selectDdm = prefs.getValue("selectDdm", "");
	List<String> structrueNamesList = new ArrayList<String>();
	if(selectDdm!=null&&!selectDdm.equals("")){
	String structrueNames[] = selectDdm.split(",");
	
	for(int i=0;i<structrueNames.length;i++){
		structrueNamesList.add(structrueNames[i]);
	}
	}
	List<String> structrueNameList = new ArrayList<String>();
	for(int i= 0;i<structrueNamesList.size();i++){
		DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getDDMStructure(Long.valueOf(structrueNamesList.get(i)));
		String ddmStructureName = ddmStructure.getName(Locale.getDefault());
		structrueNameList.add(ddmStructureName);
	}
	/* for(int i=0;i<structrueNameList.size();i++){
		System.out.println(structrueNameList.get(i));
	} */
	
	
	
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<h2>Select StructrueNames</h2>
<aui:form name="structruesConfigurationForm" action="<%=configurationURL%>" method="post">
<aui:input type="hidden" name="selectDdm" id="selectDdm"/>
		<liferay-ui:message key="structrueNames:" />
		</br></br>
		<input type="checkbox" name="structrue" onchange="check_all(this,'<portlet:namespace />structrue');"/>
		<a href="#">checkAll/unCheckAll</a>
		</br></br>
		<%
		
			for (int k = 0; k < ddmStructures.size(); k++) {
				String checked=structrueNamesList.contains(String.valueOf(ddmStructures.get(k).getStructureId()))?"checked":"";
		%>
				<aui:column>
					<input type="checkbox" name="<portlet:namespace />structrue" value=<%=ddmStructures.get(k).getStructureId() %> <%=checked %> ><%=ddmStructures.get(k).getName() %></input>
				</aui:column>
		<%
			}
		%>
		</br></br></br>
	<aui:button-row>
		<aui:button type="button"  onClick="submitForm()" value="submit"/>
	</aui:button-row>
</aui:form>

<script>


function submitForm(){
	var selectDmm="";
	var ss=document.getElementsByName("<portlet:namespace />structrue");
	for(i=0;i<ss.length;i++){
		if(ss[i].checked){
			selectDmm+=ss[i].value+",";
		}
		
	}
	document.getElementById("<portlet:namespace />selectDdm").value=selectDmm;
	document.getElementById("<portlet:namespace />structruesConfigurationForm").submit();
}
function check_all(obj, cName) {  
  var checkboxs = document.getElementsByName(cName);  
  for ( var i = 0; i < checkboxs.length; i+=1) {  
    checkboxs[i].checked = obj.checked;  
  }  
}  
</script>