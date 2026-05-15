package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kavyakanaja.data.model.Poem
import com.example.kavyakanaja.viewmodel.PoemViewModel

@Composable
fun HomeScreen(
    viewModel: PoemViewModel,
    onPoemClick: (Poem) -> Unit,
    onLibraryClick: () -> Unit
) {

    val poem = viewModel.getPoemOfTheDay()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📜 Poem of the Day",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onPoemClick(poem)
                }
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = poem.title,
                    fontSize = 22.sp
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "By ${poem.poet}",
                    fontSize = 16.sp
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = poem.content.take(100) + "...",
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onLibraryClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📚 Open Poetry Library")
        }
    }
}