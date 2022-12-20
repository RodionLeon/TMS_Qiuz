package com.example.tms_quiz

import android.app.Application
import com.example.tms_quiz.model.Repo
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}