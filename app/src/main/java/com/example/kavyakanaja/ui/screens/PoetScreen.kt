package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PoetScreen(
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        OutlinedButton(
            onClick = {
                onBack()
            }
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Kuvempu",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                "Kuvempu was one of the greatest Kannada poets and writers. " +
                        "He was awarded the Jnanpith Award and served as the Vice Chancellor " +
                        "of Mysore University.",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Famous Works",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text =
                "• Jaya Bharata Jananiya Tanujate\n" +
                        "• Ramayana Darshanam\n" +
                        "• Malegalalli Madumagalu",
            fontSize = 18.sp
        )
    }
}

