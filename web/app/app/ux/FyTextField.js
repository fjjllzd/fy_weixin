/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Ext.define('app.ux.FyTextField', {
    extend: 'Ext.form.field.Text',
    xtype: 'fytextfield',
    requires: 'Ext.DomHelper',
    width: 380,
    afterRender: function () {
        this.callParent(arguments);
//        Ext.DomHelper.insertHtml('beforeEnd',this.getEl().dom,'<divt>@fuyaogroup.com</div>');
        Ext.DomHelper.append(this.getEl().dom, '<divt style="padding-left:2px;">@fuyaogroup.com</div>');

    }
});

