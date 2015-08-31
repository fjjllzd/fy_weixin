/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


Ext.define('app.store.Deptree', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.deptree',
    model: "app.model.Deptree",
    lazyFill: true,
    proxy: {
        type: 'ajax',
        url: '../user/getdeptree',
        reader: 'json'
    },
    root: {
        name: 'children',
        expanded: true
    },
    listeners: {
        load: function (e, r) {
            //alert('test');
            //console.log(e);

        }

    }

});