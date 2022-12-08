package com.example.tms_quiz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.tms_quiz.R
import com.example.tms_quiz.viewmodels.MyApplication
import com.example.tms_quiz.viewmodels.QuizViewModel
import com.example.tms_quiz.viewmodels.QuizViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, QuizViewModelFactory((application as MyApplication).repo))
                .get(QuizViewModel::class.java)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }
}