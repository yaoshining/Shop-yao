Ext.define('BM.view.product.Menu' ,{
    extend: 'Ext.tree.Panel',
    alias: 'widget.productMenu',

    title: '商品管理',
    width: 200,
    height: 150,
    lines: false,
    store: 'Menus',
    rootVisible: false,
    iconCls: 'nav',
    listeners: {
    	'itemclick': function(view,record,item,index,e){
    		var url = record.get('url');
    		if(url!="") {
        		Ext.getCmp('contentTabPanel').add({
                    title: record.get('text'),
                    closable: true,
                    autoScroll: true,
                    icon: record.get('icon'),
                    loader: {
                    	url: url,
                    	autoLoad: true
                    }
        		}).show();
    		}
    		//Ext.Msg.alert();
    	}
    }
});