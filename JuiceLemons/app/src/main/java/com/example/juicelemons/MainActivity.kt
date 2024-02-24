package com.example.juicelemons

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var tapCount by remember { mutableStateOf(0) }
    var result by remember {
        mutableIntStateOf(1)
    }
    var requiredTaps by remember { mutableStateOf((1..3).random()) }

    val imageResource = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else ->  R.drawable.lemon_restart
    }

    val textShowed = when(result){
        1 -> stringResource(R.string.Lemon_tree)
        2 -> stringResource(R.string.Lemon)
        3 -> stringResource(R.string.Glass_of_lemonade)
        else -> stringResource(R.string.Empty_glass)
    }

    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)  {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "$imageResource",
            modifier = Modifier.clickable {
                tapCount++

                if(tapCount == requiredTaps){
                    result = (result % 4) + 1
                    //reset tap count
                    tapCount=0
                    //reset the require taps to 1 from 3
                    requiredTaps = (1..3).random()
                }
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = textShowed
            , fontSize = 18.sp)}


    }


@Preview()
@Composable
fun LemonadeApp() {
        LemonadeImageAndText(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}