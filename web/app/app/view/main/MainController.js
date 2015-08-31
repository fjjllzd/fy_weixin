/* global Ext */

/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('app.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',
    requires: 'app.view.main.Deptree',
    onDepnameFocus: function () {
        Ext.create({
            xtype: 'deptree'
        });
    },
    onClickButton: function () {

        var form = this.getView().down('form').getForm();
        var cellnumber = this.getView().down('textfield[name=cellnumber]').getValue();
        var weixinid = this.getView().down('textfield[name=weixinid]').getValue();
        console.log(cellnumber);
        console.log(weixinid)
//        // Remove the localStorage key/value
//        localStorage.removeItem('appLoggedIn');
//
//        // Remove Main View
//        this.getView().destroy();
//
//        // Add the Login Window
//        Ext.create({
//            xtype: 'login'
//        });


    }
});

