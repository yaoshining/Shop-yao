Ext.define('BM.view.layout.Center',{
	extend: 'Ext.tab.Panel',
	alias: 'widget.shopcenter',
	
	id: 'contentTabPanel',
    region: 'center', // a center region is ALWAYS required for border layout
    deferredRender: false,
    activeTab: 0,     // first tab initially active
    frame: true,
    items: [{
        title: 'Close Me',
        closable: true,
        autoScroll: true,
        iconCls: 'nav',
        html: 'asdasdas'
    }],
    plugins: Ext.create('Ext.ux.TabCloseMenu', {
        extraItemsTail: [
	         '-',
	         {
	             text: '是否可关闭',
	             checked: true,
	             hideOnClick: true,
	             handler: function (item) {
	                 currentItem.tab.setClosable(item.checked);
	             }
	         },
	         '-',
	         {
	             text: '是否启用',
	             checked: true,
	             hideOnClick: true,
	             handler: function(item) {
	                 currentItem.tab.setDisabled(!item.checked);
	             }
	         }
	     ],
	     listeners: {
	         aftermenu: function () {
	             currentItem = null;
	         },
	         beforemenu: function (menu, item) {
	             var enabled = menu.child('[text="是否启用"]'); 
	             menu.child('[text="是否可关闭"]').setChecked(item.closable);
	             if (item.tab.active) {
	                 enabled.disable();
	             } else {
	                 enabled.enable();
	                 enabled.setChecked(!item.tab.isDisabled());
	             }
	
	             currentItem = item;
	         }
	     }
	 })
});
//Ext.define('BM.view.layout.Center',{
//	extend: 'Ext.ux.GroupTabPanel',
//	alias: 'widget.shopcenter',
//	
//	activeGroup: 0,
//	layout: 'fit',
//    items: [{
//        mainItem: 1,
//        items: [{
//            title: 'Tickets',
//            iconCls: 'x-icon-tickets',
//            height: null,
//            html: 'asdasdasdasdadasd',
//            border: false
//        },{
//            title: 'Tickets',
//            iconCls: 'x-icon-tickets',
//            width: '100%',
//            height: 100,
//            html: 'rnrthrthrthgergwerw',
//            border: false
//        }]
//    }]
//});