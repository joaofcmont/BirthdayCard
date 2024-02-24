package com.example.juicelemons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.juicelemons.ui.theme.JuiceLemonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuiceLemonsTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeImageAndText(modifier: Modifier = Modifier) {
    Column (modifier){
        Button(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(R.drawable.lemon_tree), contentDescription = "Lemon Tree")
        }
    }
}

@Preview()
@Composable
fun LemonadeApp() {
        LemonadeImageAndText(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}