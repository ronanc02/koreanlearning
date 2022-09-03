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
//        Inflate without fragments
//        setContentView(R.layout.main)

        // Inflate with fragments
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize data.
//        val json = Json(this).parseJson()
//        val myDataset = Datasource(this, json).loadAffirmations()
//        val myDataset = json?.let { Datasource(this, it).loadAffirmations() }

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.adapter = ItemAdapter(this, myDataset)
//        recyclerView.adapter = myDataset?.let { ItemAdapter(this, it) }

//        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
 //       recyclerView.setHasFixedSize(true)

        //println(Json(this).parseJson().toString())
        //Log.i("data", Json(this).parseJson().toString())

    }
}