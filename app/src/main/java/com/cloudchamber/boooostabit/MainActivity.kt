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
        wv.loadUrl("https://bustabit.com")
    }

    override fun onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack()
            return
        }
    }
}