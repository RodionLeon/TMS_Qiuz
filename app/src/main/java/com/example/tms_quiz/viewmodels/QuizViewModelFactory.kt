package com.example.tms_quiz.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tms_quiz.model.Repo

class QuizViewModelFactory constructor(private val repo: Repo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(this.repo) as T

        } else {
            throw java.lang.IllegalArgumentException("ViewModel not found")
        }
    }
}