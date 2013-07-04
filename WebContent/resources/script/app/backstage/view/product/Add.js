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
    	width: '100%',
    	url: 'backstage/notebook',
    	border: false,
    	bodyPadding: 5,
    	width: '100%',
    	layout: 'anchor',
    	defaultType: 'textfield',
    	items: [
    	    {fieldLabel: '商品名称',name:'name',allowBlank:false}
    	],
    	buttons: [
    	    {
    	    	text:'重置',
    	    	handler: function() {
    	    		this.up('form').getForm().reset();
    	    	}
    		},
    		{
    			text: 'Submit',
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