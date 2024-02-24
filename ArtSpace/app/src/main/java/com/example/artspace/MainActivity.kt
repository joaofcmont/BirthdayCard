package com.example.artspace

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.google.android.material.color.DynamicColors

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
    val imageDataBase by remember {
        mutableIntStateOf(1)
    }
    val image = when(imageDataBase){
        1 -> painterResource(R.drawable.image1)
        2 -> painterResource(R.drawable.image2)
        else -> painterResource(R.drawable.image3)
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
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
                text = "O menino da Pena Brance",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 6.dp)
            )
            Text(
                text = "Jorge (2002)",
                modifier = Modifier.padding(2.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Button(
                onClick = {},
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
                onClick = {},
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