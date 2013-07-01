Ext.define('BM.model.Notebook',{
	extend: 'Ext.data.Model',
	fields:	['id','modelNumber'],
	proxy: {
		type: 'rest',
		url: 'backstage/notebook'
	}
});