<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()+"/" %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城后台管理系统</title>
<link rel="stylesheet" href="resources/css/extjs/ext-all-neptune.css" media="screen" />
<style>
<!--
p {
    margin:5px;
}
.settings {
    background-image:url(resources/images/backstage/icons/folder_wrench.png);
}
.nav {
    background-image:url(resources/images/backstage/icons/folder_go.png);
}
.info {
    background-image:url(resources/images/backstage/icons/information.png);
}
.dept {
    background-image:url(resources/images/backstage/icons/user_suit.png);
}
#loading-mask{
	background-color:white;
	height:100%;
	position:absolute;
	left:0;
	top:0;
	width:100%;
	z-index:20000;
}
#loading{
    height:auto;
    position:absolute;
    left:43%;
    top:40%;
    padding:2px;
    z-index:20001;
}
#loading a {
    color:#225588;
}
#loading .loading-indicator{
    background:white;
    color:#444;
    font:bold 13px Helvetica, Arial, sans-serif;
    height:auto;
    margin:0;
    padding:10px;
}
#loading-msg {
    font-size: 10px;
    font-weight: normal;
}
-->
</style>
</head>
<body>
<div id="loading-mask" style=""></div>
<div id="loading">
    <div class="loading-indicator">
        <img src="resources/images/backstage/loading.gif" width="32" height="32" style="margin-right:8px;float:left;vertical-align:top;"/>商城后台管理系统 - <a href="http://www.shopyao.com">shopyao.com</a>
        <br /><span id="loading-msg">正在载入样式和图片...</span>
    </div>
