Ext.define('BM.model.Menu',{
	extend: 'Ext.data.Model',
	fields:	[
	     {name: 'id', type: 'string', defaultValue: null},
	     {name: 'text', type: 'string', defaultValue: null},
	     {name: 'icon', type: 'string', defaultValue: null},
	     {name: 'iconCls', type: 'string', defaultValue: null},
	     {name: 'leaf', type: 'bool', defaultValue: false},
	     {name: 'expanded', type: 'bool', defaultValue: false},
	     {name: 'loaded', type: 'bool', defaultValue: false},
       	 {name: 'controller', type: 'string', defaultValue: null},
       	 {name: 'view', type: 'string', defaultValue: null}
	]
});