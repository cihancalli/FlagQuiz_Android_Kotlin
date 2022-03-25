package com.zerdasoftware.flagquiz.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zerdasoftware.flagquiz.R
import kotlinx.android.synthetic.main.activity_quiz_screen.*

class QuizScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_screen)

        button_A.setOnClickListener {
            startActivity(Intent(this@QuizScreenActivity, ResultScreenActivity::class.java))
            finish()
        }

        button_B.setOnClickListener {
            startActivity(Intent(this@QuizScreenActivity, ResultScreenActivity::class.java))
            finish()
        }

        button_C.setOnClickListener {
            startActivity(Intent(this@QuizScreenActivity, ResultScreenActivity::class.java))
            finish()
        }

        button_D.setOnClickListener {
            startActivity(Intent(this@QuizScreenActivity, ResultScreenActivity::class.java))
            finish()
        }
    }
}