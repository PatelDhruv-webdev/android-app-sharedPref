package com.example.inter_activitycomm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val lengthEditText: EditText = findViewById(R.id.editTextText2)
        val widthEditText: EditText = findViewById(R.id.editTextText3)
        val calculateAreaButton: Button = findViewById(R.id.button2)
        val areaTextView: TextView = findViewById(R.id.textView)

        calculateAreaButton.setOnClickListener {
            val length = lengthEditText.text.toString().toDoubleOrNull() ?: 0.0
            val width = widthEditText.text.toString().toDoubleOrNull() ?: 0.0
            val intent = Intent(this, ActivityB::class.java).apply {
                putExtra("length", length)
                putExtra("width", width)
            }
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val area = data?.getDoubleExtra("area", 0.0) ?: 0.0
            val areaTextView: TextView = findViewById(R.id.textView)
            Toast.makeText(this, "Area calculated!", Toast.LENGTH_SHORT).show()
            areaTextView.text = "Area from ActivityB: $area"
           

        }
    }
}
