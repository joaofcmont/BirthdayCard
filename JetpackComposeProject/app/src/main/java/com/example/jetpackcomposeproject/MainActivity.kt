package com.example.jetpackcomposeproject

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(title = stringResource(R.string.title), text = stringResource(R.string.text), text1 = stringResource(
                        R.string.text1
                    ))
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String,text: String, text1 : String, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)

        )
        Text(
            text = text1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Composable
fun GreetingImage(title: String,text: String,text1: String ,modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(modifier){
       Image(
           painter = image,
           contentDescription = null,
           contentScale = ContentScale.Fit,
           alpha = 0.5F

       )
        GreetingText(message = title,text = text, text1 = text1 ,modifier = Modifier
            .fillMaxSize()
            .padding(8.dp))

   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeProjectTheme {
        GreetingImage(title = stringResource(R.string.title), text = stringResource(R.string.text), text1 = stringResource(
            R.string.text1
        ))
        }
}