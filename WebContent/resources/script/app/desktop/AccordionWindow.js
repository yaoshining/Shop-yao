/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.AccordionWindow', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.data.TreeStore',
        'Ext.layout.container.Accordion',
        'Ext.toolbar.Spacer',
        'Ext.tree.Panel'
    ],

    id:'acc-win',

    init : function(){
        this.launcher = {
            text: 'QQ',
            iconCls:'accordion'
        };
    },

    createTree : function(){
        var tree = Ext.create('Ext.tree.Panel', {
            id:'im-tree',
            title: '在线用户',
            rootVisible:false,
            lines:false,
            autoScroll:true,
            tools:[{
                type: 'refresh',
                handler: function(c, t) {
                    tree.setLoading(true, tree.body);
                    var root = tree.getRootNode();
                    root.collapseChildren(true, false);
                    Ext.Function.defer(function() { // mimic a server call
                        tree.setLoading(false);
                        root.expand(true, true);
                    }, 1000);
                }
            }],
            store: Ext.create('Ext.data.TreeStore', {
                root: {
                    text:'Online',
                    expanded: true,
                    children:[{
                        text:'朋友',
                        expanded:true,
                        children:[
                            { text:'Brian', iconCls:'user', leaf:true },
                            { text:'Kevin', iconCls:'user', leaf:true },
                            { text:'Mark', iconCls:'user', leaf:true },
                            { text:'Matt', iconCls:'user', leaf:true },
                            { text:'Michael', iconCls:'user', leaf:true },
                            { text:'Mike Jr', iconCls:'user', leaf:true },
                            { text:'Mike Sr', iconCls:'user', leaf:true },
                            { text:'JR', iconCls:'user', leaf:true },
                            { text:'Rich', iconCls:'user', leaf:true },
                            { text:'Nige', iconCls:'user', leaf:true },
                            { text:'Zac', iconCls:'user', leaf:true }
                        ]
                    },{
                        text:'家庭成员',
                        expanded:true,
                        children:[
                            { text:'Kiana', iconCls:'user-girl', leaf:true },
                            { text:'Aubrey', iconCls:'user-girl', leaf:true },
                            { text:'Cale', iconCls:'user-kid', leaf:true }
                        ]
                    }]
                }
            })
        });

        return tree;
    },

    createWindow : function(){
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow('acc-win');

        if (!win) {
            win = desktop.createWindow({
                id: 'acc-win',
                title: 'QQ',
                width: 250,
                height: 400,
                iconCls: 'accordion',
                animCollapse: false,
                constrainHeader: true,
                bodyBorder: Ext.themeName !== 'neptune',
                tbar: {
                    xtype: 'toolbar',
                    ui: 'plain',
                    items: [{
                        tooltip:{title:'登录', text:'登录或断开连接'},
                        iconCls:'connect'
                    },
                    '-',
                    {
                        tooltip:'添加好友',
                        iconCls:'user-add'
                    },
                    ' ',
                    {
                        tooltip:'删除好友',
                        iconCls:'user-delete'
                    }]
                },

                layout: 'accordion',
                border: false,

                items: [
                    this.createTree(),
                    {
                        title: '设置',
                        html:'<p>可以在这添加一些设置。</p>',
                        autoScroll:true
                    },
                    {
                        title: '更多',
                        html : '<p>一些有用的东西。</p>'
                    },
                    {
                        title: '我的东西',
                        html : '<p>更多有用的东西。</p>'
                    }
                ]
            });
        }

        return win;
    }
});
