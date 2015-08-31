/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Ext */

Ext.define('app.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',
    onLoginClick: function () {
//
//        localStorage.setItem("appLoggedIn", true);
//        this.getView().destroy();
//        Ext.create({
//            xtype: 'app-main'
//        });

        var form = this.getView().down('form').getForm();
        var view = this.getView();
        if (form.isValid()) {
            form.submit({
                url: '../user/check',
                params: {},
                success: function (form, action) {
                    Ext.Msg.alert('提示', action.result.msg, function () {
                        view.destroy();
                        Ext.create({
                            xtype: 'main'
                        });
                    });
                },
                failure: function (form, action) {
                    Ext.Msg.alert('提示', action.result.msg);
                }
            });
        }
    }
});