package com.niuanqi.js;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private WebView webView;

    @SuppressLint("javascriptinterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        webView.addJavascriptInterface(this, "ghgh");
        webView.loadUrl("file:///android_asset/main.html");
    }

    @JavascriptInterface
    public void say(String str) {
        Log.d("调用", str);
    }


    public void onclick(View v) {

        webView.loadUrl("javascript:acj()");

    }
}
