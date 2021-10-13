package com.skl.putya.audiorecorder.player

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.skl.putya.audiorecorder.R
import com.skl.putya.audiorecorder.item.Recording
import com.skl.putya.audiorecorder.util.InjectorUtils
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_recordings.*

class PlayerActivity : AppCompatActivity() {

    private var viewModel: PlayerViewModel? = null
    private lateinit var groupAdapter: GroupAdapter<ViewHolder>
    private var data: ArrayList<String>? = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordings)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        groupAdapter = GroupAdapter<ViewHolder>()

        initUI()
    }

    override fun onStart() {
        super.onStart()

        //Ably the span count and the adapter to the recyclerview
        recordings_recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
    }

    private fun initUI() {
        //Get the viewmodel factory
        val factory = InjectorUtils.provideRecordingViewModelFactory()

        //Getting the viewmodel
        viewModel = ViewModelProviders.of(this, factory).get(PlayerViewModel::class.java)

        updateAdapter()
    }

    private fun updateAdapter() {
        data = viewModel?.getRecordings()
        println("Updating Adapter")
        groupAdapter.clear()

        if (data != null) {
            data!!.forEach {
                println("Data: $it")
                groupAdapter.add(Recording(it, this))
            }
        }
    }
}
