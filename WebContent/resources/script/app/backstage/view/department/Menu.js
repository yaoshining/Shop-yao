Ext.define('BM.view.department.Menu',{
	extend: 'Ext.tree.Panel',
	alias: 'widget.deptMenu',
	
	title: '部门管理',
    width: 200,
    height: 150,
    store: 'Menus',
    rootVisible: false,
    iconCls: 'dept',
    lines: false
});