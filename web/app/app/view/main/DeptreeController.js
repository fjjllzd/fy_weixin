/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Ext */

Ext.define('app.view.main.DeptreeController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.deptree',
    onDeptreeClick: function () {
        var t = this.lookupReference('treepanel');
        t.up('window').close();
//        console.log(Ext.getCmp('depidfield'));
        if (t.getSelection().length > 0) {
//            console.log(t.getSelection()[0].get('id'));
            Ext.getCmp('depidfield').setValue(t.getSelection()[0].get('id'));
//            console.log(t.getSelection()[0].get('text'));
            Ext.getCmp('depnamefield').setValue(t.getSelection()[0].get('text'));

        }
    }

});
