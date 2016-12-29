package com.lenovo.bp.configuration.impl;


import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;


/**
 * This class is used to store portlet's preference
 * 
 * @author shi.w.an
 *
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	private static final Log LOG = LogFactory.getLog(ConfigurationActionImpl.class);
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		String selectDdm = ParamUtil.getString(actionRequest, "selectDdm");
		PortletPreferences prefs = actionRequest.getPreferences();
		
		if(prefs != null){
			if(selectDdm != null){
				prefs.setValue("selectDdm", selectDdm);
				LOG.debug("preference selectDdm:" + selectDdm);
			}
			prefs.store();
		}
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
