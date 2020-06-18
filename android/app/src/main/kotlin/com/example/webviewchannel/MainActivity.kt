package com.example.webviewchannel

import android.os.Bundle
import com.matrimonymandaps.vendor.WebViewPlugin

import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        GeneratedPluginRegistrant.registerWith(this)
        WebViewPlugin.registerWith(this.registrarFor("com.example.webviewchannel"))
    }
}
