package com.example.eventpracticeapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etAge: TextInputEditText
    private lateinit var btnSubmit: Button
    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvOutput = findViewById(R.id.tvOutput)


        btnSubmit.setOnClickListener { view ->
            handleSubmit()
        }
    }

    private fun handleSubmit() {

        val name = etName.text.toString().trim()
        val ageString = etAge.text.toString().trim()

        // Validate that fields are not empty
        if (name.isEmpty() || ageString.isEmpty()) {
            Toast.makeText(
                this,
                "Please fill in all fields.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }


        try {
            val age = ageString.toInt()


            if (age <= 0 || age > 150) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please enter a valid age between 1 and 150",
                    Snackbar.LENGTH_LONG
                ).show()
                return
            }


            val message = "Registration successful!\n\nName: $name\nAge: $age"
            tvOutput.text = message


            Snackbar.make(
                findViewById(android.R.id.content),
                "Data submitted successfully!",
                Snackbar.LENGTH_SHORT
            ).show()

        } catch (e: NumberFormatException) {

            Toast.makeText(
                this,
                "Please enter a valid numeric age.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}