package com.example.bitfit1

import android.app.Application

class SleepApplication: Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}