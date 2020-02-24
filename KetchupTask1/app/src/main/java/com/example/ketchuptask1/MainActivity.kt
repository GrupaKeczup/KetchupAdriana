package com.example.ketchuptask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import coil.api.load
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imglist = listOf(R.drawable.download, R.drawable.download1, R.drawable.download2,
                            R.drawable.images, R.drawable.images1)

        //val image = File("C:\\Users\\stranadr\\Pictures\\lo.jpg")


        btn_plus.setOnClickListener {
            var num: Int = num_value.text.toString().toInt()
            num_value.text = (++num).toString()
            img.setImageResource(imglist[abs(num%imglist.size)])
        }

        btn_minus.setOnClickListener {
            var num: Int = num_value.text.toString().toInt()
            num_value.text = (--num).toString()
            img.setImageResource(imglist[abs(num%imglist.size)])
        }

        seek_bar.min = 0
        seek_bar.max = 100
        seek_bar.progress = 0
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

        random.setOnClickListener {
            var rng: Int = (0..1000).random()
            val link = "https://i.picsum.photos/id/" + rng.toString() + "/100/100.jpg".toLowerCase()
            //img2.load(link)
            random.text = link
        }
    }
}
