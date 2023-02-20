package com.cloudchamber.boooostabit

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class BackgroundWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {
    init {
        settings.apply {
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
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        if (visibility != View.GONE) super.onWindowVisibilityChanged(View.VISIBLE)
    }
}