package com.example.booklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat

class BookDetailsActivity : AppCompatActivity() {
    fun getLinearLayoutChilds(linearLayout: LinearLayout):MutableList<View>{
        val childViews= mutableListOf<View>()
        val childCount = linearLayout.childCount
        for (i in 0..childCount-1){
            childViews.add(linearLayout.getChildAt(i))
        }
        return childViews
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_detail)
        println()
        val name=this.resources.getString(intent?.extras!!.getInt("NameStringResourceId"))
        val writer=this.resources.getString(intent?.extras!!.getInt("WriterStringResourceId"))
        val year=this.resources.getString(intent?.extras!!.getInt("yearStringResourceId"))
        val edition=this.resources.getString(intent?.extras!!.getInt("editionStringResourceId"))
        val summery=this.resources.getString( intent?.extras!!.getInt("summeryStringResourceId"))
        val bookDetailsMap= mapOf<String,String>("name" to name,"writer" to writer,"year" to year,
            "edition" to edition,"summery" to summery)
        val bookDetailsKeys=bookDetailsMap.keys.toList()
        val image = ResourcesCompat.getDrawable(this.resources, intent?.extras!!.getInt("imageResourceId"), null)
        val linearLayout:LinearLayout=findViewById(R.id.book_detail)
        var childs=getLinearLayoutChilds(linearLayout)
        val bookCover=childs[0] as AppCompatImageView
        bookCover.setImageDrawable(image)
        val bookDetails=childs[1] as LinearLayout
        childs= getLinearLayoutChilds(bookDetails)
        for (i in 0..childs.size-1){
            val temp=childs[i] as TextView
            temp.text=bookDetailsKeys[i]+": "+bookDetailsMap[bookDetailsKeys[i]]
        }
    }
}