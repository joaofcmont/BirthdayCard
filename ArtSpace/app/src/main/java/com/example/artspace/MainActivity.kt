package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceArtApp()

                }
            }
        }
    }
}

@Composable
fun SpaceArtApp(modifier: Modifier = Modifier) {

    var imageDataBase by remember { mutableIntStateOf((1..3).random()) }

    val image = when (imageDataBase) {
        1 -> painterResource(id = R.drawable.image1)
        2 -> painterResource(id = R.drawable.image2)
        else -> painterResource(id = R.drawable.image3)
    }

    val text = when(imageDataBase) {
        1 -> stringResource(R.string.image1)
        2 -> stringResource(R.string.image2)
        else -> stringResource(R.string.image3)
    }

    val textDescription = when(imageDataBase){
        1 -> stringResource(R.string.image1_description)
        2 -> stringResource(R.string.image2_description)
        else -> stringResource(R.string.image3_description)
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = "$image"
        )
        Column (modifier = Modifier
            .statusBarsPadding()
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 6.dp)
            )
            Text(
                text = textDescription,
                modifier = Modifier.padding(2.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Button(
                onClick = {
                    if (imageDataBase == 1 ) {
                        imageDataBase=3
                    }
                    else if (imageDataBase == 2) {
                        imageDataBase--
                    }
                    else if (imageDataBase == 3) {
                        imageDataBase--

                    }
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(140.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFADD370)),
                shape = RectangleShape
            )
            {
                Text(
                    text = stringResource(R.string.previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.padding(30.dp))
            Button(
                onClick = {
                    if (imageDataBase == 1 ) {
                        imageDataBase++
                    }
                    else if (imageDataBase == 2) {
                        imageDataBase++
                    }
                    else if (imageDataBase == 3) {
                        imageDataBase = 0
                        imageDataBase++

                    }
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(140.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFACD370)),
                shape = RectangleShape
            ) {
                Text(
                    text = stringResource(R.string.next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        SpaceArtApp()
    }
}