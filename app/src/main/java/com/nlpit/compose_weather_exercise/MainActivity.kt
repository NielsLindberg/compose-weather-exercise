package com.nlpit.compose_weather_exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.nlpit.compose_weather_exercise.usecases.GlobalComposable
import com.nlpit.compose_weather_exercise.usecases.DI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlobalComposable(state = DI.store.state)
        }
    }
}