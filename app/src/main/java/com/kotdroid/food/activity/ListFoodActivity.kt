package com.kotdroid.food.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.kotdroid.food.ImageArray
import com.kotdroid.food.R
import com.kotdroid.food.R.id.recycler
import com.kotdroid.food.adapter.ListFoodAdapter
import com.kotdroid.food.model.ListFoodModel
import kotlinx.android.synthetic.main.activity_main.*

class ListFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        val p  = intent.getStringExtra("P")

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ListFoodAdapter(getData(p!!), applicationContext)


    }

    fun getData( p : String): ArrayList<ListFoodModel> {
        //val arrayString = resources.getStringArray(R.array.list_food1)

        var arrayS : Array<String>? = null

        when(p) {
            "0" -> arrayS = resources.getStringArray(R.array.list_food1)
            "1" -> arrayS = resources.getStringArray(R.array.list_food2)
        }

        val array = ArrayList<ListFoodModel>()

        for (i in 0 until arrayS!!.size!!) {
            val model = ListFoodModel()
            model.textCategory = arrayS[i]
            model.imgCategory = ImageArray.imaCategory[i]
            array.add(model)
        }

        return array
    }
}
