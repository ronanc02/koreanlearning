package com.example.koreanlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koreanlearning.adapter.ItemAdapter
import com.example.koreanlearning.data.Datasource
import com.example.koreanlearning.data.Json
import com.example.koreanlearning.databinding.MainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate with fragments
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}