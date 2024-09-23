package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //fields
        val firstNum = findViewById<EditText>(R.id.num1)
        val secondNum = findViewById<EditText>(R.id.num2)

        //buttons
        val plusButton = findViewById<Button>(R.id.plus)
        val minusButton = findViewById<Button>(R.id.minus)
        val multiplicationButton = findViewById<Button>(R.id.multiply)
        val divideButton = findViewById<Button>(R.id.divide)

        plusButton.setOnClickListener{
            val num1 = firstNum.text.toString().toDouble()
            val num2 = secondNum.text.toString().toDouble()

            //add
            val total = (num1 + num2).toString()

            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", total)
            startActivity(intent)
        }

        minusButton.setOnClickListener{
            val num1 = firstNum.text.toString().toDouble()
            val num2 = secondNum.text.toString().toDouble()

            //subtract
            val total = (num1 - num2).toString()

            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", total)
            startActivity(intent)
        }

        multiplicationButton.setOnClickListener{
            val num1 = firstNum.text.toString().toDouble()
            val num2 = secondNum.text.toString().toDouble()

            //multiply
            val total = (num1 * num2).toString()

            val intent = Intent(this,CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", total)
            startActivity(intent)
        }

        divideButton.setOnClickListener{
            val num1 = firstNum.text.toString().toDouble()
            val num2 = secondNum.text.toString().toDouble()

            if (num2 != 0.0){
                //divide
                val total = (num1 / num2).toString()

                val intent = Intent(this,CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", total)
                startActivity(intent)
            }
            else{
                val intent = Intent(this,CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", "Error (divide by 0)")
                startActivity(intent)
            }
        }
    }

}