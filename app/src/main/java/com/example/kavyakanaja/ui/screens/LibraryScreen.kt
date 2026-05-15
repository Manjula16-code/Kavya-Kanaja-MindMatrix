package com.example.kavyakanaja.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kavyakanaja.data.model.Poem

@Composable
fun LibraryScreen(
    poems: List<Poem>,
    onPoemClick: (Poem) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    // Search Filter
    val filteredPoems = poems.filter {

        it.title.contains(
            searchText,
            ignoreCase = true
        ) ||

                it.poet.contains(
                    searchText,
                    ignoreCase = true
                )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Title
        Text(
            text = "📚 Kavya Library",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        OutlinedTextField(
            value = searchText,

            onValueChange = {
                searchText = it
            },

            label = {
                Text("Search Poems")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Scrollable Poems List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),

            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            items(filteredPoems) { poem ->

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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        Text(
                            text = poem.title,
                            fontSize = 22.sp
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = poem.poet,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}