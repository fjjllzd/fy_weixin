/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Ext.define('app.view.main.Deptree', {
    extend: 'Ext.window.Window',
    requires: ['app.store.Deptree', 'app.view.main.DeptreeController', 'app.view.main.DeptreeModel'],
    xtype: 'deptree',
    viewModel: {},
    title: '选择部门',
    controller: 'deptree',
    width: 380,
    height: 500,
    modal: true,
    autoShow: true,
    closeToolText:'关闭窗口',
    closeAction:'hide',
    items: {
        xtype: 'treepanel',
        reference: 'treepanel',
        rootVisible: false,
        store: 'Deptree',
        height : 455,
        buttons: [
            {
                text: '选定部门',
                glyph: 0xf08e,
                listeners: {
                    click: 'onDeptreeClick'
                }
            }
        ]

    }
});

