package com.example.booklist
import Datasource
import ItemAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
        private var isLinearLayoutManager = true

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                val myDataset = Datasource().loadBooks()
                val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
                recyclerView.adapter = ItemAdapter(this, myDataset)
                val button = findViewById<Button>(R.id.layoutbutton)
                button.setOnClickListener {
                        if (isLinearLayoutManager) {
                                isLinearLayoutManager = false
                                button.text = "Linear"
                                recyclerView.layoutManager = GridLayoutManager(this, 3)
                                println()
                        } else {
                                isLinearLayoutManager = true
                                button.text = "Grid"
                                recyclerView.layoutManager = LinearLayoutManager(this)
                                println()
                        }
                }
        }
}





