package com.vk.directop.validateform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.vk.directop.validateform.navigation.Navigation
import com.vk.directop.validateform.ui.theme.ValidateFormTheme
import com.vk.directop.validateform.utils.sharedPreferences
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {

    private var lastCalculated by sharedPreferences("lastCalculated")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //println("Time from shared preferences ${timeFormatter(lastCalculated)}")
        lastCalculated = System.currentTimeMillis().toString()
        println("Time from shared preferences ${timeFormatter(lastCalculated)}")

        setContent {
            ValidateFormTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

fun timeFormatter(millis: String): String {
    return try {
        SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US).format(Date(millis.toLong()))
    }catch (e: Exception){
        "first start of app"
    }

}
