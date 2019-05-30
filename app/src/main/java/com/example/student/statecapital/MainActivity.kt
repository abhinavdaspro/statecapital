package com.example.student.statecapital

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val state= arrayOf("odisha","west bengal","tamilnadu","andhra pradesh","bihar","madhya pradesh")
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val capital= arrayOf("bhubaneswar","kolkata","chennai","hyderabaad","patna","bhopal")
        val search=findViewById<AutoCompleteTextView>(R.id.search)
        val text=findViewById<TextView>(R.id.textView)

        val adp= ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,state)
        search.setAdapter(adp)
        search.threshold=1
        search.setOnItemClickListener { parent, view, position, id ->
           val pos:String= parent.getItemAtPosition(position).toString()
            Toast.makeText(this,pos,Toast.LENGTH_LONG).show()
            val catch:Int=getCapital(pos)
            text.setText(capital[catch])
            }
        }
    fun getCapital(rajya: String):Int
      {   var i=0
         for (s in state) {
             if (rajya == s) {
                 return i
             }
             i++
         }
          return i
      }
}
