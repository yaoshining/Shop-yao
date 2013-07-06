Ext.define('BM.controller.music.Music',{
	extend: 'Ext.app.Controller',
	views: ['music.AudioPlayer'],
	
	init: function(){
		this.control({
			'audioplayer': {
				afterrender: function(player){
					$.getScript('resources/script/jquery/jplayer/jquery.jplayer.js',function(){
						// Local copy of jQuery selectors, for performance.
						var	my_jPlayer = $("#jquery_jplayer"),
							my_trackName = $("#jp_container .track-name"),
							my_playState = $("#jp_container .play-state"),
							my_extraPlayInfo = $("#jp_container .extra-play-info");

						// Some options
						var	opt_play_first = false, // If true, will attempt to auto-play the default track on page loads. No effect on mobile devices, like iOS.
							opt_auto_play = true, // If true, when a track is selected, it will auto-play.
							opt_text_playing = "正在播放", // Text when playing
							opt_text_selected = "您选择了"; // Text when not playing

						// A flag to capture the first track
						var first_track = true;

						// Change the time format
						$.jPlayer.timeFormat.padMin = false;
						$.jPlayer.timeFormat.padSec = false;
						$.jPlayer.timeFormat.sepMin = " 分 ";
						$.jPlayer.timeFormat.sepSec = " 秒";

						// Initialize the play state text
						my_playState.text(opt_text_selected);

						// Instance jPlayer
						my_jPlayer.jPlayer({
							ready: function () {
								$("#jp_container .track-default").click();
							},
							timeupdate: function(event) {
								my_extraPlayInfo.text(parseInt(event.jPlayer.status.currentPercentAbsolute, 10) + "%");
							},
							play: function(event) {
								my_playState.text(opt_text_playing);
							},
							pause: function(event) {
								my_playState.text(opt_text_selected);
							},
							ended: function(event) {
								my_playState.text(opt_text_selected);
							},
							swfPath: "resources/scripts/jquery/jplayer",
							cssSelectorAncestor: "#jp_container",
							supplied: "mp3",
							wmode: "window"
						});

						// Create click handlers for the different tracks
						$("#jp_container .track").click(function(e) {
							my_trackName.text($(this).text());
							my_jPlayer.jPlayer("setMedia", {
								mp3: $(this).attr("href")
							});
							if((opt_play_first && first_track) || (opt_auto_play && !first_track)) {
								my_jPlayer.jPlayer("play");
							}
							first_track = false;
							$(this).blur();
							return false;
						});
						player.show();
			    	});
				}
			}
		});
	}
});