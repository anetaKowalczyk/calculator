package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        oneButton.setOnClickListener { onNumberClicked(1) }
        twoButton.setOnClickListener { onNumberClicked(2) }
        threeButton.setOnClickListener { onNumberClicked(3) }
        fourButton.setOnClickListener { onNumberClicked(4) }
        fiveButton.setOnClickListener { onNumberClicked(5) }
        sixButton.setOnClickListener { onNumberClicked(6) }
        sevenButton.setOnClickListener { onNumberClicked(7) }
        eightButton.setOnClickListener { onNumberClicked(8) }
        nineButton.setOnClickListener { onNumberClicked(9) }
        plusButton.setOnClickListener { onPlusClicked() }
    }

    private var onPlusWasClicked = false


    private fun onPlusClicked() {
        val numberOnTheScreen = screenText.text
        onPlusWasClicked = true
    }

    private fun onNumberClicked(i: Int) {

        if (onPlusWasClicked) {
            screenText.text = i.toString()
            onPlusWasClicked = false

        } else {
            val existingNumber = screenText.text
            val numberToShow = existingNumber.toString() + i.toString()
            screenText.text = numberToShow

        }

    }

}
