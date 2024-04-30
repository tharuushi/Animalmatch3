package com.example.animalmatch3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class gameplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        // Define images representing animals
        val images: MutableList<Int> =
            mutableListOf(
                R.drawable.cow, R.drawable.bird, R.drawable.dog,
                R.drawable.elephant, R.drawable.fish, R.drawable.pig,
                R.drawable.cow, R.drawable.bird, R.drawable.dog,
                R.drawable.elephant, R.drawable.fish, R.drawable.pig
            )

        // Array of buttons representing cards
        val buttons = arrayOf(
            findViewById<Button>(R.id.btn1), findViewById<Button>(R.id.btn2),
            findViewById<Button>(R.id.btn3), findViewById<Button>(R.id.btn4),
            findViewById<Button>(R.id.btn5), findViewById<Button>(R.id.btn6),
            findViewById<Button>(R.id.btn7), findViewById<Button>(R.id.btn8),
            findViewById<Button>(R.id.btn9), findViewById<Button>(R.id.btn10),
            findViewById<Button>(R.id.btn11), findViewById<Button>(R.id.btn12)
        )

        // Define the card back image
        val cardBack = R.drawable.paws_bg
        var clicked = 0    // Counter for how many cards are clicked
        var turnOver = false   // Flag to indicate if cards are turning over
        var lastClicked = -1   // Index of the last clicked card

        images.shuffle()
        // Loop through all buttons
        for (i in buttons.indices) {
            buttons[i].setBackgroundResource(cardBack)
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                // If the card is facing down and it's not turning over
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])   //Set the card's image
                    buttons[i].text = images[i].toString()   //Set the text of the card to the animal's name
                    if (clicked == 0) {
                        lastClicked = i   //If it's the first card clicked, store its index
                    }
                    clicked++
                } else if (buttons[i].text !in "cardBack") {   //If the card is facing up
                    buttons[i].setBackgroundResource(cardBack)   //Flip the card back
                    buttons[i].text = "cardBack"   //Set the text to identify the back of the card
                    clicked--
                }

                // Check if two cards are clicked
                if (clicked == 2) {
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false   // Disable clicking on the matched cards
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {     // If no cards are clicked
                    turnOver = false   // Set turning over flag to false
                }
            }
        }
    }
}
