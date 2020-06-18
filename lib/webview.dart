import 'dart:async';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

typedef void WebViewCreatedCallback(WebViewController controller);

class WebView extends StatefulWidget {
  const WebView({
    Key key,
    this.onWebViewCreated,
  }) : super(key: key);

  final WebViewCreatedCallback onWebViewCreated;

  @override
  State<StatefulWidget> createState() => WebViewState();
}

class WebViewState extends State<WebView> {
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(
        viewType: 'webview',
        onPlatformViewCreated: _onPlatformViewCreated,
      );
    }
    // TODO add other platforms
    return Text(
        '$defaultTargetPlatform is not yet supported by the map view plugin');
  }

  void _onPlatformViewCreated(int id) {
    print("_onPlatformViewCreated ${widget.onWebViewCreated}");
    if (widget.onWebViewCreated == null) {
      print("_onPlatformViewCreated1");
      return;
    }
    print("_onPlatformViewCreated");
    widget.onWebViewCreated(new WebViewController(id));
  }
}

class WebViewController {
  WebViewController(int id) {
    this._channel = new MethodChannel('webview$id');
    print("WebViewController ${this._channel}");
  }

  MethodChannel _channel;

  Future<void> loadUrl(String url) async {
    print("WebViewController1 ${url}");
    return _channel.invokeMethod('loadUrl', url);
  }
}