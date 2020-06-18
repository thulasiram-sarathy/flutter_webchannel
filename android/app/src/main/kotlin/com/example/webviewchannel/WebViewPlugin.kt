package com.matrimonymandaps.vendor

import io.flutter.plugin.common.PluginRegistry.Registrar

 object WebViewPlugin {
     fun registerWith(registrar: Registrar) {
        registrar
                .platformViewRegistry()
                .registerViewFactory(
                        "webview", WebViewFactory(registrar.messenger()))
    }
}
//WebViewPlugin.registerWith(this.registrarFor("com.matrimonymandaps.vendor"))