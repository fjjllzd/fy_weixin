/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('app.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.main',
    requires: 'app.store.User',
    stores: {
        users: {
            type: 'user',
            autoLoad: true
        }
    },
    formulas: {
        user: {
            get: function (get) {
                //debugger;
                return get('users').first();
            }
        }
    }

//TODO - add data, formulas and/or methods to support your view
});
