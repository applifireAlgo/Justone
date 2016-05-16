Ext.define('Project1.project1.web.com.view.appinsight.health.TestCombi', {
     "xtype": "testCombi",
     "items": [{
          "xtype": "combo",
          "name": "testCombo",
          "margin": 5,
          "bindable": "testCombo",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "ComboBox",
          "displayField": "addressLabel",
          "valueField": "addressId",
          "itemId": "combo_ext_4049",
          "store": {
               "model": "Project1.project1.shared.com.model.organization.locationmanagement.AddressModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "addressLabel",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Address/findAll",
                    "serviceId": "CCED952C-6105-4E8B-A562-77014B039C8F",
                    "serviceOperationId": "66F3DB03-9421-49D9-8F54-806B33ACA167",
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
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_3894",
     "dockedItems": [],
     "requires": ["Project1.project1.shared.com.model.organization.locationmanagement.AddressModel", "Project1.project1.web.com.controller.appinsight.health.TestCombiController", "Project1.project1.shared.com.viewmodel.appinsight.health.TestCombiViewModel", "Project1.project1.shared.com.model.appinsight.health.TestCombiModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "TestCombiViewModel",
     "controller": "TestCombiController"
});