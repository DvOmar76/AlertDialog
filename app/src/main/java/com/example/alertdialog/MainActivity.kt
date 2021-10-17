package com.example.alertdialog

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_view.*
import java.lang.IllegalStateException


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow.setOnClickListener {
           alertDialog()
       }
    }

    fun alertDialog(){

        val dialogBuild=AlertDialog.Builder(this)
        val lLayout=LinearLayout(this)
        val tvAlert=TextView(this)
        val edAlert=EditText(this)
        tvAlert.text="tvAlert"
        edAlert.setSingleLine()
        edAlert.hint="enter text"
        lLayout.addView(tvAlert)
        lLayout.addView(edAlert)
        lLayout.setPadding(50,40,50,10)

        dialogBuild.setNegativeButton("TV",DialogInterface.OnClickListener { _, _ ->
            val text=edAlert.text.toString()
            tvAlert.text=text
                Log.d("tvAlert",text)
        })
        dialogBuild.setPositiveButton("Go",DialogInterface.OnClickListener { _, _ ->
            startActivity(Intent(applicationContext,NewPage::class.java))

        })
        val aler=dialogBuild.create()
        aler.setView(lLayout)
        aler.show()
    }




}