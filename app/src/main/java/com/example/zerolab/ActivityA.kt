package com.example.zerolab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zerolab.ui.theme.LabBackgroundColor
import com.example.zerolab.ui.theme.ZeroLabTheme

class ActivityA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZeroLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row (modifier = Modifier.padding((innerPadding))){
                        LabButton(
                            text = "Open ActivityB",
                            onClick = { Log.println(Log.INFO,"Lab","Pressed Activity button")},
                        )
                        LabButton(
                            text = "Open FragmentB",
                            onClick = { Log.println(Log.INFO,"Lab","Pressed Fragment button")},
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LabButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    ZeroLabTheme {
        Button(onClick = onClick, modifier = modifier) {
            Text(text = text, modifier = modifier)
        }
    }
}