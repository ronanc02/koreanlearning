package com.example.koreanlearning

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class AboutKoreaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true

        webView.loadUrl("file:///android_asset/whackAmoleWebView/eatgame.html")

        setContentView(webView)

//        val uri = Uri.fromFile(File("///android_asset/html/_section1.html"))

//        webView.loadUrl("file:///android_asset/aboutKoreaWebView/_section1.html")


    }
}