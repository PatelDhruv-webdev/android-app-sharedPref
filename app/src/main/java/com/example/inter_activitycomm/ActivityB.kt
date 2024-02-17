package com.example.inter_activitycomm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val length = intent.getDoubleExtra("length", 0.0)
        val width = intent.getDoubleExtra("width", 0.0)
        val area = length * width

        val lengthTextView: TextView = findViewById(R.id.textView2)
        val widthTextView: TextView = findViewById(R.id.textView3)
        val backButton: Button = findViewById(R.id.button2)
        lengthTextView.text = "Length: $length"
        widthTextView.text = "Width: $width"


        Toast.makeText(this, "Area calculated!", Toast.LENGTH_SHORT).show()

        backButton.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("area", area)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
