package com.example.kavyakanaja.data.model

data class Poem(

    val id: Int,

    val title: String,

    val content: String,

    val meaning: String,

    val poet: String,

    val audio: String,

    var isFavorite: Boolean = false
)