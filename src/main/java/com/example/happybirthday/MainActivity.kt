package com.example.happybirthday

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

    }
    private fun rollDice() {
        val dice = Dice(6)
        val rollResult = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView2)
        val diceImage: ImageView = findViewById(R.id.imageView4)
        val luckyNumber = 4
        var t = ' '.toString()
        if (rollResult == luckyNumber) {
            diceImage.setImageResource(R.drawable.dice_4)
                t= "You win!"
            }
        else if (rollResult == 1) {
            diceImage.setImageResource(R.drawable.dice_1)
             t= "So sorry! Try again!"
            }
        else if (rollResult == 2) {
            diceImage.setImageResource(R.drawable.dice_2)
             t= "Sadly, you did not get it. Try again!"
            }
        else if (rollResult == 3) {
            diceImage.setImageResource(R.drawable.dice_3)
             t= "Unfortunately, you are not lucky. Try again!"
            }
        else if (rollResult == 5) {
            diceImage.setImageResource(R.drawable.dice_5)
             t= "Don't cry! Try again!"
            }
        else {
            diceImage.setImageResource(R.drawable.dice_6)
             t= "Apologies! You lost it. Try again!"
        }
        resultTextView.text = t

    }
}
