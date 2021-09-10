package com.wsr.weightcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wsr.weightcalculator.di.testModule
import com.wsr.weightcalculator.view.ui.main.MainApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)

            modules(testModule)
        }

        setContent {
            MainApp()
        }
    }
}