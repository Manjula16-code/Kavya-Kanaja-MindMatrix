package com.example.kavyakanaja.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kavyakanaja.data.model.Poem
import com.example.kavyakanaja.data.repository.PoemRepository
import java.util.Calendar

class PoemViewModel(application: Application)
    : AndroidViewModel(application) {

    private val repository = PoemRepository(application)

    val poems: List<Poem> = repository.getPoems()

    fun getPoemOfTheDay(): Poem {

        val day = Calendar.getInstance()
            .get(Calendar.DAY_OF_YEAR)

        return poems[day % poems.size]
    }
}