/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Ext */

Ext.define('app.store.User', {
    extend: 'Ext.data.Store',
    alias: 'store.user',
    model: "app.model.User",
    proxy: {
        type: 'ajax',
        url: '../user/getsession',
        reader: {
            type: 'json',
            rootProperty: 'user'
        }
    },
    listeners: {
        load: function (e, r) {
            //console.log(r[0].data);

        }

    }
});
