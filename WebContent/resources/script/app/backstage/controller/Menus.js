Ext.define('BM.controller.Menus',{
	extend: 'Ext.app.Controller',
	views: ['product.Menu','system.Menu','department.Menu'],
	stores: ['product.Menus','department.Menus'],
	models: ['Menu'],
	
	init: function() {
		
	}
});