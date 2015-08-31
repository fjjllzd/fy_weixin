/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Ext */

Ext.define('app.model.User', {
    extend: 'Ext.data.Model',
    alias: 'model.user',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'name', type: 'string'},
        {name: 'empid', type: 'string'},
        {name: 'email', type: 'string'},
        {name: 'depid', type: 'int'},
        {name: 'weixinid', type: 'string'},
        {name: 'cellnumber', type: 'string'},
        {name: 'extnumber', type: 'string'}
    ]
});
