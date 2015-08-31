/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Ext.define('app.store.Department', {
    extend: 'Ext.data.Store',
    alias: 'store.department',
    model: "app.model.Department",
    proxy: {
        type: 'ajax',
        url: 'depfromwx',
        reader: {
            type: 'json',
            rootProperty: 'department'
        }
    },
    listeners: {
        load: function (e, r) {
            //console.log(r[0].data);
        }
    }
});
