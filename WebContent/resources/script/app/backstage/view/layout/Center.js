Ext.define('BM.view.layout.Center',{
	extend: 'Ext.tab.Panel',
	alias: 'widget.center',
	
	id: 'contentTabPanel',
    region: 'center', // a center region is ALWAYS required for border layout
    deferredRender: false,
    activeTab: 0,     // first tab initially active
    items: [{
        contentEl: 'center1',
        title: 'Close Me',
        closable: true,
        autoScroll: true,
        iconCls: 'nav'
    }]
});