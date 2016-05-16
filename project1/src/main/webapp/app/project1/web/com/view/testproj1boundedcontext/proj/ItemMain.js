Ext.define('Project1.project1.web.com.view.testproj1boundedcontext.proj.ItemMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ItemMainController",
     "restURL": "/Item",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.testproj1boundedcontext.proj.ItemModel", "Project1.project1.web.com.controller.testproj1boundedcontext.proj.ItemMainController", "Project1.view.fw.component.FileUploadComponent", "Project1.project1.shared.com.viewmodel.testproj1boundedcontext.proj.ItemViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "item",
               "name": "ItemTreeContainer",
               "itemId": "ItemTreeContainer",
               "restURL": "/Item",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ItemTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "item",
                    "title": "item",
                    "name": "Item",
                    "itemId": "ItemForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "itemid",
                         "itemId": "itemid",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "itemid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemid<font color='red'> *<\/font>",
                         "fieldId": "9EC676B0-37AC-43D5-9253-CA3D6C2125D2",
                         "hidden": true,
                         "value": "",
                         "bindable": "itemid"
                    }, {
                         "name": "itemname",
                         "itemId": "itemname",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "itemName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "66B84390-E8E8-4E7F-8F32-F89CCA8DF699",
                         "minLength": "1",
                         "maxLength": "255",
                         "bindable": "itemname",
                         "columnWidth": 0.5
                    }, {
                         "name": "price",
                         "itemId": "price",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "itemPrice",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemPrice<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "93CA7022-0B39-4403-9002-10A687A0C5FA",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "price",
                         "columnWidth": 0.5
                    }, {
                         "items": [{
                              "name": "filePathHidden",
                              "xtype": "hidden",
                              "itemId": "filePathHidden"
                         }, {
                              "name": "itemicon",
                              "itemId": "itemicon",
                              "xtype": "fileupload",
                              "customWidgetType": "vdFileUpload",
                              "displayName": "itemIcon",
                              "margin": "5 5 5 5",
                              "fieldLabel": "itemIcon<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "93D07316-857C-466F-8DBA-1FC10C1639F7",
                              "bindable": "itemicon",
                              "columnWidth": 0.5
                         }]
                    }, {
                         "name": "quantity",
                         "itemId": "quantity",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "itemQuantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemQuantity<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "ABE4BC5F-BAAC-4A2E-9DE0-02560FE7A6DD",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "quantity",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemsize",
                         "itemId": "itemsize",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "itemSize",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemSize<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "84E1254E-87FC-43AB-84B9-4760B36B115D",
                         "minLength": "1",
                         "maxLength": "4",
                         "bindable": "itemsize",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemorderdate",
                         "itemId": "itemorderdate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "itemOrderdate",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "itemOrderdate<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7A48CE16-7A8C-4078-AB2D-1D1218196AE5",
                         "bindable": "itemorderdate",
                         "columnWidth": 0.5
                    }, {
                         "name": "homedelivery",
                         "itemId": "homedelivery",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "homedelivery",
                         "margin": "5 5 5 5",
                         "inputValue": true,
                         "fieldLabel": "homedelivery<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9E1852A8-0BDA-481D-84E4-61FAA8D67A25",
                         "bindable": "homedelivery",
                         "columnWidth": 0.5
                    }, {
                         "name": "total",
                         "itemId": "total",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "total<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B45DDE3C-8397-431C-BD68-ECAE1817A7C7",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "total",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "96E60857-7325-456A-A7DF-7C2E78FF8EAB",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 473,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 473,
                              "customId": 436
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 473,
                              "customId": 437,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 473,
                              "customId": 438,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "item",
                    "title": "Details Grid",
                    "name": "ItemGrid",
                    "itemId": "ItemGrid",
                    "restURL": "/Item",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "itemid",
                         "dataIndex": "itemid",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "itemName",
                         "dataIndex": "itemname",
                         "flex": 1
                    }, {
                         "header": "itemPrice",
                         "dataIndex": "price",
                         "flex": 1
                    }, {
                         "header": "itemIcon",
                         "dataIndex": "itemicon",
                         "flex": 1
                    }, {
                         "header": "itemQuantity",
                         "dataIndex": "quantity",
                         "flex": 1
                    }, {
                         "header": "itemSize",
                         "dataIndex": "itemsize",
                         "flex": 1
                    }, {
                         "header": "itemOrderdate",
                         "dataIndex": "itemorderdate",
                         "flex": 1
                    }, {
                         "header": "homedelivery",
                         "dataIndex": "homedelivery",
                         "flex": 1
                    }, {
                         "header": "total",
                         "dataIndex": "total",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "item",
               "title": "item",
               "name": "Item",
               "itemId": "ItemForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "itemid",
                    "itemId": "itemid",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "itemid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "itemid<font color='red'> *<\/font>",
                    "fieldId": "9EC676B0-37AC-43D5-9253-CA3D6C2125D2",
                    "hidden": true,
                    "value": "",
                    "bindable": "itemid"
               }, {
                    "name": "itemname",
                    "itemId": "itemname",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "itemName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "itemName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "66B84390-E8E8-4E7F-8F32-F89CCA8DF699",
                    "minLength": "1",
                    "maxLength": "255",
                    "bindable": "itemname",
                    "columnWidth": 0.5
               }, {
                    "name": "price",
                    "itemId": "price",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "itemPrice",
                    "margin": "5 5 5 5",
                    "fieldLabel": "itemPrice<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "93CA7022-0B39-4403-9002-10A687A0C5FA",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "price",
                    "columnWidth": 0.5
               }, {
                    "items": [{
                         "name": "filePathHidden",
                         "xtype": "hidden",
                         "itemId": "filePathHidden"
                    }, {
                         "name": "itemicon",
                         "itemId": "itemicon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "itemIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "itemIcon<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "93D07316-857C-466F-8DBA-1FC10C1639F7",
                         "bindable": "itemicon",
                         "columnWidth": 0.5
                    }]
               }, {
                    "name": "quantity",
                    "itemId": "quantity",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "itemQuantity",
                    "margin": "5 5 5 5",
                    "fieldLabel": "itemQuantity<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "ABE4BC5F-BAAC-4A2E-9DE0-02560FE7A6DD",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "quantity",
                    "columnWidth": 0.5
               }, {
                    "name": "itemsize",
                    "itemId": "itemsize",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "itemSize",
                    "margin": "5 5 5 5",
                    "fieldLabel": "itemSize<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "84E1254E-87FC-43AB-84B9-4760B36B115D",
                    "minLength": "1",
                    "maxLength": "4",
                    "bindable": "itemsize",
                    "columnWidth": 0.5
               }, {
                    "name": "itemorderdate",
                    "itemId": "itemorderdate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "itemOrderdate",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "itemOrderdate<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7A48CE16-7A8C-4078-AB2D-1D1218196AE5",
                    "bindable": "itemorderdate",
                    "columnWidth": 0.5
               }, {
                    "name": "homedelivery",
                    "itemId": "homedelivery",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "homedelivery",
                    "margin": "5 5 5 5",
                    "inputValue": true,
                    "fieldLabel": "homedelivery<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9E1852A8-0BDA-481D-84E4-61FAA8D67A25",
                    "bindable": "homedelivery",
                    "columnWidth": 0.5
               }, {
                    "name": "total",
                    "itemId": "total",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "total",
                    "margin": "5 5 5 5",
                    "fieldLabel": "total<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B45DDE3C-8397-431C-BD68-ECAE1817A7C7",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "total",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "96E60857-7325-456A-A7DF-7C2E78FF8EAB",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 473,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 473,
                         "customId": 436
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 473,
                         "customId": 437,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 473,
                         "customId": 438,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});