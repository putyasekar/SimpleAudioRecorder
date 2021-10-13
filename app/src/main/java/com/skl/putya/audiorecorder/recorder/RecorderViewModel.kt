package com.skl.putya.audiorecorder.recorder

import android.arch.lifecycle.ViewModel
import com.skl.putya.audiorecorder.util.RecorderState

class RecorderViewModel(val recorderRepository: RecorderRepository) : ViewModel() {

    var recorderState: RecorderState = RecorderState.Stopped

    fun startRecording() = recorderRepository.startRecording()

    fun stopRecording() = recorderRepository.stopRecording()

    fun pauseRecording() = recorderRepository.pauseRecording()

    fun resumeRecording() = recorderRepository.resumeRecording()

    fun getRecordingTime() = recorderRepository.getRecordingTime()

}