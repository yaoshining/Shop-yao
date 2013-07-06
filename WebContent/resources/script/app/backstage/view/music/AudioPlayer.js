Ext.define('BM.view.music.AudioPlayer',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.audioplayer',
	
	id: 'audioPlayer',
	animCollapse:false,
	border: false,
	//defaultFocus: 'notepad-editor', EXTJSIV-1300
	
	// IE has a bug where it will keep the iframe's background visible when the window
	// is set to visibility:hidden. Hiding the window via position offsets instead gets
	// around this bug.
	hideMode: 'offsets',
	hidden: true,
	layout: 'fit',
	loader: {
		url: 'resources/html/music/player.html',
		autoLoad: true
	}
});