package com.example.movieinfo
import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        Log.d(TAG, "Coming")
    }

}