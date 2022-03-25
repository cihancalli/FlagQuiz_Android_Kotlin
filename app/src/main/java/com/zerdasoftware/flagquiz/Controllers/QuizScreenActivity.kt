package com.zerdasoftware.flagquiz.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zerdasoftware.flagquiz.Models.DatabaseHelper
import com.zerdasoftware.flagquiz.Models.FlagDAO
import com.zerdasoftware.flagquiz.Models.FlagModel
import com.zerdasoftware.flagquiz.R
import kotlinx.android.synthetic.main.activity_quiz_screen.*

class QuizScreenActivity : AppCompatActivity() {

    private lateinit var Questions:ArrayList<FlagModel>
    private lateinit var WrongOptions:ArrayList<FlagModel>
    private lateinit var CorrectQuestion:FlagModel
    private lateinit var MixOptionsList:HashSet<FlagModel>
    private lateinit var db:DatabaseHelper

    private var QuestionCount = 0
    private var CorrectCount = 0
    private var WrongCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_screen)

        db = DatabaseHelper(this)

        Questions = FlagDAO().getRandom5(db)

        loadQuestion()

        button_A.setOnClickListener {
            CorrectControl(button_A)
            QuestionCountControl()
        }

        button_B.setOnClickListener {
            CorrectControl(button_B)
            QuestionCountControl()
        }

        button_C.setOnClickListener {
            CorrectControl(button_C)
            QuestionCountControl()
        }

        button_D.setOnClickListener {
            CorrectControl(button_D)
            QuestionCountControl()
        }
    }

    fun loadQuestion() {
        QuestionTextView.text = "${QuestionCount+1} .Flag Question"
        CorrectTextView.text = "Correct: ${CorrectCount}"
        WrongTextView.text = "Wrong: ${WrongCount}"

        CorrectQuestion = Questions.get(QuestionCount)

        FlagImageView.setImageResource(resources.getIdentifier(CorrectQuestion.flag_image,"drawable",packageName))

        WrongOptions = FlagDAO().getRandom3Wrong(db,CorrectQuestion.flag_id)

        MixOptionsList = HashSet()
        MixOptionsList.add(CorrectQuestion)
        MixOptionsList.add(WrongOptions.get(0))
        MixOptionsList.add(WrongOptions.get(1))
        MixOptionsList.add(WrongOptions.get(2))

        button_A.text = MixOptionsList.elementAt(0).flag_name
        button_B.text = MixOptionsList.elementAt(1).flag_name
        button_C.text = MixOptionsList.elementAt(2).flag_name
        button_D.text = MixOptionsList.elementAt(3).flag_name

    }

    fun CorrectControl(button:Button) {
        val ButtonText = button.text.toString()
        val CorrectAnswer = CorrectQuestion.flag_name
        if(ButtonText == CorrectAnswer){
            CorrectCount++
        }else{
            WrongCount++
        }
        CorrectTextView.text = "Correct: ${CorrectCount}"
        WrongTextView.text = "Wrong: ${WrongCount}"
    }

    fun QuestionCountControl() {
        QuestionCount++

        if(QuestionCount != 5){
            loadQuestion()
        }else{
            val intent = Intent(this@QuizScreenActivity, ResultScreenActivity::class.java)
            intent.putExtra("CorrectCount",CorrectCount)
            startActivity(intent)
            finish()
        }
    }
}