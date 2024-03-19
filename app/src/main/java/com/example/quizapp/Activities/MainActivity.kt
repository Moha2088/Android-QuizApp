package com.example.quizapp.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startButton)
        val editTextName: EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if(editTextName.text.isNotEmpty()){
                Toast.makeText(this,"Welcome to the quiz game ${editTextName.text}", Toast.LENGTH_SHORT)
                    .show()

                Intent(this@MainActivity, QuestionActivity::class.java).also {
                    it.putExtra(Constants.USERNAME,editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            }

            else{
                Toast.makeText(this@MainActivity,
                    "Please enter your name",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}