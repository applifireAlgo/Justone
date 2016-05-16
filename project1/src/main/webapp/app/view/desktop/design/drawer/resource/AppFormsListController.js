Ext.define('Project1.view.desktop.design.drawer.resource.AppFormsListController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.appFormsList',
    appFormsList:undefined,
    homeScreenMenuItem:undefined,
    init:function(){
    	this.appFormsList = this.getView();
    },
    onAppFormsListItemClick : function( sender, record, item, index, e, eOpts ){
        var nodedata = record.data;
        if(nodedata.menuId && nodedata.menuAction!==""){
        
         var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
         var clickedAction = appMainTabPanel.down("[menuId='"+nodedata.menuId+"']");

         if(clickedAction){
            appMainTabPanel.setActiveItem(clickedAction);
         }else{


         var addedForm = appMainTabPanel.add(Ext.create(nodedata.menuAction,{
             closable:true,
             title:nodedata.menuName,
             menuId:nodedata.menuId,
        	 refId:nodedata.hasOwnProperty('refId')?nodedata.refId:""
         }));
         appMainTabPanel.setActiveItem(addedForm);
         }
     }
    },
    onDrawerBtnClick : function(drawerBtn){
        var westPanel = Ext.getCmp('westPanel');
        westPanel.setHidden(!westPanel.isHidden());
        var centerPanel = Ext.getCmp('centerPanel');
        centerPanel.setDisabled(!centerPanel.isDisabled());
          
    },
    onAppFormsListAfteRender : function(appFormsList){
       
        var sender = this;
        
        Ext.Ajax.request({
                     url : "secure/MenuService/findMainScreenMenus",
                     method:'POST', 
                     sender:sender,
                     jsonData:{
                     },
                     success : function(response,scope){
                         var sender = scope.sender;
                         var responseJson = Ext.JSON.decode(response.responseText);
                          
                          var data = Ext.decode(responseJson.response.data);
                          
                          sender.configureAppMenu(scope.sender,sender.view.getRootNode(),data.menus,0);
                          sender.pushHomeScreen(data);
                          
                     },
                     failure : function(response,scope){
                       
                       Ext.MessageBox.show({title: 'Error',msg: "Cannot connect to server.",icon: Ext.MessageBox.ERROR});
                     }
                 },sender);     
    },
    pushHomeScreen : function(data){
    	
    	var homescreenlist = data.homeScreenMenus;
		
    	if(homescreenlist) {
    		
				try {
					var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
		            appMainTabPanel.removeAll();
		            
					
					for(var i=0; i < homescreenlist.length; i++) {
						var config = homescreenlist[i];
						var addedtab = appMainTabPanel.add(Ext.create(config.menuAction, {
							closable : false,
							title : config.text,
							refId : config.refId,
							menuid : config.menuId
						}));
						appMainTabPanel.setActiveItem(addedtab);
					}
				} catch(e) {	
					
				}
		}
    },
    configureAppMenu: function(scope,menunode,data,grouper){
        
          for (var i = 0; i <= data.length; i++) {
            var obj = data[i];
            if(obj){
                
                obj['menuGroupName'] = grouper;
                obj['expanded'] = true;
                obj['icon'] = 'none';
                obj['cls'] = grouper==0?"app-menu-tree-folder":obj.leaf?'app-menu-tree-leaf':'app-menu-tree-sub-folder';
                
                var addedNode = menunode.appendChild(obj);
                
                if(obj.children && obj.children.length>0){
                    scope.configureAppMenu(scope,addedNode,obj.children,obj.menuName);
                }
            }
   
          }

    },
    loadAppFormsListStore : function(scope,data,menuName){

        for (var i = 0; i <= data.length; i++) {
            var obj = data[i];
            if(obj){
            if(!obj.hasOwnProperty('children')){
            	obj['formGroupName']=menuName;
                scope.appFormsList.store.add(obj);
                
                if(!scope.homeScreenMenuItem && (obj.menuCommands)){
                	var mCmd = Ext.decode(obj.menuCommands);
                	
                	if(mCmd.homeScreen && mCmd.homeScreen == true)
                	{
                		scope.homeScreenMenuItem = obj;
                	}
                }
            }
            else if(obj.children && obj.children.length>0){
               scope.loadAppFormsListStore(scope,obj.children,obj.menuName);
            }
            }
        }
    }
});
