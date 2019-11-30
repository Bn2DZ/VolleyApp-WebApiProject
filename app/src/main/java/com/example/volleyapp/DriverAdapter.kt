package com.example.volleyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.driver_row.view.*
import kotlin.coroutines.coroutineContext

class DriverAdapter (var context: Context,var list:ArrayList<Driver>): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.driver_row,
            parent, false)

        return MyDriver(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyDriver).show(list[position].name,list[position].mobile)
    }

    class MyDriver(itemView: View): RecyclerView.ViewHolder(itemView)
    {
       fun show(n:String, m:String)
       {
           itemView.driver_name.text = n
           itemView.driver_mobile.text = m
       }
    }

}