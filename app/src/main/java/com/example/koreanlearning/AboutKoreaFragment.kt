package com.example.koreanlearning

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.webkit.WebViewAssetLoader
import com.example.koreanlearning.databinding.FragmentAboutKoreaBinding
import android.webkit.WebView

import android.webkit.WebResourceResponse

import android.webkit.WebResourceRequest

import androidx.annotation.RequiresApi

import androidx.webkit.WebViewClientCompat


class AboutKoreaFragment : Fragment() {

    private var _binding: FragmentAboutKoreaBinding? = null
    private val binding get() = _binding!!

    companion object {
        val SECTION = "section"
    }

    private lateinit var section: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            section = it.getString(AboutKoreaFragment.SECTION).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutKoreaBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView = binding.aboutkoreaWebView

        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(this.requireContext()))
            .build()

        webView.webViewClient = object : WebViewClientCompat() {
            @RequiresApi(21)
            override fun shouldInterceptRequest(
                view: WebView,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }

            // for API < 21
            override fun shouldInterceptRequest(
                view: WebView,
                url: String
            ): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(Uri.parse(url))
            }
        }

//        webView.webViewClient = WebViewClient()
//        webView.settings.allowFileAccess = true
//        webView.settings.allowContentAccess = true
        webView.loadUrl("https://appassets.androidplatform.net/assets/aboutKoreaWebView/$section.html")

//        webView.settings.javaScriptEnabled = true
    }
}