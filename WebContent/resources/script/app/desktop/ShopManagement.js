Ext.define('MyDesktop.ShopManagement', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.layout.container.Border'
        //'Ext.form.field.TextArea'
    ],

    id:'shop-mgt',

    init : function(){
        this.launcher = {
            text: '商城管理系统',
            iconCls:'notepad'
        }
    },

    createWindow : function(){
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow('shop');
        var app = BM.getApplication();
        app.getController('Layout');
        app.getController('Menus');
        if(!win){
            win = desktop.createWindow({
            	id: 'shop',
            	border: false,
            	layout: 'border',
            	width: 1000,
            	height: 600,
            	title: '<div style="text-align:center">商城后台管理系统</div>',
            	items: [
            	    {
	                    xtype: 'shopsouth'
	                },{
	                    xtype: 'shopeast'
	                },{
	                    xtype: 'shopwest'
	                },{
	                	xtype: 'shopcenter'
	                }
            	]
            });
        }
        return win;
    }
});
