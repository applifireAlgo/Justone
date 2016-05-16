Ext.define('Project1.view.desktop.design.menubar.menu.AppMenuBarController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.appMenuBar',
    appMenuBar:undefined,
    homeScreenMenuItem:undefined,
    init:function(){
    	this.appMenuBar = this.getView();
    },
    onAppMenuBarItemClick : function(  menuitem,e){
        menuitem.up('button').menu.hide();
        var nodedata = menuitem.config;

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
    displayUserDetail:function(appMenuBar)
    {
        //Get user cookie value set from angular js loginController
         var userNameDField =  Ext.getCmp('userNameDField');
        
        var cookieUserInfo = Ext.util.Cookies.get('userInfo');
        if(cookieUserInfo==null){
            var pathName=location.pathname;
            var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
            location.href=location.origin+initialPath+"/";
        }
        userNameDField.setValue("Welcome "+decodeURI(cookieUserInfo));
         
    
    },
    onMenuBarAfterRender : function(appMenuBar){
       
        var sender = this;
        
        //this.displayUserDetail(appMenuBar);
        Ext.Ajax.request({
                     url : "secure/MenuService/findMainScreenMenus",
                     method:'POST', 
                     sender:sender,
                     jsonData:{
                     },
                     success : function(response,scope){
                    	 var scope = scope.sender;
                         var responseJson = Ext.JSON.decode(response.responseText);
                          
                          var data = Ext.decode(responseJson.response.data);
                          
                          scope.configureAppMenu(scope,data.menus);
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
    configureAppMenu: function(scope,menus){
        var menubar = scope.view;
            for (var i = 0; i < menus.length; i++) {
              
               var mObj = menus[i];
               var menuItems = scope.formAppMenuJson(scope,scope.view,menus[i],true);
                           
               menubar.add({
                text:"<span class='menu-bar-item-cls'><b>"+mObj.menuName+"</b></span>",
                height:35,
                menu:{
                                title:"",
                                shrinkWrap:3,
                                items:menuItems,
                                layout:'hbox',
                                bodyPadding:10,
                                maxHeight:600,
                                autoScroll:true,
                                defaults:{
                                    layout:'hbox', flex:1
                                },
                                floating:true
                            }
               });
            }  
    },
    formAppMenuJson : function(scope,menubar,menuitem,isHeader){
       
        var allNodes = new Array();
        if( menuitem.hasOwnProperty('children') && menuitem.children.length>0){
            var allChild= new Array();
              for (var i = 0; i <menuitem.children.length; i++) {
                   var child = menuitem.children[i];
                   allChild = allChild.concat(scope.formAppMenuJson(scope,menubar,child,false));
                }  
           allNodes = allNodes.concat({
                config:menuitem,
                //menu:allChild,
                items:allChild,
                xtype:'panel',
                bodyPadding:5,
                header:{hidden:true},
                tbar:[{xtype:'displayfield',value:menuitem.menuName,hidden:isHeader?true:false,fieldCls:'menu-bar-item-header-cls'}],
                margin:10,
                autoScroll:false,
                title:isHeader?"":menuitem.menuName,
             });

        }else{

            return {
                value:menuitem.menuName,
                xtype:'displayfield',
                config : menuitem,
                fieldCls:'menu-bar-inner-item-cls',
                overCls:'menu-bar-inner-item-over-cls',
                listeners:{
                    afterrender :function(menuitem){
                        
                        menuitem.el.on('click',function(el){
                            
                            scope.onAppMenuBarItemClick(this.component,el);
                        });
                        
                    },
                    click:'onAppMenuBarItemClick'
                }
            };
        }
        return allNodes;
    },
    configureStandardAppMenu: function(scope,menus){

            for (var i = 0; i < menus.length; i++) {
                scope.formAppMenuJson(scope,scope.view,menus[i],true);
            }  
    },
    formStandardAppMenuJson : function(scope,menubar,menuitem,isHeader){
       
        var allNodes = new Array();
        if( menuitem.hasOwnProperty('children') && menuitem.children.length>0){
            var allChild= new Array();
              for (var i = 0; i <menuitem.children.length; i++) {
                   var child = menuitem.children[i];
                   allChild = allChild.concat(scope.formAppMenuJson(scope,menubar,child,false));
                }  
           allNodes = allNodes.concat({
                config:menuitem,
                menu:allChild,
                height:38,
                text: isHeader?"<span class='menu-bar-item-cls'><b>"+menuitem.menuName+"</b></span>":menuitem.menuName
           });
           if(isHeader){
                menubar.add(allNodes);
           }

        }else{
            return {
                text:menuitem.menuName,
                config : menuitem,
                height:38,
                listeners:{
                    click:'onAppMenuBarItemClick'
                }
            };
        }
        return allNodes;
    }
    
});
