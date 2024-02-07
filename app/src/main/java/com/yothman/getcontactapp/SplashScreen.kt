package com.yothman.getcontactapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.yothman.getcontactapp.databinding.SplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding :SplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}