/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.Music', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
    ],

    id:'music',

    init : function(){
        this.launcher = {
            text: '音乐',
            iconCls:'notepad'
        }
    },

    createWindow : function(){
    	var app = BM.getApplication();
        app.getController('music.Music');
        var desktop = this.app.getDesktop();
    	var win = desktop.getWindow('music');
    	if(!win){
    		win = desktop.createWindow({
    			id: 'music',
    			title:'音乐',
//    			width:245,
//    			height:350,
    			width:900,
    			height:600,
    			iconCls: 'music',
    			animCollapse:false,
    			border: false,
    			//defaultFocus: 'notepad-editor', EXTJSIV-1300
    			
    			// IE has a bug where it will keep the iframe's background visible when the window
    			// is set to visibility:hidden. Hiding the window via position offsets instead gets
    			// around this bug.
    			hideMode: 'offsets',
    			
    			layout: 'fit',
    			items: [
    			    {
    			    	xtype: 'audioplayer'
    			    }
    			]
    		});
    	}
    	return win;
    }
});
