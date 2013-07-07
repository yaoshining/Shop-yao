//// Local copy of jQuery selectors, for performance.
//var	my_jPlayer = $("#jquery_jplayer"),
//	my_trackName = $("#jp_container .track-name"),
//	my_playState = $("#jp_container .play-state"),
//	my_extraPlayInfo = $("#jp_container .extra-play-info");
//
//// Some options
//var	opt_play_first = false, // If true, will attempt to auto-play the default track on page loads. No effect on mobile devices, like iOS.
//	opt_auto_play = true, // If true, when a track is selected, it will auto-play.
//	opt_text_playing = "正在播放", // Text when playing
//	opt_text_selected = "您选择了"; // Text when not playing
//
//// A flag to capture the first track
//var first_track = true;
//
//// Change the time format
//$.jPlayer.timeFormat.padMin = false;
//$.jPlayer.timeFormat.padSec = false;
//$.jPlayer.timeFormat.sepMin = " 分 ";
//$.jPlayer.timeFormat.sepSec = " 秒";
//
//// Initialize the play state text
//my_playState.text(opt_text_selected);
//
//// Instance jPlayer
//my_jPlayer.jPlayer({
//	ready: function () {
//		$("#jp_container .track-default").click();
//	},
//	timeupdate: function(event) {
//		my_extraPlayInfo.text(parseInt(event.jPlayer.status.currentPercentAbsolute, 10) + "%");
//	},
//	play: function(event) {
//		my_playState.text(opt_text_playing);
//	},
//	pause: function(event) {
//		my_playState.text(opt_text_selected);
//	},
//	ended: function(event) {
//		my_playState.text(opt_text_selected);
//	},
//	swfPath: "resources/scripts/jquery/jplayer",
//	cssSelectorAncestor: "#jp_container",
//	supplied: "mp3",
//	wmode: "window"
//});
//
//// Create click handlers for the different tracks
//$("#jp_container .track").click(function(e) {
//	my_trackName.text($(this).text());
//	my_jPlayer.jPlayer("setMedia", {
//		mp3: $(this).attr("href")
//	});
//	if((opt_play_first && first_track) || (opt_auto_play && !first_track)) {
//		my_jPlayer.jPlayer("play");
//	}
//	first_track = false;
//	$(this).blur();
//	return false;
//});
var volumeBall = $(".volume-ball");
var header = $("#player-header");
var content = $("#player-content");
var bottom = $("#player-bottom");
var menu = $("#player-menu");
var poster = $("#player-poster");
var playlist = $("#player-playlist");
var extWindow = Ext.getCmp('music');
volumeBall.draggable({
	axis: 'x',
	containment: 'parent',
	drag: function(event,ui){
		var pct = (ui.position.left)/($(this).parent().width()-$(this).width());
		$(myPlaylist.cssSelector.jPlayer).jPlayer('volume',pct);
		console.log(ui.position.left);
	}
});
var resizeContent = function(){
	var contentHeight = extWindow.getHeight()-extWindow.getHeader().getHeight()-header.height()-bottom.height();
	content.height(contentHeight);
	var playlistWidth = content.width()-menu.width();
	playlist.width(playlistWidth);
}
extWindow.on('afterlayout',function(){
	resizeContent();
});
extWindow.on('resize',function(){
	resizeContent();
});
var myPlaylist = new jPlayerPlaylist({
	jPlayer: "#jquery_jplayer",
	cssSelectorAncestor: "#jp_container"
}, [
	{
		title:"Cro Magnon Man",
		artist:"The Stark Palace",
		mp3:"http://www.jplayer.org/audio/mp3/TSP-01-Cro_magnon_man.mp3",
		oga:"http://www.jplayer.org/audio/ogg/TSP-01-Cro_magnon_man.ogg",
		poster: "http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
	},
	{
		title:"Your Face",
		artist:"The Stark Palace",
		mp3:"http://www.jplayer.org/audio/mp3/TSP-05-Your_face.mp3",
		oga:"http://www.jplayer.org/audio/ogg/TSP-05-Your_face.ogg",
		poster: "http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
	},
	{
		title:"Hidden",
		artist:"Miaow",
		free: true,
		mp3:"http://www.jplayer.org/audio/mp3/Miaow-02-Hidden.mp3",
		oga:"http://www.jplayer.org/audio/ogg/Miaow-02-Hidden.ogg",
		poster: "http://www.jplayer.org/audio/poster/Miaow_640x360.png"
	},
	{
		title:"Cyber Sonnet",
		artist:"The Stark Palace",
		mp3:"http://www.jplayer.org/audio/mp3/TSP-07-Cybersonnet.mp3",
		oga:"http://www.jplayer.org/audio/ogg/TSP-07-Cybersonnet.ogg",
		poster: "http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
	},
	{
		title:"Tempered Song",
		artist:"Miaow",
		mp3:"http://www.jplayer.org/audio/mp3/Miaow-01-Tempered-song.mp3",
		oga:"http://www.jplayer.org/audio/ogg/Miaow-01-Tempered-song.ogg",
		poster: "http://www.jplayer.org/audio/poster/Miaow_640x360.png"
	},
	{
		title:"Lentement",
		artist:"Miaow",
		mp3:"http://www.jplayer.org/audio/mp3/Miaow-03-Lentement.mp3",
		oga:"http://www.jplayer.org/audio/ogg/Miaow-03-Lentement.ogg",
		poster: "http://www.jplayer.org/audio/poster/Miaow_640x360.png"
	}
], {
	playlistOptions: {
		autoPlay: false,
		enableRemoveControls: true,
		itemClass: "jp-playlist-item"
	},
	repeat: true,
	swfPath: "resources/scripts/jquery/jplayer",
	supplied: "oga, mp3",
	smoothPlayBar: true,
	keyEnabled: true,
	audioFullScreen: true,
	play: function(event) {
		var posterUrl = event.jPlayer.status.media.poster;
		var title = event.jPlayer.status.media.title;
		var artist = event.jPlayer.status.media.artist;
		poster.css("background-image","url('"+posterUrl+"')");
		$(".detail-title").text(title);
		$(".detail-artist").text(artist);
	},
	volumechange: function(event){
		var left = 0;
		if(!event.jPlayer.options.muted) {
			var volumePct = event.jPlayer.options.volume;
			left = (volumeBall.parent().width()-14)*volumePct;
		}
		volumeBall.css("left",left);
	},
	ready: function(event){
		var volumePct = event.jPlayer.options.volume;
		var left = (volumeBall.parent().width()-14)*volumePct;
		volumeBall.css("left",left);
	}
});
