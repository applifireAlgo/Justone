Ext.define('Project1.project1.web.com.view.testproj1boundedcontext.proj.Testpartial', {
     "xtype": "testpartial",
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
          "itemId": "textfield_ext_10141"
     }, {
          "xtype": "checkbox",
          "fieldLabel": "homedelivery",
          "name": "homedelivery",
          "bindable": "homedelivery",
          "margin": 5,
          "text": "homedelivery",
          "fieldName": "homedelivery",
          "displayName": "homedelivery",
          "widget": "checkbox",
          "min": "0",
          "max": "1",
          "isField": true,
          "itemId": "checkbox_ext_10176"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_10127",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Project1.project1.web.com.controller.testproj1boundedcontext.proj.TestpartialController", "Project1.project1.shared.com.viewmodel.testproj1boundedcontext.proj.TestpartialViewModel", "Project1.project1.shared.com.model.testproj1boundedcontext.proj.TestpartialModel"],
     "viewModel": "TestpartialViewModel",
     "controller": "TestpartialController"
});