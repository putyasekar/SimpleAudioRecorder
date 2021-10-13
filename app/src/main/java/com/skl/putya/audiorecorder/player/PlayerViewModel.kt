package com.skl.putya.audiorecorder.player

import android.arch.lifecycle.ViewModel

class PlayerViewModel(val playerRepository: PlayerRepository) : ViewModel() {

    fun getRecordings() = playerRepository.getRecordings()
}