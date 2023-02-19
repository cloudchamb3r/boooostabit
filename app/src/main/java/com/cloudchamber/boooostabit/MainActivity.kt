package com.cloudchamber.boooostabit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var wv : BackgroundWebView
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        wv = findViewById<BackgroundWebView>(R.id.boostabit_view)
        wv.let { wv ->
            wv.apply {
                settings.apply  {
                    useWideViewPort = true
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    loadWithOverviewMode = true
                    builtInZoomControls = false
                    javaScriptCanOpenWindowsAutomatically = false
                    setSupportZoom(false)
                    setSupportMultipleWindows(false)
                    cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                }
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                        view.loadUrl(url)
                        return true
                    }
                }
            }.run {
                loadUrl("https://bustabit.com")
            }
        }
    }

    override fun onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack()
            return
        }
    }
}