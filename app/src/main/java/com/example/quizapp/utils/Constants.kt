package com.example.quizapp.utils

import com.example.quizapp.models.Question
import com.example.quizapp.R

object Constants {

    const val USERNAME = "username"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answers"

    fun getQuestions() : MutableList<Question>{
        val questions = mutableListOf<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.italy,
            "Italy",
            "India",
            "Iran",
            "Ireland",
            1
        )

        questions.add(question1)

        val question2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.argentina,
            "France",
            "Argentina",
            "Iraq",
            "Botswana",
            2
        )

        questions.add(question2)

        val question3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.finland,
            "Norway",
            "Iceland",
            "Poland",
            "Finland",
            4
        )

        questions.add(question3)

        val question4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.india,
            "China",
            "Bangladesh",
            "India",
            "Chile",
            3
        )

        questions.add(question4)

        val question5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.germany,
            "Germany",
            "Denmark",
            "Australia",
            "England",
            1
        )

        questions.add(question5)

        val question6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.romania,
            "Panama",
            "Romania",
            "Sweden",
            "Peru",
            2
        )

        questions.add(question6)

        val question7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.germany,
            "Spain",
            "Denmark",
            "Germany",
            "England",
            3
        )

        questions.add(question7)

        val question8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.nigeria,
            "Ivory Coast",
            "Ghana",
            "South Africa",
            "Nigeria",
            4
        )

        questions.add(question8)

        val question9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.spain,
            "Switzerland",
            "Spain",
            "Canada",
            "Turkey",
            2
        )

        questions.add(question9)

        val question10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.france,
            "France",
            "Somalia",
            "Russia",
            "Japan",
            1
        )

        questions.add(question10)
        return questions
    }
}