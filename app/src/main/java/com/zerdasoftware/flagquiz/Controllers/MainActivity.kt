package com.zerdasoftware.flagquiz.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zerdasoftware.flagquiz.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StartButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizScreenActivity::class.java))
        }
    }
}