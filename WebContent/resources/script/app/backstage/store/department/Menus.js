Ext.define('BM.store.department.Menus', {
    extend: 'Ext.data.TreeStore',
    model: 'BM.model.Menu',
    autoLoad: true,
    root: {
    	id: 0,
    	text: "Menu",
        expanded: true
    },
	proxy: {
		type: "rest",
		url: "backstage/menus/department",
		reader: {
			type: "json"
		},
		headers: {
			accept: "application/json;charset=utf-8"
		}
	}
});