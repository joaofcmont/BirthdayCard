package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(title = stringResource(R.string.text), name = stringResource(R.string.text1))
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String,text: String, modifier: Modifier = Modifier) {
    Box (modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = message,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(top = 24.dp, bottom = 8.dp)

            )
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(8.dp)

            )
        }
    }
}
@Composable
fun GreetingImage(title: String, name: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed) // Replace with your image resource
    Column(modifier=modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        GreetingText(
            message = title,
            text = name,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        GreetingImage(stringResource(R.string.text), stringResource(R.string.text1) )
    }
}
