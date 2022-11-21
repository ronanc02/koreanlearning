package com.example.koreanlearning

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.koreanlearning.databinding.StartBinding

class StartActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = StartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signin = binding.btnSignin
        val signup = binding.btnSignup

        signin.setOnClickListener() {
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener() {
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

}