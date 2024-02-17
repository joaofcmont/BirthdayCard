package com.example.visitcards

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcards.ui.theme.VisitCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            VisitCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainInformation(stringResource(R.string.title), stringResource(R.string.second_title))
                    SecondInformation(number = stringResource(R.string.number), socials = stringResource(
                        R.string.socials) , email = stringResource(R.string.email) )
                }
            }
        }
    }
}


@Composable
fun MainInformation(name: String,second_name: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Box(modifier = modifier) {
            androidx.compose.material3.Icon(
                Icons.Rounded.Menu, null, modifier.size(70.dp, 70.dp)
            )
        }
        Box(modifier = modifier) {
            Text(
                text = name,
                modifier = modifier,
                fontSize = 40.sp
            )
        }
        Box(modifier = modifier) {
            Text(
                text = second_name,
                modifier = modifier,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SecondInformation(number: String, socials: String, email: String, modifier: Modifier = Modifier) {
        Column(
            modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.padding(8.dp)
            ) {
                Box(modifier = modifier) {
                    androidx.compose.material3.Icon(
                        Icons.Rounded.Person, null, modifier.size(30.dp, 30.dp)
                    )
                }
                Box(modifier = modifier) {
                    Text(
                        text = number,
                        modifier = modifier.padding(6.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier.padding(8.dp)
            ) {
                Box(modifier = modifier) {
                    androidx.compose.material3.Icon(
                        Icons.Rounded.Add, null, modifier.size(30.dp, 30.dp)
                    )
                }
                Box(modifier = modifier) {
                    Text(
                        text = socials,
                        modifier = modifier.padding(6.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.padding(8.dp)
            ) {
                Box(modifier = modifier) {
                    androidx.compose.material3.Icon(
                        Icons.Rounded.Email, null, modifier.size(30.dp, 30.dp)
                    )
                }
                Box(modifier = modifier) {
                    Text(
                        text = email,
                        modifier = modifier.padding(6.dp)
                    )
                }
            }

        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitCardsTheme {
        MainInformation(stringResource(R.string.title), stringResource(R.string.second_title))

    }
}
