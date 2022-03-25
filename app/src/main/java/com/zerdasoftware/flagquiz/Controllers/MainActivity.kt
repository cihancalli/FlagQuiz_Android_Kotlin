package com.zerdasoftware.flagquiz.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.zerdasoftware.flagquiz.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseCopy()

        StartButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizScreenActivity::class.java))
        }
    }

    fun databaseCopy() {
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}