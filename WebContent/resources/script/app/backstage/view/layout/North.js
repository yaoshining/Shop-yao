Ext.define('BM.view.layout.North',{
	extend: 'Ext.Component',
	alias: 'widget.north',
	
	region: 'north',
    height: 32, // give north and south regions a height
    autoEl: {
        tag: 'div',
        html:'<p style="text-align: center;font-size: 12px;font-weight: bolder;color: #FFF;">商城后台管理系统</p>'
    }
});