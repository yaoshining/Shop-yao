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
		var url = record.get('url');
		var tab = Ext.getCmp(record.get('id'));
		if(tab==undefined && url!="") {
    		Ext.getCmp('contentTabPanel').add({
    			id: record.get('id'),
                title: record.get('text'),
                closable: true,
                autoScroll: true,
                icon: record.get('icon'),
                loader: {
                	url: url,
                	autoLoad: true
                }
    		}).show();
		}else{
			tab.show();
		}
		//Ext.Msg.alert();
	}
});