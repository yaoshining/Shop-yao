Ext.define('BM.view.shared.ColorField',{
	extend: 'Ext.form.field.Picker',
	alias: 'widget.colorfield',
	
	createPicker: function(){
		var picker = Ext.create('Ext.picker.Color', {
		    value: '993300',  // initial selected color
		    listeners: {
		        select: function(picker, selColor) {
		            alert(selColor);
		        }
		    }
		});
		return picker;
	}
});