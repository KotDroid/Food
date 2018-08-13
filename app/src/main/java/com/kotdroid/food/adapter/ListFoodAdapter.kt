package com.kotdroid.food.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotdroid.food.R
import com.kotdroid.food.activity.ListFoodActivity
import com.kotdroid.food.activity.ScrollingActivity
import com.kotdroid.food.model.ListFoodModel

/**
 * @author Izzedine Eita
 * @version 1.0.0
 * @Email izzedineeita@gmail.com , me@izzedineeita.com
 * @WebSite : izzedineeita.com
 * @Date 8/11/2018
 */

class ListFoodAdapter (val items: ArrayList<ListFoodModel>, val content: Context)
    : RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFoodAdapter.ViewHolder {
        val view = ViewHolder(LayoutInflater.from(content)
                .inflate(R.layout.list_food_item, parent, false))

        return view
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListFoodAdapter.ViewHolder, position: Int) {
        holder.text1!!.text = items[position].textCategory

        holder.img!!.setImageDrawable(
                ContextCompat.getDrawable(content, items[position].imgCategory!!)
        )

        holder.img!!.setOnClickListener {
            val inent = Intent(content, ScrollingActivity::class.java) .apply {
                putExtra("P", position.toString())
                putExtra("text1", holder.text1!!.text)

            }
            content.startActivity(inent)
        }
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var img: ImageView? = null
        var text1: TextView? = null

        init {
            img = view.findViewById(R.id.imgCategory) as ImageView
            text1 = view.findViewById(R.id.textCategory) as TextView
        }
    }
}