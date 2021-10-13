package com.skl.putya.audiorecorder.util

import com.skl.putya.audiorecorder.player.PlayerRepository
import com.skl.putya.audiorecorder.player.PlayerViewModelProvider
import com.skl.putya.audiorecorder.recorder.RecorderRepository
import com.skl.putya.audiorecorder.recorder.RecorderViewModelProvider

object InjectorUtils {
    fun provideRecorderViewModelFactory(): RecorderViewModelProvider {
        val recorderRepository = RecorderRepository.getInstance()
        return RecorderViewModelProvider(recorderRepository)
    }

    fun provideRecordingViewModelFactory(): PlayerViewModelProvider {
        val recordingRepository = PlayerRepository.getInstance()
        return PlayerViewModelProvider(recordingRepository)
    }
}