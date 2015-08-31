/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Ext.define('app.view.main.DeptreeModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.deptree',
    requires :'app.store.Deptree',
    stores: {
        deptree: {
            type: 'deptree',
            autoLoad: true
        }
    }
//    requires: 'app.store.User',

});
