# TAP Official Android SDK

What Is This?
=============
TAP Android SDK allows you to build an Android app that can receive inputs from TAP devices,
In a way that each tap is being interpreted as an array of fingers that are tapped, or as a binary combination integer (explanation follows), Thus allowing the TAP device to act as a controller for your app!

Getting started
===============
To add TAP SDK library to your project:
- Make sure you have JCenter in your Gradle repositories.
- Add the following Gradle dependency to your build.gradle:
```Groovy
  implementation 'com.tapwithus:tap-sdk:1.0.4'
```

Getting instance of TapSdk
==========================
The entry point of TAP SDK is the `com.tapwithus.sdk.TapSdk` class.

If your application might be using the default `TapSdk` instance, a `TapSdk` single instance can be retrieved simply by using the `TapSdkFactory` helper class by calling `TapSdkFactory.getDefault(context)`. This helper method will return a single instance of `TapSdk` relatively to the passed context lifecycle.

If an alternative `TapSdk` instance is required, or if you might be using a dependency injection framework where custom scopes is implemented, call `new TapSdk(context.getApplicationContext(), BluetoothAdapter.getDefaultAdapter())` instead, passing the appropriate arguments.

Key features
============
Once a `TapSdk` instance been instantiated, TAP SDK will start doing his magic, by performing the following actions:
* Auto establishing connections with paired TAP devices, and configurating nessesary TAP configurations in order

Registering TapListener
=======================
`com.tapwithus.sdk.TapListener` is an interface, describing the various data you can retrieve from `TapSdk`. Just implement it and pass it to `TapSdk` class by calling `tapSdk.registerTapListener(tapListener)`.

Debugging
=========
It is often desirable and useful to print out more `TapSdk` inner logs in LogCat. You can manually enable inner log prints by calling `tapSdk.enableDebug()`, and corresponding, you can disable inner log prints by calling `tapSdk.disableDebug`

Example app
===========
The Android Studio project contains an example app where you can see how to use the features of `TapSdk`.

Support
===========
Please refer to the issues tab.
