package com.skl.putya.audiorecorder.player

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class PlayerViewModelProvider(val playerRepository: PlayerRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlayerViewModel(playerRepository) as T
    }
}