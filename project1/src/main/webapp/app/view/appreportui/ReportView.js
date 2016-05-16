Ext.define('Project1.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Project1.view.appreportui.ReportViewController',
	            'Project1.view.appreportui.datagrid.DataGridPanel',
	            'Project1.view.appreportui.datagrid.DataGridView',
	            'Project1.view.appreportui.querycriteria.QueryCriteriaView',
	            'Project1.view.appreportui.chart.ChartView',
	            'Project1.view.appreportui.datapoint.DataPointView',
	            'Project1.view.googlemaps.map.MapPanel',
	            'Project1.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
