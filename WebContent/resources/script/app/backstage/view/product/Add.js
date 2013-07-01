Ext.define('BM.view.product.Add',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.product_add',
	
	id: 'product.add',
    title: '新建商品',
    closable: true,
    autoScroll: true,
    icon: '',
    iconCls: '',
    items: [{
    	xtype: 'form',
    	width: '100%',
    	border: false,
    	bodyPadding: 5,
    	width: '100%',
    	html: ''
    }]
});