</div>
<!-- use class="x-hide-display" to prevent a brief flicker of the content -->
    <div id="west" class="x-hide-display">
        <p>商品管理树</p>
    </div>
    <div id="center2" class="x-hide-display">
        <a id="hideit" href="#">Toggle the west region</a>
        <p>My closable attribute is set to false so you can't close me. The other center panels can be closed.</p>
        <p>The center panel automatically grows to fit the remaining space in the container that isn't taken up by the border regions.</p>
        <hr>
        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna. Aliquam commodo ullamcorper erat. Nullam vel justo in neque porttitor laoreet. Aenean lacus dui, consequat eu, adipiscing eget, nonummy non, nisi. Morbi nunc est, dignissim non, ornare sed, luctus eu, massa. Vivamus eget quam. Vivamus tincidunt diam nec urna. Curabitur velit. Quisque dolor magna, ornare sed, elementum porta, luctus in, leo.</p>
        <p>Donec quis dui. Sed imperdiet. Nunc consequat, est eu sollicitudin gravida, mauris ligula lacinia mauris, eu porta dui nisl in velit. Nam congue, odio id auctor nonummy, augue lectus euismod nunc, in tristique turpis dolor sed urna. Donec sit amet quam eget diam fermentum pharetra. Integer tincidunt arcu ut purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla blandit malesuada odio. Nam augue. Aenean molestie sapien in mi. Suspendisse tincidunt. Pellentesque tempus dui vitae sapien. Donec aliquam ipsum sit amet pede. Sed scelerisque mi a erat. Curabitur rutrum ullamcorper risus. Maecenas et lorem ut felis dictum viverra. Fusce sem. Donec pharetra nibh sit amet sapien.</p>
        <p>Aenean ut orci sed ligula consectetuer pretium. Aliquam odio. Nam pellentesque enim. Nam tincidunt condimentum nisi. Maecenas convallis luctus ligula. Donec accumsan ornare risus. Vestibulum id magna a nunc posuere laoreet. Integer iaculis leo vitae nibh. Nam vulputate, mauris vitae luctus pharetra, pede neque bibendum tellus, facilisis commodo diam nisi eget lacus. Duis consectetuer pulvinar nisi. Cras interdum ultricies sem. Nullam tristique. Suspendisse elementum purus eu nisl. Nulla facilisi. Phasellus ultricies ullamcorper lorem. Sed euismod ante vitae lacus. Nam nunc leo, congue vehicula, luctus ac, tempus non, ante. Morbi suscipit purus a nulla. Sed eu diam.</p>
        <p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras imperdiet felis id velit. Ut non quam at sem dictum ullamcorper. Vestibulum pharetra purus sed pede. Aliquam ultrices, nunc in varius mattis, felis justo pretium magna, eget laoreet justo eros id eros. Aliquam elementum diam fringilla nulla. Praesent laoreet sapien vel metus. Cras tempus, sapien condimentum dictum dapibus, lorem augue fringilla orci, ut tincidunt eros nisi eget turpis. Nullam nunc nunc, eleifend et, dictum et, pharetra a, neque. Ut feugiat. Aliquam erat volutpat. Donec pretium odio nec felis. Phasellus sagittis lacus eget sapien. Donec est. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;</p>
        <p>Vestibulum semper. Nullam non odio. Aliquam quam. Mauris eu lectus non nunc auctor ullamcorper. Sed tincidunt molestie enim. Phasellus lobortis justo sit amet quam. Duis nulla erat, varius a, cursus in, tempor sollicitudin, mauris. Aliquam mi velit, consectetuer mattis, consequat tristique, pulvinar ac, nisl. Aliquam mattis vehicula elit. Proin quis leo sed tellus scelerisque molestie. Quisque luctus. Integer mattis. Donec id augue sed leo aliquam egestas. Quisque in sem. Donec dictum enim in dolor. Praesent non erat. Nulla ultrices vestibulum quam.</p>
        <p>Duis hendrerit, est vel lobortis sagittis, tortor erat scelerisque tortor, sed pellentesque sem enim id metus. Maecenas at pede. Nulla velit libero, dictum at, mattis quis, sagittis vel, ante. Phasellus faucibus rutrum dui. Cras mauris elit, bibendum at, feugiat non, porta id, neque. Nulla et felis nec odio mollis vehicula. Donec elementum tincidunt mauris. Duis vel dui. Fusce iaculis enim ac nulla. In risus.</p>
        <p>Donec gravida. Donec et enim. Morbi sollicitudin, lacus a facilisis pulvinar, odio turpis dapibus elit, in tincidunt turpis felis nec libero. Nam vestibulum tempus ipsum. In hac habitasse platea dictumst. Nulla facilisi. Donec semper ligula. Donec commodo tortor in quam. Etiam massa. Ut tempus ligula eget tellus. Curabitur id velit ut velit varius commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Fusce ornare pellentesque libero. Nunc rhoncus. Suspendisse potenti. Ut consequat, leo eu accumsan vehicula, justo sem lobortis elit, ac sollicitudin ipsum neque nec ante.</p>
        <p>Aliquam elementum mauris id sem. Vivamus varius, est ut nonummy consectetuer, nulla quam bibendum velit, ac gravida nisi felis sit amet urna. Aliquam nec risus. Maecenas lacinia purus ut velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse sit amet dui vitae lacus fermentum sodales. Donec varius dapibus nisl. Praesent at velit id risus convallis bibendum. Aliquam felis nibh, rutrum nec, blandit non, mattis sit amet, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam varius dignissim nibh. Quisque id orci ac ante hendrerit molestie. Aliquam malesuada enim non neque.</p>
    </div>
    <div id="center1" class="x-hide-display">
        <p><b>Done reading me? Close me by clicking the X in the top right corner.</b></p>
        <p>Vestibulum semper. Nullam non odio. Aliquam quam. Mauris eu lectus non nunc auctor ullamcorper. Sed tincidunt molestie enim. Phasellus lobortis justo sit amet quam. Duis nulla erat, varius a, cursus in, tempor sollicitudin, mauris. Aliquam mi velit, consectetuer mattis, consequat tristique, pulvinar ac, nisl. Aliquam mattis vehicula elit. Proin quis leo sed tellus scelerisque molestie. Quisque luctus. Integer mattis. Donec id augue sed leo aliquam egestas. Quisque in sem. Donec dictum enim in dolor. Praesent non erat. Nulla ultrices vestibulum quam.</p>
        <p>Duis hendrerit, est vel lobortis sagittis, tortor erat scelerisque tortor, sed pellentesque sem enim id metus. Maecenas at pede. Nulla velit libero, dictum at, mattis quis, sagittis vel, ante. Phasellus faucibus rutrum dui. Cras mauris elit, bibendum at, feugiat non, porta id, neque. Nulla et felis nec odio mollis vehicula. Donec elementum tincidunt mauris. Duis vel dui. Fusce iaculis enim ac nulla. In risus.</p>
        <p>Donec gravida. Donec et enim. Morbi sollicitudin, lacus a facilisis pulvinar, odio turpis dapibus elit, in tincidunt turpis felis nec libero. Nam vestibulum tempus ipsum. In hac habitasse platea dictumst. Nulla facilisi. Donec semper ligula. Donec commodo tortor in quam. Etiam massa. Ut tempus ligula eget tellus. Curabitur id velit ut velit varius commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Fusce ornare pellentesque libero. Nunc rhoncus. Suspendisse potenti. Ut consequat, leo eu accumsan vehicula, justo sem lobortis elit, ac sollicitudin ipsum neque nec ante.</p>
        <p>Aliquam elementum mauris id sem. Vivamus varius, est ut nonummy consectetuer, nulla quam bibendum velit, ac gravida nisi felis sit amet urna. Aliquam nec risus. Maecenas lacinia purus ut velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse sit amet dui vitae lacus fermentum sodales. Donec varius dapibus nisl. Praesent at velit id risus convallis bibendum. Aliquam felis nibh, rutrum nec, blandit non, mattis sit amet, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam varius dignissim nibh. Quisque id orci ac ante hendrerit molestie. Aliquam malesuada enim non neque.</p>
    </div>
    <div id="props-panel" class="x-hide-display" style="width:200px;height:200px;overflow:hidden;">
    </div>
    <div id="south" class="x-hide-display">
        <p>south - generally for informational stuff, also could be for status bar</p>
    </div>
