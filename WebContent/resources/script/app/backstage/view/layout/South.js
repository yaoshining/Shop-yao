Ext.define('BM.view.layout.South',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.south',
	
	// lazily created panel (xtype:'panel' is default)
    region: 'south',
    contentEl: 'south',
    split: true,
    height: 100,
    minSize: 100,
    maxSize: 200,
    collapsible: true,
    collapsed: true,
    title: '消息',
    margins: '0 0 0 0'
});