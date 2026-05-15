package com.example.kavyakanaja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kavyakanaja.data.model.Poem
import com.example.kavyakanaja.ui.screens.*
import com.example.kavyakanaja.ui.theme.KavyaKanajaTheme
import com.example.kavyakanaja.viewmodel.PoemViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            KavyaKanajaTheme {

                val vm: PoemViewModel = viewModel()

                var showSplash by remember {
                    mutableStateOf(true)
                }

                var selectedPoem by remember {
                    mutableStateOf<Poem?>(null)
                }

                var showPoetScreen by remember {
                    mutableStateOf(false)
                }

                var showLibrary by remember {
                    mutableStateOf(false)
                }

                when {

                    showSplash -> {

                        SplashScreen(
                            onTimeout = {
                                showSplash = false
                            }
                        )
                    }

                    showPoetScreen -> {

                        PoetScreen(
                            onBack = {
                                showPoetScreen = false
                            }
                        )
                    }

                    selectedPoem != null -> {

                        DetailScreen(
                            poem = selectedPoem!!,
                            context = this,

                            onBack = {
                                selectedPoem = null
                            },

                            onPoetClick = {
                                showPoetScreen = true
                            }
                        )
                    }

                    showLibrary -> {

                        LibraryScreen(
                            poems = vm.poems,

                            onPoemClick = {
                                selectedPoem = it
                            }
                        )
                    }

                    else -> {

                        HomeScreen(
                            viewModel = vm,

                            onPoemClick = {
                                selectedPoem = it
                            },

                            onLibraryClick = {
                                showLibrary = true
                            }
                        )
                    }
                }
            }
        }
    }
}