Ext.define('BM.view.layout.West',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.west',
	
	region: 'west',
    stateId: 'navigation-panel',
    id: 'west-panel', // see Ext.getCmp() below
    title: '功能菜单',
    split: true,
    width: 200,
    minWidth: 175,
    maxWidth: 400,
    collapsible: true,
    animCollapse: true,
    margins: '0 0 0 5',
    layout: 'accordion',
    items: [
      {
        xtype: 'deptMenu' 	
    },{
        xtype: 'productMenu'
    }, {
        xtype: 'systemMenu'
    }, {
        title: '其他',
        html: '<a href="logout">退出</a>',
        iconCls: 'info'
    }]
});