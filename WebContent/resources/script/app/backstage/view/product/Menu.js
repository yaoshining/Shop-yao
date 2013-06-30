Ext.define('BM.view.product.Menu' ,{
    extend: 'Ext.tree.Panel',
    alias: 'widget.productMenu',

    title: '商品管理',
    width: 200,
    height: 150,
    lines: false,
    store: 'product.Menus',
    rootVisible: false,
    iconCls: 'nav'
});