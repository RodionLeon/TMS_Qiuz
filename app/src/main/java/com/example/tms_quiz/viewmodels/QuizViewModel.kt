package com.example.tms_quiz.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_quiz.model.Repo

class QuizViewModel(repo: Repo) : ViewModel() {
    val cn = MutableLiveData(0)
    val listSize =repo.data.size

}