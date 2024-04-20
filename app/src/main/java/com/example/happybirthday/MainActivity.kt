package com.example.happybirthday

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Sends text to GreetingImage Composable
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text),
                        //Sets the Strings to come from res/values/strings.xml so they aren't hardcoded
                    )
                }
            }
        }
    }
}

// Organize and set parameters for App text
@Composable
fun GreetingText(message: String, from: String,  modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        Text(
            text = message,
            fontSize = 100.sp,   //sp = follows screen pixel settings
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp) //dp = set number of pixels regardless of screen settings
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}
// Organize and load background image into app
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    //Load the image from the res.drawable folder
    val image = painterResource(R.drawable.androidparty)
    //Creates a box to move the text to front
    Box(modifier) {
        // Defines the parameters for the image
        Image(
            painter = image,
            contentDescription = null, //Makes the background reader ignore the image
            contentScale = ContentScale.Crop, //Crops the image to make it full screen on all devices
            alpha = 0.5f //Sets the opacity of the image
        )
        // Retrieves info from GreetingText and puts it in the Box
        GreetingText(message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

// Creates initial preview to allow for quick updates
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}