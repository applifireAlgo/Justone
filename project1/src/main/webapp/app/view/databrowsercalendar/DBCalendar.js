Ext.define('Project1.view.databrowsercalendar.DBCalendar', {
	extend : 'Project1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project1.view.databrowsercalendar.DBCalendarController',
	             'Project1.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	/*listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}*/
});
