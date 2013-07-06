Ext.define('BM.view.product.Add',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.product_add',
	
    title: '新建商品',
    closable: true,
    autoScroll: true,
    icon: '',
    iconCls: '',
    items: [{
    	xtype: 'form',
    	url: 'backstage/notebook',
    	border: false,
    	bodyPadding: '10 100',
    	width: '100%',
    	layout: 'form',
    	defaultType: 'textfield',
    	buttonAlign: 'center',
    	items: [
    	    {fieldLabel: '商品名称',name:'name',allowBlank:false},
    	    {fieldLabel: '型号',name:'modelNumber',allowBlank:false},
    	    {fieldLabel: '品牌',name:'brand',allowBlank:false},
    	    {fieldLabel: '尺寸',name:'size',allowBlank:false},
    	    {
    	    	xtype:'colorfield',
    	    	fieldLabel: '颜色',
    	    	name:'colour',
    	    	allowBlank:false
    	    },
    	    {xtype:'datefield',fieldLabel: '上市时间',name:'timeToMarket',allowBlank:false},
    	    {fieldLabel: '价格',name:'price',allowBlank:false},
    	    {fieldLabel: '操作系统',name:'operatingSystem',allowBlank:false}
    	],
    	buttons: [
    	    {
    	    	text:'重置',
    	    	handler: function() {
    	    		this.up('form').getForm().reset();
    	    	}
    		},
    		{
    			text: '新建',
    	        formBind: true,
    	        disabled: true,
    	        handler: function() {
    	            var form = this.up('form').getForm();
    	            if (form.isValid()) {
    	            	var notebook = Ext.create('BM.model.Notebook',{
    	            		modelNumber: 'HGJG124234423'
    	            	});
    	            	notebook.save();
//    	                form.submit({
//    	                    success: function(form, action) {
//    	                       Ext.Msg.alert('Success', action.result.msg);
//    	                    },
//    	                    failure: function(form, action) {
//    	                        Ext.Msg.alert('Failed', action.result.msg);
//    	                    }
//    	                });
    	            }
    	        }
    		}
    	]
    }]
});