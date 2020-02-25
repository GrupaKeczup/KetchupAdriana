package com.example.ketchuptask1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import coil.api.load
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

const val SHARED_PREFS : String = "sharedPrefs";
const val SLIDER_VALUE : String = "0";

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPreferences : SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        txt_slider_value.text = sharedPreferences.getString(SLIDER_VALUE, "0")
        seek_bar.progress = sharedPreferences.getString(SLIDER_VALUE, "0")?.toInt() ?: 0

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
            img2.load(link)
            random.text = link
        }
    }

    override fun onStop() {
        setContentView(R.layout.activity_main)
        var sharedPreferences : SharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        var editor : SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString(SLIDER_VALUE, txt_slider_value.text.toString())
        editor.apply()
        super.onStop()
    }
}
