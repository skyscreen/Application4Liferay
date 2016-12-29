package com.lenovo.bp.search.portlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SearchPortlet extends MVCPortlet {

	public void doView(RenderRequest actionRequest,
			RenderResponse actionResponse) throws IOException, PortletException {
		try {
			/**New some useful variables:
			 * 
			 * PorletConfig: For getting values from Language.properties;
			 * ThemeDisplay: A Liferay class can get lots of useful objects;
			 * user: Current user;
			 * webId: ID for identify Liferay instance;
			 * company: Current company;
			 * groupId: Global site's ID;
			 * 
			 */
			PortletConfig portletConfig = (PortletConfig) actionRequest
					.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			String webId = CompanyLocalServiceUtil.getCompany(
					themeDisplay.getLayout().getCompanyId()).getWebId();
			Company company = CompanyLocalServiceUtil.getCompanyByWebId(webId);
			long companyId = company.getCompanyId();
//			long groupId = company.getGroup().getGroupId();

			long groupId =  PortalUtil.getScopeGroupId(actionRequest);
			
			
			/**
			 * Get parameters from request
			 */
			
			String renderPage = getInitParameter("view-template");
			HttpServletRequest convertReq = PortalUtil
					.getHttpServletRequest(actionRequest);
			HttpServletRequest originalReq = PortalUtil
					.getOriginalServletRequest(convertReq);

			String keyWords = originalReq
					.getParameter("_emeasearch_WAR_emeasearchportlet_keyWords");
			String tagName = "";
			if (keyWords != null && keyWords.contains(" ")
					&& !keyWords.isEmpty()) {
				keyWords = "\"" + keyWords + "\"";
			}

			if(originalReq.getParameter("_emeasearch_WAR_emeasearchportlet_type") != null){
				String renderPageForDoc = getInitParameter("doc-template");
				String articleId = originalReq.getParameter("_emeasearch_WAR_emeasearchportlet_articleId");
				String type = originalReq.getParameter("_emeasearch_WAR_emeasearchportlet_type");
				
				actionRequest.setAttribute("articleId", articleId);
				actionRequest.setAttribute("type", type);
				include(renderPageForDoc, actionRequest, actionResponse);
			}else{
				String deltaString = originalReq
						.getParameter("_emeasearch_WAR_emeasearchportlet_delta");
				String curString = originalReq
						.getParameter("_emeasearch_WAR_emeasearchportlet_cur");

				if (null == curString || "".equals(curString)) {
					curString = "1";
				}
				if (null == deltaString || "".equals(deltaString)) {
					deltaString = "20";
				}
				Integer delta = Integer.valueOf(deltaString);
				Integer cur = Integer.valueOf(curString);

				Integer start = delta * (cur - 1);
				Integer end = delta * cur;
				String filter = originalReq
						.getParameter("_emeasearch_WAR_emeasearchportlet_category");
				String sort = originalReq
						.getParameter("_emeasearch_WAR_emeasearchportlet_sort");
				if(filter == null){
					filter = "";
				}
				if(sort == null){
					sort = "";
				}
				/**
				 *  New a query for search
				 */
				SearchContext searchContext = new SearchContext();
				BooleanQuery fullQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				/**
				 * 1. Search conditions
				 * Add limitation to the query:search journal article;
				 */
				BooleanQuery entryClassNameQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				entryClassNameQuery.addTerm("entryClassName",
						JournalArticle.class.getName());
				fullQuery.add(entryClassNameQuery, BooleanClauseOccur.MUST);

				/**
				 * 2. Search conditions
				 * Add limitation to the query:search entries with active status;
				 */
				BooleanQuery statusQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				statusQuery.addTerm("status", 0);
				fullQuery.add(statusQuery, BooleanClauseOccur.MUST);
				
				/**
				 * 3. Search conditions
				 * Add limitation to the query:search entries with lastest version;
				 */
				BooleanQuery versionQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				versionQuery.addRequiredTerm("head", Boolean.TRUE);
				fullQuery.add(versionQuery, BooleanClauseOccur.MUST);

				/**
				 * 4. Search conditions
				 * Add limitation to the query:search entries with current site category;
				 * Explanation: Site name equals category name.
				 */
				String groupName = themeDisplay.getLayout().getGroup()
						.getName();
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(
						AssetCategory.class).add(
						PropertyFactoryUtil.forName("name").eq(groupName));
				@SuppressWarnings("unchecked")
				List<AssetCategory> categories = AssetCategoryLocalServiceUtil
						.dynamicQuery(query, 0, 1);
				AssetCategory assetCategory = categories.get(0);

				long countryAssetCategoryId = assetCategory.getCategoryId();

				BooleanQuery countryCategoryQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				countryCategoryQuery.addTerm("assetCategoryIds",
						countryAssetCategoryId);
				fullQuery.add(countryCategoryQuery, BooleanClauseOccur.MUST);

				/**
				 * 5. Search conditions
				 * Add limitation to the query:search entries according to current user's permissions;
				 * Explanation: Add guest role to search query, in case of missing.
				 */
				BooleanQuery userQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				userQuery.addTerm("userId", user.getUserId());
				BooleanQuery roleQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				long[] roleIds = user.getRoleIds();
				Role guestRole = RoleLocalServiceUtil.getRole(companyId, "Guest");
					roleQuery.addTerm("roleId", guestRole.getRoleId());
				for (long roleId : roleIds) {
					roleQuery.addTerm("roleId", roleId);
				}
				userQuery.add(roleQuery, BooleanClauseOccur.MUST);
				fullQuery.add(userQuery, BooleanClauseOccur.MUST);
				
				/**
				 * 6. Search conditions
				 * Add limitation to the query:search entries with assets structure;
				 */
				String NEWS_STRUCTURE = LanguageUtil.get(portletConfig,
						new Locale("en"), "emea.structrue.news");
				String PRODUCTS_STRUCTURE = LanguageUtil.get(portletConfig,
						new Locale("en"), "emea.structrue.products");
				String PRICELIST_STRUCTURE = LanguageUtil.get(portletConfig,
						new Locale("en"), "emea.structrue.pricelist");
				String PROMOTION_STRUCTURE = LanguageUtil.get(portletConfig,
						new Locale("en"), "emea.structrue.promotion");
				String ASSETS_STRUCTURE = LanguageUtil.get(portletConfig,
						new Locale("en"), "emea.structrue.assets");
				String PROGRAM_STRUCTURE = LanguageUtil.get(portletConfig, 
						new Locale("en"), "emea.structrue.program");

				String newsStructureId = getStructureIdByName(NEWS_STRUCTURE,
						groupId);
				String productStructureId = getStructureIdByName(
						PRODUCTS_STRUCTURE, groupId);
				String pricelistStructureId = getStructureIdByName(
						PRICELIST_STRUCTURE, groupId);;
				String promotionStructureId = getStructureIdByName(
						PROMOTION_STRUCTURE, groupId);
				String assetsStructureId = getStructureIdByName(
						ASSETS_STRUCTURE, groupId);
				String programStructureId = getStructureIdByName(
						PROGRAM_STRUCTURE, groupId);
				
				
				BooleanQuery structureQuery = BooleanQueryFactoryUtil
						.create(searchContext);
//				System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+filter);
//				System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+newsStructureId);
				if (filter.equalsIgnoreCase("1")) {
					//System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+newsStructureId);
					structureQuery.addTerm("ddmStructureKey", newsStructureId);
				} else if (filter.equalsIgnoreCase("2")) {
					structureQuery.addTerm("ddmStructureKey",
							productStructureId);
				} else if (filter.equalsIgnoreCase("3")) {
					structureQuery.addTerm("ddmStructureKey",
							pricelistStructureId);
				} else if (filter.equalsIgnoreCase("4")) {
					structureQuery.addTerm("ddmStructureKey",
							promotionStructureId);
				} else if (filter.equalsIgnoreCase("5")) {
					structureQuery
							.addTerm("ddmStructureKey", assetsStructureId);
				}else if (filter.equalsIgnoreCase("6")) {
					structureQuery
					.addTerm("ddmStructureKey", programStructureId);
				}else {
					structureQuery.addTerm("ddmStructureKey", newsStructureId);
					structureQuery.addTerm("ddmStructureKey",
							productStructureId);
					structureQuery.addTerm("ddmStructureKey",
							pricelistStructureId);
					structureQuery.addTerm("ddmStructureKey",
							promotionStructureId);
					structureQuery
							.addTerm("ddmStructureKey", assetsStructureId);
					structureQuery
							.addTerm("ddmStructureKey", programStructureId);
				}
				fullQuery.add(structureQuery, BooleanClauseOccur.MUST);
				
				/**
				 * 7. Search conditions
				 * Add limitation to the query:search entries with related key words;
				 */
				if(keyWords != null && keyWords != ""){
					BooleanQuery keyWordsQuery = BooleanQueryFactoryUtil
							.create(searchContext);
					keyWordsQuery.addTerm(Field.NAME, keyWords);
					keyWordsQuery.addTerm(Field.TITLE, keyWords);
					tagName = originalReq
							.getParameter("_emeasearch_WAR_emeasearchportlet_keyWords");
					if(getAssetTagIdByName(tagName) != 0 ){
						keyWordsQuery.addTerm(Field.ASSET_TAG_IDS, getAssetTagIdByName(tagName));
					}
					fullQuery.add(keyWordsQuery, BooleanClauseOccur.MUST);
				}
				
				/**
				 * Sort search result:
				 * sort1: sort by name A-Z
				 * sort2: sort by name Z-A
				 * sort3: sort by publish date A-Z
				 * sort4: sort by publish date Z-A
				 * 
				 */

				Sort sort1 = new Sort("title_sortable", false);
				Sort sort2 = new Sort("title_sortable", true);
				Sort sort3 = new Sort(Field.PUBLISH_DATE, Sort.LONG_TYPE, false);
				Sort sort4 = new Sort(Field.PUBLISH_DATE, Sort.LONG_TYPE, true);
				Sort sorts = new Sort();
				if (sort.equals("1")) {
					sorts = sort1;
				} else if (sort.equals("2")) {
					sorts = sort2;
				} else if (sort.equals("3")) {
					sorts = sort3;
				} else if (sort.equals("4")) {
					sorts = sort4;
				} else {
					sorts = sort1;
				}
				
				// Get search result
				Hits hits = SearchEngineUtil.search(
						searchContext.getSearchEngineId(), companyId,
						fullQuery, sorts, start, end);
				System.out.println("*******full query -----> " + fullQuery.toString());
				String newsLayoutURL = "";
				String promotionURL = "";
				String programURL = "";
				List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(themeDisplay.getLayout().getGroupId(), false);
	
				for (Layout l : layouts){
					if(l.getFriendlyURL().contains("news-detail")){
						newsLayoutURL = l.getFriendlyURL();
					}
					if(l.getFriendlyURL().contains("promotions-detail")){
						promotionURL = l.getFriendlyURL();
					}
					if(l.getFriendlyURL().contains("programme-detail")){
						programURL = l.getFriendlyURL();
					}
				}
				actionRequest.setAttribute("newsLayoutURL", newsLayoutURL);
				actionRequest.setAttribute("promotionURL", promotionURL);
				actionRequest.setAttribute("programURL", programURL);
				actionRequest.setAttribute("hits", hits);
				actionRequest.setAttribute("keyWords", keyWords);
				actionRequest.setAttribute("filter", filter);
				actionRequest.setAttribute("sort", sort);
				actionRequest.setAttribute("delta", deltaString);
				include(renderPage, actionRequest, actionResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getStructureIdByName(String name, long groupId)
			throws SystemException {
		List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil
				.getStructures(groupId);
		for (DDMStructure ddmStructure : ddmStructures) {
			if (name.equalsIgnoreCase(ddmStructure.getName(Locale.getDefault()))) {
				return ddmStructure.getStructureKey();
			}
		}
		return "0";
	}
	
	private long getAssetTagIdByName(String tagName) throws SystemException{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(
				AssetTag.class).add(
				PropertyFactoryUtil.forName("name").eq(tagName));
		@SuppressWarnings("unchecked")
		List<AssetTag> tags = AssetTagLocalServiceUtil
				.dynamicQuery(query, 0, 1);
		if(tags.size() > 0){
			AssetTag assetTag = tags.get(0);
			return assetTag.getTagId();
		}else{
			return 0;
		}
		
	}
}
