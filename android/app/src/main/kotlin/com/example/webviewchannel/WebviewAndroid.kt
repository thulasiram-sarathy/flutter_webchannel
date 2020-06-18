package com.matrimonymandaps.vendor

import android.content.Context
import android.view.View
import android.widget.TextView
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.platform.PlatformView
import android.webkit.*
import android.net.http.SslError
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.graphics.Bitmap
import android.webkit.WebViewClient
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant

class WebviewAndroid internal constructor(context: Context, messenger: BinaryMessenger, id: Int) : PlatformView, MethodCallHandler {
    private val webView: WebView
    private val methodChannel: MethodChannel
    private val CHANNEL = "com.matrimonymandaps.vendor/pages/webview/webview"



    override fun getView(): View {
        print("initweb ${webView}");
        return webView
    }

    init {
        webView = WebView(context)
        print("initweb ${webView}");
        methodChannel = MethodChannel(messenger, "webview$id")
        methodChannel.setMethodCallHandler(this)
    }




    override fun onMethodCall(methodCall: MethodCall, result: MethodChannel.Result) {
        when (methodCall.method) {

            "https://www.mandap.com/vendor/leads" -> loadUrl(methodCall, result)
            else -> result.notImplemented()
        }
        print("onMethodCall ${result}");
    }

    private fun loadUrl(methodCall: MethodCall, result: Result) {
        print("loadUrl $result");
        val url = methodCall.arguments as String
        webView.loadUrl(url)
        result.success(null)
    }

    override fun dispose() {
        // TODO dispose actions if needed
    }


}