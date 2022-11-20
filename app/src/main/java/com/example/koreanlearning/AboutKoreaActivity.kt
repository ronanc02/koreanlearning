package com.example.koreanlearning

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.koreanlearning.databinding.AboutKoreaBinding

class AboutKoreaActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate with fragments
        val binding = AboutKoreaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}