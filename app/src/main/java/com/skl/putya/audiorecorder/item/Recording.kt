package com.skl.putya.audiorecorder.item

import android.content.Context
import com.skl.putya.audiorecorder.R
import com.skl.putya.audiorecorder.player.PlayerRepository
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.recording_layout.view.*

class Recording(val title: String, val context: Context) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.recording_title_textview.text = title
        viewHolder.itemView.recording_image.setOnClickListener {
            PlayerRepository.playRecording(context, title)
        }
    }

    override fun getLayout(): Int {
        return R.layout.recording_layout
    }

}