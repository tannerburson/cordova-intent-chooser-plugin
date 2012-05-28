PhoneGap/Cordova Intent Chooser Plugin
==========================

The Intent Chooser Plugin provides the system standard Intent Chooser dialog. This allows you to specify a mime-type, text content, and optionally a list of Android package names, to create a filtered list of actions to take on a specific piece of content.

Supported Platforms
-------------------
* Android

**Requires PhoneGap/Cordova 1.7.0+**

Installing the Plugin (Android)
=============

Assuming you have an existing PhoneGap/Cordova Android project:

### Android

* [Download the plugin](https://github.com/tannerburson/cordova-intent-chooser-plugin/downloads)
* Add dist/cordova-intent-chooser-plugin.jar to your projects libs/ directory
* Add dist/cordova-intent-chooser-plugin.js to assets/www

### plugins.xml 

Configure the plugin in res/xml/plugins.xml

    <plugin name="IntentChooserPlugin" value="com.naturalzesty.cordova.plugins.IntentChooserPlugin"/>

IntentChooser
===========

> The plugin provides a single object(IntentChooser) with a single method (show)

Methods
-------

- IntentChooser.show

IntentChooser.show
==============================
Shows an Intent Chooser dialog (calls no callbacks)

    IntentChooser.show(opts);

Parameters
----------
- __opts__: The parameters to pass on to the plugin
    {
      'mime-type'     : 'text/plain',       // required
      'content'       : 'This is my text',  // required
      'package-names' : [ 'mail' ] // optional, does partial string matches, or complete package name matches
    }


License
==============

Copyright (C) 2012 Tanner Burson

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