<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '正在载入JS核心库...';</script>
<script type="text/javascript" src="resources/script/extjs/ext-debug.js"></script>
<script type="text/javascript">Ext.require(['Ext.container.Viewport']);</script>
<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '正在载入图形化界面组件...';</script>
<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '初始化...';</script>
<script type="text/javascript">
<!--
Ext.application({
	requires: ['Ext.container.Viewport','Ext.window.MessageBox','Ext.data.Model'],
	name: 'BM',  //backage management
	
	launch: function() {
		Ext.define('BM.model.Menu',{
			extend: 'Ext.data.Model',
			fields:	[
			     {name: 'text', type: 'string', defaultValue: null},
			     {name: 'icon', type: 'string', defaultValue: null},
			     {name: 'iconCls', type: 'string', defaultValue: null},
			     {name: 'leaf', type: 'bool', defaultValue: false},
			     {name: 'expanded', type: 'bool', defaultValue: false},
		       	 {name: 'url', type: 'string', defaultValue: null}
			]
		});
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
		var productStore = Ext.create('Ext.data.TreeStore', {
	    	model: 'BM.model.Menu',
		    root: {
		        expanded: true,
		        children: [
		            { text: "新建商品", leaf: true, url: '/ShopYao/index.jsp', icon: 'resources/images/backstage/icons/add.png' },
		            { text: "修改商品", leaf: true },
		            { text: "商品查询", leaf: true }
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
                        Ext.create('Ext.tree.Panel', {
                        title: '部门管理',
                        width: 200,
                        height: 150,
                        store: deptStore,
                        rootVisible: false,
                        iconCls: 'dept'
                    }),Ext.create('Ext.tree.Panel', {
                        title: '商品管理',
                        width: 200,
                        height: 150,
                        store: productStore,
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
	                                    loader: {
	                                    	url: url,
	                                    	autoLoad: true
	                                    }
	                        		}).show();
                        		}
                        		//Ext.Msg.alert();
                        	}
                        }
                    }), {
                        title: '系统设置',
                        html: '<p>系统设置树</p>',
                        iconCls: 'settings'
                    }, {
                        title: '其他',
                        html: '<p>其他</p>',
                        iconCls: 'info'
                    }]
                },
             	// in this instance the TabPanel is not wrapped by another panel
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
                        autoScroll: true
                    }, {
                        contentEl: 'center2',
                        title: 'Center Panel',
                        autoScroll: true
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
    }
});
//-->
</script>
</body>
</html>