/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Ext */

Ext.define('app.view.login.Login', {
    extend: 'Ext.window.Window',
    xtype: 'login',
    resizable: false,
    requires: [
        'app.view.login.LoginController',
        'Ext.form.Panel',
        'app.ux.FyTextField'
    ],
    initComponent: function () {
        Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性  
        this.callParent();
    },
    controller: 'login',
    bodyPadding: '20 0 0 0',
    title: '微信企业号自助申请平台',
    width: 380,
    closable: false,
    autoShow: true,
    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
                xtype: 'textfield',
                name: 'name',
                fieldLabel: '姓名',
                labelAlign: 'right',
                labelWidth: 110,
                allowBlank: false
            }, {
                xtype: 'textfield',
                name: 'empid',
                labelAlign: 'right',
//                inputType: 'password',
                labelWidth: 110,
                fieldLabel: '工号',
                allowBlank: false
            }, {
                xtype: 'fytextfield',
                name: 'email',
                labelAlign: 'right',
                labelWidth: 110,
                fieldLabel: '邮箱地址',
                allowBlank: false,
                padding: '0 0 10 0'
            }],
        buttons: [{
                text: '开始验证',
                formBind: true,
                glyph: 0xf08e,
                listeners: {
                    click: 'onLoginClick'
                }
            }]
    }
});
