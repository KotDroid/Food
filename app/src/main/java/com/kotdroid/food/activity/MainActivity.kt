package com.kotdroid.food.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotdroid.food.ImageArray
import com.kotdroid.food.R
import com.kotdroid.food.model.HomeModel
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.GridLayoutManager
import com.kotdroid.food.adapter.HomeAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = HomeAdapter(getData(), applicationContext)



    }

    fun getData() : ArrayList<HomeModel> {
        val arrayString = resources.getStringArray(R.array.category1)

        val array = ArrayList<HomeModel>()

        for (i in 0 until arrayString.size!!) {
            val model = HomeModel()
            model.textCategory = arrayString[i]
            model.imgCategory = ImageArray.imaCategory[i]
            array.add(model)
        }

        return array
    }

}
