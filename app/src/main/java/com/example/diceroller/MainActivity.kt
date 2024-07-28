package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()

        val resultTextView1: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        val congratulation: TextView = findViewById(R.id.textView3)

        resultTextView1.text = diceRoll1.toString()
        resultTextView2.text = diceRoll2.toString()
        if (diceRoll1 == diceRoll2) {
            congratulation.text = "Congratulations! You win!"
        } else {
            congratulation.text = "Try again"
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}