Ext.define('Project1.project1.web.com.view.appinsight.health.Country1', {
     "xtype": "country1",
     "items": [{
          "xtype": "combo",
          "name": "aaa",
          "margin": 5,
          "bindable": "aaa",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "ComboBox",
          "displayField": "countryName",
          "valueField": "countryId",
          "itemId": "combo_ext_4221",
          "store": {
               "model": "Project1.project1.shared.com.model.organization.locationmanagement.CountryModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "countryName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Country/findAll",
                    "serviceId": "2994D13E-2083-4910-BC2C-C2C26CE9107A",
                    "serviceOperationId": "93AA016D-668F-4AA2-84B4-6795F1586732",
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
     "itemId": "form_ext_4208",
     "dockedItems": [],
     "requires": ["Project1.project1.shared.com.model.organization.locationmanagement.CountryModel", "Project1.project1.web.com.controller.appinsight.health.Country1Controller", "Project1.project1.shared.com.viewmodel.appinsight.health.Country1ViewModel", "Project1.project1.shared.com.model.appinsight.health.Country1Model"],
     "extend": "Ext.form.Panel",
     "viewModel": "Country1ViewModel",
     "controller": "Country1Controller"
});