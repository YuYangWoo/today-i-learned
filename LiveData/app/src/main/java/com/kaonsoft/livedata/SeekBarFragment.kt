package com.kaonsoft.livedata

import android.widget.SeekBar
import com.kaonsoft.livedata.databinding.FragmentSeekBarBinding

class SeekBarFragment : BaseFragment<FragmentSeekBarBinding>(R.layout.fragment_seek_bar) {

    override fun init() {
        super.init()
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        }
        )
    }
}