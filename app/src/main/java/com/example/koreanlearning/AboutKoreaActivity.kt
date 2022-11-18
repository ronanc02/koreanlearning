package com.example.koreanlearning

import android.net.Uri
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class AboutKoreaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        setContentView(webView)

//        val uri = Uri.fromFile(File("///android_asset/html/_section1.html"))

        webView.loadUrl("file:///android_asset/html/_section1.html")

    }
}