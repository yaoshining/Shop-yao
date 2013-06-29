Ext.define('BM.store.Menus', {
    extend: 'Ext.data.TreeStore',
    model: 'BM.model.Menu',
    autoLoad: true,
    root: {
    	id: 0,
    	name: "Menu",
        expanded: true
    },
	proxy: {
		type: "rest",
		url: "backstage/menus",
		reader: {
			type: "json"
		},
		headers: {
			accept: "application/json;charset=utf-8"
		}
	}
});