package com.bagus.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bagus.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    BirthdayGreeting(
                        name = "Bagos",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Menampilkan gambar latar belakang tanpa tonalElevation atau shadow
        Image(
            painter = painterResource(id = R.drawable.roti_mas), // Tambahkan gambar di drawable
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp)) // Bentuk melengkung
        )

        // Kartu ucapan tanpa tonalElevation atau shadowElevation
        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp)), // Bentuk elegan
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background), // Warna latar belakang elegan
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp) // Hilangkan shadow
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Happy Birthday, $name!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Wishing you all the best on your special day!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingPreview() {
    HappyBirthdayTheme {
        BirthdayGreeting(name = "Bagos")
    }
}
