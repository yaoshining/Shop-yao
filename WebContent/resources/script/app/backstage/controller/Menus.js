Ext.define('BM.controller.Menus',{
	extend: 'Ext.app.Controller',
	views: ['product.Menu','system.Menu','department.Menu'],
	stores: ['Menus'],
	models: ['Menu']
});