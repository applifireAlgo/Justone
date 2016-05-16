Ext.define('Project1.view.desktop.design.menubar.main.MainPanelController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.mainPanel',
   
    onMainPanelAfterRender : function(mainPanel){
        
        this.initializeGoogleMap();
        mainPanel.getEl().on('contextmenu', function(view) {
                       view.stopEvent();
        });


    },
    initializeGoogleMap : function(){
        var googleScript = document.createElement('script');
        googleScript.setAttribute("type","text/javascript");
        googleScript.setAttribute("src", "https://maps.googleapis.com/maps/api/js?v=3.18");
        document.body.appendChild(googleScript);
    },
  
    onDrawerBtnClick : function(drawerBtn){
        var westPanel = Ext.getCmp('westPanel');
        westPanel.setHidden(!westPanel.isHidden());
    },
    
    onMyProfileClick : function()
    {
        
         this.pushViewInMainTab( "Project1.view.usermanagement.enduser.UserProfile","My Profile","menuAction","Project1.view.usermanagement.enduser.UserProfile");
    },
    
    onChangePwdClick:function()
    {
      
         this.pushViewInMainTab( "Project1.view.usermanagement.enduser.ChangePwd","Change Password","menuAction","Project1.view.usermanagement.enduser.ChangePwd");
    },
     onCloudClick : function()
    {
        
        this.pushViewInMainTab("Project1.view.clouddrive.CloudDrive","Cloud Drive","menuAction","Project1.view.clouddrive.CloudDrive");
    },
    pushViewInMainTab : function(className,title,cmpKey,cmpValue){
        var appMainTabPanel = Ext.getCmp('appMainTabPanel');
        if(className){
        var ident= {};
          ident[cmpKey]=cmpValue;

         var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
         var clickedAction = appMainTabPanel.down("["+cmpKey+"='"+cmpValue+"']");
         
         if(clickedAction){
            appMainTabPanel.setActiveItem(clickedAction);
            return clickedAction;
         }else{
        
         var addedForm = appMainTabPanel.add(Ext.create(className,{
             closable:true,
             title:title,
             menuAction:className,
             cmpKey:cmpValue
            
         }));
         Ext.merge(addedForm,ident);
         appMainTabPanel.setActiveItem(addedForm);
         return addedForm;
         }
     }
    },

    onLogoutClick : function(logoutBtn)
    {
        Ext.Ajax.request({
            url : "secure/Logout",
            method : 'POST',
            jsonData : {},
            success : function(response, scope) {
                
                var jsonRespone = Ext.JSON.decode(response.responseText);
                if (jsonRespone.response.success == "true") {
                    //this.location.reload();
                    var pathName=this.location.pathname;
                    var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
                    
                    Ext.util.Cookies.clear('changePwd',initialPath);
                    
                    this.location.href=this.location.origin+initialPath+"/";
                } else {
                    Ext.Msg.alert('Logout failed',jsonRespone.response.message);
                }
            },
            failure : function() {
                Ext.Msg.alert('Error', 'Cannot connect to server');
            }
        });
    }
   
});
