package com.example.bottomsheetpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), BottomSheet.BottomSheetListener {
    private val button: Button by lazy {
        findViewById(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var array = arrayOf("Sa","Ni","Ka","Va","Na")
        button.setOnClickListener {
            val sheet = BottomSheet(array)
            sheet.show(supportFragmentManager, "sheet")
        }
    }

    override fun buttonClicked(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}