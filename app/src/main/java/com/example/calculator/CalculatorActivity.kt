package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        equalsButton.setOnClickListener { onEqualsClicked() }
    }

    val calculator = com.example.calculator.Calculator()

    private var onPlusWasClicked = false
    private var onEqualsClicked = false
    private var numberOnTheScreen: Int = 0


    private fun onPlusClicked() {
        numberOnTheScreen = screenText.text.toString().toInt()
        onPlusWasClicked = true
    }

    private fun onEqualsClicked() {
        onEqualsClicked = true
        val currentScreenText = screenText.text.toString().toInt()
        val result = calculator.add(currentScreenText, numberOnTheScreen)

        screenText.text = result.toString()

    }

    private fun onNumberClicked(i: Int) {

        if (onPlusWasClicked) {
            screenText.text = i.toString()
            onPlusWasClicked = false


        } else if (onEqualsClicked) {
            screenText.text = i.toString()
            onEqualsClicked = false
            numberOnTheScreen = 0
        } else {
            val existingNumber = screenText.text
            val numberToShow = existingNumber.toString() + i.toString()
            screenText.text = numberToShow
        }

    }

}
