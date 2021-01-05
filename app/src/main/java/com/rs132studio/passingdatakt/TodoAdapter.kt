package com.rs132studio.passingdatakt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_list_page.view.*

class TodoAdapter (private val tododata: List<Tododata>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_page, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemView.apply {
           add_todo_text.text = tododata[position].title
           todo_checkbox.isChecked = tododata[position].isChecked

       }
    }

    override fun getItemCount(): Int {
        return tododata.size
    }
}