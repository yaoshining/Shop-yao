Ext.define('BM.view.layout.East',{
	extend: 'Ext.tab.Panel',
	alias: 'widget.east',
	
    region: 'east',
    title: '属性',
    dockedItems: [{
        dock: 'top',
        xtype: 'toolbar',
        items: [ '->', {
           xtype: 'button',
           text: 'test',
           tooltip: 'Test Button'
        }]
    }],
    animCollapse: true,
    collapsible: true,
    collapsed: true,
    split: true,
    width: 225, // give east and west regions a width
    minSize: 175,
    maxSize: 400,
    margins: '0 5 0 0',
    activeTab: 1,
    tabPosition: 'bottom',
    items: [{
        html: '<p>A TabPanel component can be a region.</p>',
        title: 'A Tab',
        autoScroll: true
    }]
});

//Ext.create('Ext.grid.property.Grid', {
//    title: 'Property Grid',
//    closable: true,
//    source: {
//        "(name)": "Properties Grid",
//        "grouping": false,
//        "autoFitColumns": true,
//        "productionQuality": false,
//        "created": Ext.Date.parse('10/15/2006', 'm/d/Y'),
//        "tested": false,
//        "version": 0.01,
//        "borderWidth": 1
//    }
//})