package com.example.ketchuptask1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.ProgressBar
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener {
            var num: Int = num_value.text.toString().toInt()
            num_value.text = (++num).toString()
        }

        btn_minus.setOnClickListener {
            var num: Int = num_value.text.toString().toInt()
            num_value.text = (--num).toString()
        }

        seek_bar.min = 0;
        seek_bar.max = 100;
        seek_bar.progress = 0;
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
            {
                txt_slider_value.text = seekBar?.progress.toString()
                //To change body of created functions use File | Settings | File Templates.
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}