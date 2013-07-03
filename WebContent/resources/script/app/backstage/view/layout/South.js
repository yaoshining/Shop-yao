Ext.define('BM.view.layout.South',{
	id: 'shopsouth',
	extend: 'Ext.panel.Panel',
	alias: 'widget.shopsouth',
	
    region: 'south',
    split: true,
    height: 100,
    minSize: 100,
    maxSize: 200,
    collapsible: true,
    collapsed: true,
    title: '消息',
    margins: '0 0 0 0'
});