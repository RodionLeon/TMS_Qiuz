package com.example.tms_quiz

import android.app.Application
import com.example.tms_quiz.model.Repo

class MyApplication : Application() {
    lateinit var repo: Repo
    override fun onCreate() {
        super.onCreate()
        repo = Repo()
    }
}