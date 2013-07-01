Ext.define('BM.controller.Menus',{
	extend: 'Ext.app.Controller',
	views: ['product.Menu','system.Menu','department.Menu'],
	stores: ['product.Menus','department.Menus'],
	models: ['Menu'],
	
	init: function() {
		this.control({
			'productMenu,deptMenu': {
				itemclick: this.menuClick
			}
		});
	},
	menuClick: function(view,record,item,index,e) {
		if(record.get('leaf')){
			var controller = record.get('controller');
			var tab = Ext.getCmp(record.get('id'));
			if(!tab && controller) {
				this.addController(controller);
				Ext.getCmp('contentTabPanel').add({
					id: record.get('id'),
					xtype: record.get('view')
				}).show();
			}else if(controller!=""){
				tab.show();
			}
			//Ext.Msg.alert();
		}
	},
	addController: function(controller) {
		var c = this.application.getController(controller);
	}
});