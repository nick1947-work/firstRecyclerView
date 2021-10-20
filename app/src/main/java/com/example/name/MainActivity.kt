package com.example.name

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var nameList:ArrayList<String> = ArrayList();
    var  adapter : NameAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameList.add("kartik")
        nameList.add("Abhishek")
        nameList.add("Atul")
        nameList.add("Rocky")
        nameList.add("Vineet")
        nameList.add("Nikhil")
        nameList.add("Rahul")
        nameList.sortBy { it-> it }
        recycle.layoutManager=LinearLayoutManager(this)
        adapter = NameAdapter(nameList,this)
        recycle.adapter = adapter



    }
    fun add(v:View){

        val name=AlertDialog.Builder(this)
        name.setTitle("Enter Name")
        val input = EditText(this)
        input.setHint("Enter Text")
        input.inputType = InputType.TYPE_CLASS_TEXT
        name.setView(input)
        name.setPositiveButton("Ok"){dialogInterface,i ->    var m_Text = input.text.toString()
            nameList.add(0, m_Text)
            nameList.sortBy { it-> it }
            adapter?.nameList = nameList
            adapter?.notifyDataSetChanged()
        }
        name.setNegativeButton("Cancel"){dialogInterface,i ->
            Toast.makeText(this,"Canceled",Toast.LENGTH_SHORT).show() }
        name.show()
    }


    fun remove(view: View) {
        if(nameList.size>0)
        {
            nameList.removeAt(nameList.size-1)
            adapter?.notifyDataSetChanged()
        }

    }

}