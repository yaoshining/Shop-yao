Ext.define('BM.controller.music.Music',{
	extend: 'Ext.app.Controller',
	views: ['music.AudioPlayer'],
	
	init: function(){
		this.control({
			'audioplayer': {
				beforerender: function(){
					Ext.Ajax.request({
						url: 'resources/css/music.css',
						success: function(response){
							var text = response.responseText;
							Ext.util.CSS.createStyleSheet(text,"musicStyle");
						}
					});
				},
				afterrender: function(player){
					$.getScript('resources/script/jquery/jplayer/jquery.jplayer.js',function(){
						$.getScript('resources/script/jquery/jplayer/add-on/jplayer.playlist.js',function(){
								$.getScript('resources/script/jquery/ui/jquery-ui.custom.js',function(){
									$.getScript('resources/script/jquery/jplayer/playerhandler.js',function(){
									player.show();
								});
					    	});
				    	});
			    	});
				}
			}
		});
	}
});