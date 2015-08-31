/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


Ext.define('app.model.Deptree', {
    extend: 'Ext.data.TreeModel',
    alias: 'model.deptree',
    idProperty: 'id',
    fields: [
        {
            name: 'id',
            mapping: 'id'
        },
        {name: 'text', mapping: 'name', type: 'string'},
        {name: 'parentid', type: 'int'},
        'leaf'

    ]
});