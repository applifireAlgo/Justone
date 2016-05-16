Ext.define('Project1.view.mainleftmenutree.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainPanelWithLeftMenu',
	requires : [ 'Project1.view.resource.ResourcePanel',
	             'Project1.view.mainleftmenutree.TopPanel.TopPanel',
	             'Project1.view.resource.DockedResourcePanel',
	             'Project1.view.fw.mainViewPanel.MainPanelController'
	           ],
	controller:'mainViewPanelController',
	layout : 'border',
	items : [{
		    	region: 'west',
		        xtype: 'resourcePanel',
				placeholder : {
					xtype : 'dockedResourcePanel'
				},		
				placeholderCollapseHideMode : Ext.Element.DISPLAY, 
				collapsible : true,
				hideCollapseTool : true,
				titleCollapse : true
				
			}, {
		        region: 'center',
		        xtype: 'tabpanel',
		        itemId : 'appMainTabPanel',
				id : 'appMainTabPanel',
		        dockedItems : [{
					xtype : 'menuTopPanel'
				}],
				listeners:{
					afterrender:'aftrAppMainTabPanelRender'
				}
			}],
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	}
});
