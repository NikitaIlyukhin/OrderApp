package com.example.itfbtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.ArithmeticException

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var var1: EditText
    private lateinit var var2: EditText
    private lateinit var varOperation: EditText
    private lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        var1 = findViewById(R.id.var1)
        var2 = findViewById(R.id.var2)
        varOperation = findViewById(R.id.varOperation)
        result = findViewById(R.id.Result)

        button.setOnClickListener{
            try {
                val a:Double = var1.text.toString().toDouble()
                val b:Double = var2.text.toString().toDouble()
                val res = when (varOperation.text.toString()) {
                    "+" -> a+b
                    "-" -> a-b
                    "*" -> a*b
                    "/" -> a/b
                    else -> "error"
                }
                result.setText(res.toString())
            }
            catch (e:ArithmeticException){
                result.setText("Ошибка вычисления")
                //error
            }
        }
    }
}