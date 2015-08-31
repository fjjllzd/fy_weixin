/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('app.view.main.Main', {
    extend: 'Ext.window.Window',
    xtype: 'main',
    viewModel: {type: 'main'},
    requires: [
        'Ext.window.MessageBox',
        'app.view.main.MainModel',
        'app.view.main.MainController',
        'app.ux.FyTextField'
    ],
    title: '完善资料',
    resizable: false,
    controller: 'main',
    width: 380,
    bodyPadding: '20 0 0 0',
    closable: false,
    autoShow: true,
    listeners: {
        afterRender: function () {

        }
    },
    items: {
        xtype: 'form',
        reference: 'form',
        items: [
            {
                xtype: 'textfield',
                name: 'name',
                fieldLabel: '姓名',
                labelAlign: 'right',
                bind: '{user.name}',
                labelWidth: 110,
                allowBlank: false,
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'empid',
                labelAlign: 'right',
//                inputType: 'password',
                labelWidth: 110,
                bind: '{user.empid}',
                fieldLabel: '工号',
                allowBlank: false,
                readOnly: true
            }, {
                xtype: 'fytextfield',
                name: 'email',
                labelAlign: 'right',
                bind: '{user.email}',
                labelWidth: 110,
                fieldLabel: '邮箱地址',
                allowBlank: false,
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'cellnumber',
                labelAlign: 'right',
//                inputType: 'password',
                labelWidth: 110,
                fieldLabel: '手机',
                minLength : 11,
                maxLength :11,
                allowBlank: false
            }, {
                xtype: 'textfield',
                name: 'weixinid',
                labelAlign: 'right',
//                inputType: 'password',
                labelWidth: 110,
                fieldLabel: '微信号',
                emptyText:'如您不确定，可不填。',
                allowBlank: true
            }, {
                xtype: 'textfield',
                name: 'depname',
                labelAlign: 'right',
//                inputType: 'password',
                labelWidth: 110,
                fieldLabel: '所属部门',
                id:'depnamefield',
                allowBlank: false,
                emptyText: '点击选择部门',
                listeners:{
                    'focus':'onDepnameFocus'
                }
            }, {
                xtype: 'textfield',
                name: 'cellnumber',
                labelAlign: 'right',
//                inputType: 'password',
                labelWidth: 110,
                fieldLabel: '内部分机号',
                padding: '0 0 10 0',
                allowBlank: true
            }, {
                xtype: 'hiddenfield',
                name: 'depid',
                id:'depidfield',
                allowBlank: true
            }
        ], buttons: [{
                text: '提交',
                formBind: true,
                glyph: 0xf08e,
                listeners: {
                    click: 'onClickButton'
                }
            }]
    }
});
