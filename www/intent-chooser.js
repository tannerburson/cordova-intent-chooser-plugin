var IntentChooser = {
  show : function(opts,successCallback, failureCallback) {
    return Cordova.exec(    successCallback,    //Success callback from the plugin
      failureCallback,     //Error callback from the plugin
      'IntentChooserPlugin',  //Tell PhoneGap to run "DirectoryListingPlugin" Plugin
      'show',              //Tell plugin, which action we want to perform
      [opts]);        //Passing list of args to the plugin
  }
}
