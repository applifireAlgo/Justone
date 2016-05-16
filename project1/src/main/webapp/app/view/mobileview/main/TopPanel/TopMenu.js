Ext.define('Project1.view.mobileview.main.TopPanel.TopMenu', { 
	extend: 'Ext.toolbar.Toolbar',
    xtype: 'topMenu',
    requires:['Project1.view.mobileview.main.TopPanel.TopMenuController',/*'Project1.view.mobileview.main.ResourceWindow'*/],
    controller :'topMenuController',
    border:0,
    itemId:'topMenuPanel',
    autoScroll :true,
    items:[]
});