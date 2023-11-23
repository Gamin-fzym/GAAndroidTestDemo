package com.example.gatestdemol

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class  MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        var tv = findViewById<TextView>(R.id.tvid);
        tv.text = "Hello World! Change"
    }

}