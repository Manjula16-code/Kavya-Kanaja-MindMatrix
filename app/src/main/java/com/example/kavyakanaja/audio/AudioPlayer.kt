package com.example.kavyakanaja.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class AudioPlayer(
    private val context: Context
) : TextToSpeech.OnInitListener {

    private var textToSpeech: TextToSpeech = TextToSpeech(context, this)

    private var isInitialized = false

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {

            textToSpeech.language = Locale("kn", "IN")

            isInitialized = true
        }
    }

    fun play(text: String) {

        if (isInitialized) {

            textToSpeech.speak(
                text,
                TextToSpeech.QUEUE_FLUSH,
                null,
                null
            )
        }
    }

    fun stop() {

        textToSpeech.stop()
    }

    fun release() {

        textToSpeech.stop()

        textToSpeech.shutdown()
    }
}