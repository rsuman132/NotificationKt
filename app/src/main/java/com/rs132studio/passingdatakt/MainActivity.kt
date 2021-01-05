package com.rs132studio.passingdatakt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_btn.setOnClickListener {
            val name = enter_name.text.toString()
            val country = enter_country.text.toString()
            val phone = enter_phone.text.toString()
            Intent(this, ShowInfo::class.java).also {
                it.putExtra("PERSON_NAME", name)
                it.putExtra("PERSON_COUNTRY", country)
                it.putExtra("PERSONAL_NUMBER", phone)
                startActivity(it)
            }

        }

       val todolist = mutableListOf(
           Tododata("Waking up in 5:45 am", true),
           Tododata("Brushing my teeth", true),
           Tododata("Daily Exercise for 30 minutes", false),
           Tododata("Bathing", true),
           Tododata("Devotional time", true),
           Tododata("Speaking to my parents via phone call", true),
           Tododata("Using Mobile", true)

       )
        val adapter = TodoAdapter(todolist)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        add_Btn.setOnClickListener {
            val makeTodo = todo_ET.text.toString()
            val check_condition = Tododata(makeTodo, true)
            todolist.add(check_condition)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todolist.size-1)
        }

    }
}