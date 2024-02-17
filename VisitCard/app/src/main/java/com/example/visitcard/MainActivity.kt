package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstInformation("Full Name", "Title")
                }
            }
        }
    }
}

@Composable
fun FirstInformation(name: String,title: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier.fillMaxSize()){

        Text(
            text = name,
            modifier = Modifier.fillMaxSize(),
            fontSize = 40.sp
        )
        Text(
            text = title,
            modifier = Modifier.fillMaxSize(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
           Icons.Rounded.Home,
           contentDescription = null)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitCardTheme {
        FirstInformation("Full Name", "Title")
    }
}