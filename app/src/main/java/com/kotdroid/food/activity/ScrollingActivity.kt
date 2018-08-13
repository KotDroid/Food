package com.kotdroid.food.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.kotdroid.food.ImageArray
import com.kotdroid.food.R
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)


        val p = intent.getStringExtra("P")
        val text1 = intent.getStringExtra("text1")
        title = text1.toString()

        //Log.i("DDD", p +" "+ text1)

        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, textContent.text.toString())
            intent.type = "text/palin"
            startActivity(intent)

        }
 val po = ImageArray.categoryNumber
       when(po) {
           "0" -> {
               when(p) {
                   "0" -> {
                       val array = resources.getStringArray(R.array.CategoryContent1)
                       textContent.text = array[0]
                       imgToolBar.setImageDrawable(
                               ContextCompat.getDrawable(applicationContext, ImageArray.imaListFood1[0])
                       )
                   }
                   "1" -> {
                       val array = resources.getStringArray(R.array.CategoryContent1)
                       textContent.text = array[1]
                       imgToolBar.setImageDrawable(
                               ContextCompat.getDrawable(applicationContext, ImageArray.imaListFood1[1])
                       )
                   }
               }
           }
           "1" -> {
               when(p) {
                   "0" -> {
                       val array = resources.getStringArray(R.array.CategoryContent2)
                       textContent.text = array[0]
                       imgToolBar.setImageDrawable(
                               ContextCompat.getDrawable(applicationContext, ImageArray.imaListFood2[0])
                       )
                   }
                   "1" -> {
                       val array = resources.getStringArray(R.array.CategoryContent2)
                       textContent.text = array[1]
                       imgToolBar.setImageDrawable(
                               ContextCompat.getDrawable(applicationContext, ImageArray.imaListFood2[1])
                       )
                   }
               }
           }

       }
    }
}
