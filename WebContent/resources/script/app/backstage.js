Ext.application({
    requires: [
       	'Ext.container.Viewport',
    	'Ext.window.MessageBox',
    	'Ext.data.Model',
    	'Ext.data.proxy.Rest'
    ],
    name: 'BM',

    appFolder: 'resources/script/app/backstage',
    controllers: ['Menus'],
    launch: function() {
    	var deptStore = Ext.create('Ext.data.TreeStore', {
		    root: {
		        expanded: true,
		        children: [
		            { text: "员工管理", leaf: true },
		            { text: "权限管理", expanded: true, children: [
		                { text: "XXX管理", leaf: true },
		                { text: "XXX管理", leaf: true}
		            ] },
		            { text: "XXX管理", leaf: true }
		        ]
		    }
		});
        Ext.create('Ext.container.Viewport', {
        	id: 'backage-center',
            layout: 'border',
            items: [
                Ext.create('Ext.Component', {
	                region: 'north',
	                height: 32, // give north and south regions a height
	                autoEl: {
	                    tag: 'div',
	                    html:'<p style="text-align: center;font-size: 12px;font-weight: bolder;color: #FFF;">商城后台管理系统</p>'
	                }
            	}),{
                    // lazily created panel (xtype:'panel' is default)
                    region: 'south',
                    contentEl: 'south',
                    split: true,
                    height: 100,
                    minSize: 100,
                    maxSize: 200,
                    collapsible: true,
                    collapsed: true,
                    title: '消息',
                    margins: '0 0 0 0'
                },{
                    xtype: 'tabpanel',
                    region: 'east',
                    title: '属性',
                    dockedItems: [{
                        dock: 'top',
                        xtype: 'toolbar',
                        items: [ '->', {
                           xtype: 'button',
                           text: 'test',
                           tooltip: 'Test Button'
                        }]
                    }],
                    animCollapse: true,
                    collapsible: true,
                    collapsed: true,
                    split: true,
                    width: 225, // give east and west regions a width
                    minSize: 175,
                    maxSize: 400,
                    margins: '0 5 0 0',
                    activeTab: 1,
                    tabPosition: 'bottom',
                    items: [{
                        html: '<p>A TabPanel component can be a region.</p>',
                        title: 'A Tab',
                        autoScroll: true
                    }, Ext.create('Ext.grid.PropertyGrid', {
                            title: 'Property Grid',
                            closable: true,
                            source: {
                                "(name)": "Properties Grid",
                                "grouping": false,
                                "autoFitColumns": true,
                                "productionQuality": false,
                                "created": Ext.Date.parse('10/15/2006', 'm/d/Y'),
                                "tested": false,
                                "version": 0.01,
                                "borderWidth": 1
                            }
                        })]
                },{
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
                },// in this instance the TabPanel is not wrapped by another panel
                // since no title is needed, this Panel is added directly
                // as a Container

                Ext.create('Ext.tab.Panel', {
                	id: 'contentTabPanel',
                    region: 'center', // a center region is ALWAYS required for border layout
                    deferredRender: false,
                    activeTab: 0,     // first tab initially active
                    items: [{
                        contentEl: 'center1',
                        title: 'Close Me',
                        closable: true,
                        autoScroll: true,
                        iconCls: 'nav'
                    }]
                })
            ]
        });
        var hideMask = function () {
		    Ext.get('loading').remove();
		    Ext.fly('loading-mask').animate({
		        opacity:0,
		        remove:true,
		        callback: function(){
		        	
		        }
		    });
		};
		
		Ext.defer(hideMask, 250);
    },
    controllers: ['Menus']
});