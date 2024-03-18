package com.example.quizapp.Activities

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.models.Question
import com.example.quizapp.utils.Constants


class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var checkButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var progressTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var imageFlag: ImageView

    private lateinit var option1TextView: TextView
    private lateinit var option2TextView: TextView
    private lateinit var option3TextView: TextView
    private lateinit var option4TextView: TextView


    private var questionsCounter = 0
    private lateinit var questionList: MutableList<Question>
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        checkButton = findViewById(R.id.answerButton)
        progressBar = findViewById(R.id.progressBar)
        progressTextView = findViewById(R.id.progressTextView)
        questionTextView = findViewById(R.id.questionTextView)
        imageFlag = findViewById(R.id.imageFlag)

        option1TextView = findViewById(R.id.option1textView)
        option2TextView = findViewById(R.id.option2textView)
        option3TextView = findViewById(R.id.option3textView)
        option4TextView = findViewById(R.id.option4textView)

        option1TextView.setOnClickListener(this)
        option2TextView.setOnClickListener(this)
        option3TextView.setOnClickListener(this)
        option4TextView.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        questionList = Constants.getQuestions()
        showNextQuestion()
    }

    private fun showNextQuestion() {
        resetOptions()
        val question = questionList[questionsCounter]
        imageFlag.setImageResource(question.image)
        progressBar.progress = questionsCounter
        progressTextView.text = "${questionsCounter + 1}/${progressBar.max}"
        questionTextView.text = question.question
        option1TextView.text = question.optionOne
        option2TextView.text = question.optionTwo
        option3TextView.text = question.optionThree
        option4TextView.text = question.optionFour

        if (questionsCounter < questionList.size) {
            currentQuestion = questionList[questionsCounter]
            checkButton.text == "Check"
        } else {
            checkButton.text = "Finish!"
        }

        questionsCounter++
        answered = false
    }

    private fun resetOptions() {
        val options = mutableListOf(
            option1TextView,
            option2TextView,
            option3TextView,
            option4TextView
        )

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()
        selectedAnswer = selectedOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option1textView -> {
                selectedOption(option1TextView, 1)
            }

            R.id.option2textView -> {
                selectedOption(option2TextView, 2)
            }

            R.id.option3textView -> {
                selectedOption(option3TextView, 3)
            }

            R.id.option4textView -> {
                selectedOption(option4TextView, 4)
            }

            R.id.answerButton -> {
                if (!answered) {
                    checkAnswer()
                } else {
                    showNextQuestion()
                }

                selectedAnswer = 0
            }
        }
    }

    private fun checkAnswer() {
        answered = true

        if (selectedAnswer == currentQuestion.correctAnswer) {
            when (selectedAnswer) {
                1 -> {
                    option1TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.correct_option_border_bg)
                }

                2 -> {
                    option2TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.correct_option_border_bg)
                }

                3 -> {
                    option3TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.correct_option_border_bg)
                }

                4 -> {
                    option4TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.correct_option_border_bg)
                }
            }
        } else {
            when (selectedAnswer) {
                1 -> {
                    option1TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.wrong_option_border_bg)
                }

                2 -> {
                    option2TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.wrong_option_border_bg)
                }

                3 -> {
                    option3TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.wrong_option_border_bg)
                }

                4 -> {
                    option4TextView.background = ContextCompat
                        .getDrawable(this, R.drawable.wrong_option_border_bg)
                }
            }
        }

        checkButton.text = "Next"
        showSolution();
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer

        when(selectedAnswer){
            1 -> {
                option1TextView.background = ContextCompat
                    .getDrawable(this, R.drawable.correct_option_border_bg)
            }

            2 -> {
                option2TextView.background = ContextCompat
                    .getDrawable(this, R.drawable.correct_option_border_bg)
            }

            3 -> {
                option3TextView.background = ContextCompat
                    .getDrawable(this, R.drawable.correct_option_border_bg)
            }

            4 -> {
                option4TextView.background = ContextCompat
                    .getDrawable(this, R.drawable.correct_option_border_bg)
            }
        }
    }
}