package com.zerdasoftware.flagquiz.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zerdasoftware.flagquiz.R
import kotlinx.android.synthetic.main.activity_result_screen.*

class ResultScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        val CorrectCount = intent.getIntExtra("CorrectCount",0)

        ResultTextView.text = "${CorrectCount} CORRECT - ${5-CorrectCount} WRONG"
        SuccessTextView.text = "% ${CorrectCount*100/5} SUCCESS"

        TryAgainButton.setOnClickListener {
            startActivity(Intent(this@ResultScreenActivity, QuizScreenActivity::class.java))
            finish()
        }
    }
}