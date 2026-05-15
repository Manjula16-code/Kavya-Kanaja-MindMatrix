// DetailScreen.kt

package com.example.kavyakanaja.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kavyakanaja.audio.AudioPlayer
import com.example.kavyakanaja.data.model.Poem
import androidx.compose.material3.AssistChip

@Composable
fun DetailScreen(
    poem: Poem,
    context: Context,
    onBack: () -> Unit,
    onPoetClick: () -> Unit
) {

    var selectedWord by remember {
        mutableStateOf("")
    }

    var showMeaning by remember {
        mutableStateOf(false)
    }

    val player = remember {
        AudioPlayer(context)
    }

    // Word meanings dictionary
    val meanings = mapOf(
        "ಬೆಳಗಿನ" to "Morning",
        "ಸೂರ್ಯ" to "Sun",
        "ಹೊಸ" to "New",
        "ಬೆಳಕು" to "Light",
        "ಹಸಿರು" to "Green",
        "ಗಾಳಿ" to "Breeze",

        "ಮಳೆಯ" to "Rain",
        "ಹನಿ" to "Drop",
        "ಭೂಮಿ" to "Earth",
        "ಪ್ರಕೃತಿ" to "Nature",

        "ಸ್ನೇಹ" to "Friendship",
        "ಜೀವನ" to "Life",
        "ಧೈರ್ಯ" to "Courage",

        "ತಾಯಿ" to "Mother",
        "ಮಮತೆ" to "Affection",

        "ಶಾಲೆ" to "School",
        "ಜ್ಞಾನ" to "Knowledge",

        "ಕನ್ನಡ" to "Kannada",
        "ನಾಡು" to "Land",
        "ಜಯ" to "Victory",
        "ಭಾರತ" to "India",
        "ಜನನಿಯ" to "Motherland",
        "ತನುಜಾತೆ" to "Daughter",
        "ಹೇ" to "Oh!",
        "ಕರ್ನಾಟಕ" to "Karnataka",
        "ಮಾತೆ" to "Mother",

        "ಸುಂದರ" to "Beautiful",
        "ನದಿ" to "River",
        "ವನಗಳ" to "Forests",
        "ನಾಡೇ" to "Land",
        "ರಸಋಷಿಗಳ" to "Saints of wisdom and culture",
        "ಬೀಡೆ" to "Abode",

        "ಭೂದೇವಿಯ" to "Earth Goddess'",
        "ಮಕುಟದ" to "Of the crown",
        "ನವಮಣಿಯೆ" to "Precious gem",
        "ಗಂಧದ" to "Fragrant",
        "ಚಂದದ" to "Beauty",
        "ಹೊನ್ನಿನ" to "Golden",
        "ಗಣಿಯೆ" to "Treasure mine",

        "ಜೋಗುಳ" to "Lullaby",
        "ವೇದದ" to "Vedic",
        "ಘೋಷ" to "Sacred sound",

        "ಹಸುರಿನ" to "Green",
        "ಗಿರಿಗಳ" to "Mountains",
        "ಮಾಲೆ" to "Garland",

        "ಶಾಂತಿಯ" to "Peace",
        "ತೋಟ" to "Garden",

        "ಕನ್ನಡ" to "Kannada",
        "ನುಡಿ" to "Language",
        "ಮಕ್ಕಳ" to "Children"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF8E7),
                        Color(0xFFFFE0B2)
                    )
                )
            )
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        // Back Button
        OutlinedButton(
            onClick = {
                onBack()
            }
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = poem.title,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Lyrics Card
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {

                Text(
                    text = poem.content,
                    fontSize = 22.sp
                )
            }
        }

        Text(
            text = "Difficult Words",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        val wordsToShow = meanings.keys.take(8)

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            wordsToShow.chunked(2).forEach { rowWords ->

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    rowWords.forEach { word ->

                        AssistChip(
                            onClick = {
                                selectedWord = word
                                showMeaning = true
                            },

                            label = {
                                Text(word)
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Meaning Section
        Text(
            text = "Meaning",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = poem.meaning,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Poet Section
        Text(
            text = "Poet: ${poem.poet}",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                onPoetClick()
            }
        ) {
            Text("View Poet Info")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Audio Controls
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Button(
                onClick = {
                    player.play(poem.content)
                }
            ) {
                Text("▶ Play")
            }

            Button(
                onClick = {
                    player.stop()
                }
            ) {
                Text("⏹ Stop")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }

    // Meaning Popup
    if (showMeaning) {

        AlertDialog(

            onDismissRequest = {
                showMeaning = false
            },

            confirmButton = {

                Button(
                    onClick = {
                        showMeaning = false
                    }
                ) {
                    Text("OK")
                }
            },

            title = {
                Text("Word Meaning")
            },

            text = {

                Text(
                    "${selectedWord}\n\nMeaning:\n${
                        meanings[selectedWord]
                            ?: "Meaning not available"
                    }"
                )
            }
        )
    }
}