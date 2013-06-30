Ext.application({
    requires: [
       	'Ext.container.Viewport',
    	'Ext.window.MessageBox',
    	'Ext.data.Model',
    	'Ext.data.proxy.Rest'
    ],
    name: 'BM',

    appFolder: 'resources/script/app/backstage',
    controllers: ['Layout','Menus'],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
        	id: 'backage-center',
            layout: 'border',
            items: [
                {
                	xtype: 'north'
                },{
                    xtype: 'south'
                },{
                    xtype: 'east'
                },{
                    xtype: 'west'
                },{
                	xtype: 'center'
                }
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
Ext.MyUtil = function(){
    var msgCt;

    function createBox(t, s){
       return '<div class="msg"><h3>' + t + '</h3><p>' + s + '</p></div>';
    }
    return {
        msg : function(title, format, delay){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, createBox(title, s), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: delay?delay:1000, remove: true});
        },

        init : function(){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
        }
    };
}();


Ext.onReady(function(){
	Ext.MyUtil.init();
	Ext.MyUtil.msg("您好","商城后台管理系统已经初始化完成！", 3000);
}, Ext.MyUtil);