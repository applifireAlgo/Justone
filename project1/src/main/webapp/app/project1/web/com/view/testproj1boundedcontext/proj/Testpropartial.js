Ext.define('Project1.project1.web.com.view.testproj1boundedcontext.proj.Testpropartial', {
     "xtype": "testpropartial",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "itemName",
          "margin": 5,
          "bindable": "itemname",
          "name": "itemname",
          "text": "itemName",
          "fieldName": "itemname",
          "displayName": "itemName",
          "widget": "textfield",
          "min": "1",
          "max": "255",
          "isField": true,
          "itemId": "textfield_ext_1316"
     }, {
          "items": [{
               "name": "filePathHidden",
               "xtype": "hidden",
               "itemId": "filePathHidden"
          }, {
               "title": "itemIcon",
               "xtype": "fileupload",
               "name": "itemicon",
               "border": 2,
               "margin": 5,
               "fieldLabel": "itemIcon",
               "bindable": "itemicon",
               "text": "itemIcon",
               "fieldName": "itemicon",
               "displayName": "itemIcon",
               "widget": "fileupload",
               "isField": true,
               "itemId": "fileupload_ext_1325"
          }]
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "dockedItems": [],
     "itemId": "form_ext_1304",
     "extend": "Ext.form.Panel",
     "requires": ["Project1.project1.web.com.controller.testproj1boundedcontext.proj.TestpropartialController", "Project1.project1.shared.com.viewmodel.testproj1boundedcontext.proj.TestpropartialViewModel", "Project1.project1.shared.com.model.testproj1boundedcontext.proj.TestpropartialModel", "Project1.view.fw.component.FileUploadComponent"],
     "viewModel": "TestpropartialViewModel",
     "controller": "TestpropartialController"
});