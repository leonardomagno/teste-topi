package com.example.testetopi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashTransition()
    }

    fun splashTransition() {
        val intent = Intent(this@SplashActivity, RepositoriesListActivity::class.java)

        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, 3000)
    }
}