package com.example.name

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class NameAdapter(
    var nameList:ArrayList<String>,
    val context: Context
):RecyclerView.Adapter<NameAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
    val view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.view.textName.text = nameList[holder.adapterPosition]
    }

    override fun getItemCount(): Int {
     return nameList.size
     }



   inner class viewHolder(var view: View):RecyclerView.ViewHolder(view){

        fun bindItems(){
            view.textName.text = nameList[adapterPosition]
        }

    }


}