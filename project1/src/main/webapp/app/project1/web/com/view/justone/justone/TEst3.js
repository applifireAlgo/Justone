Ext.define('Project1.project1.web.com.view.justone.justone.TEst3', {
     "xtype": "tEst3",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "pk",
          "margin": 5,
          "bindable": "pk",
          "name": "pk",
          "text": "pk",
          "fieldName": "pk",
          "displayName": "pk",
          "widget": "textfield",
          "isField": true,
          "itemId": "textfield_ext_3709"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Twooo",
          "margin": 5,
          "bindable": "testTwo",
          "name": "testTwo",
          "text": "Twooo",
          "fieldName": "testTwo",
          "displayName": "Twooo",
          "widget": "textfield",
          "min": "1",
          "max": "256",
          "isField": true,
          "itemId": "textfield_ext_3718"
     }, {
          "xtype": "combo",
          "name": "aaPk",
          "margin": 5,
          "bindable": "aaPk",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Entity A",
          "displayField": "pkOne",
          "valueField": "pk",
          "text": "Entity A",
          "fieldName": "aaPk",
          "displayName": "Entity A",
          "widget": "combo",
          "min": "1",
          "max": "256",
          "isField": true,
          "itemId": "combo_ext_3729",
          "store": {
               "model": "Project1.project1.shared.com.model.justone.justone.EntityAModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "pkOne",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/EntityA/findAll",
                    "serviceId": "599FA190-F85C-4FF6-B714-F452DC37FA7B",
                    "serviceOperationId": "6FB7E717-5B3D-464A-83F5-A2E2A7F9F608",
                    "serviceType": 1,
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "numberfield",
          "fieldLabel": "versionId",
          "name": "versionId",
          "margin": 5,
          "bindable": "versionId",
          "text": "versionId",
          "fieldName": "versionId",
          "displayName": "versionId",
          "widget": "numberfield",
          "isField": true,
          "itemId": "numberfield_ext_3742"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_3683",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Project1.project1.shared.com.model.justone.justone.EntityAModel", "Project1.project1.web.com.controller.justone.justone.TEst3Controller", "Project1.project1.shared.com.viewmodel.justone.justone.TEst3ViewModel", "Project1.project1.shared.com.model.justone.justone.TEst3Model"],
     "viewModel": "TEst3ViewModel",
     "controller": "TEst3Controller"
});