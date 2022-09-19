package com.example.orderapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var button:Button
    private lateinit var transaction: FragmentTransaction
    private lateinit var fragmentLogin: FragmentLogin
    private lateinit var fragmentOrder: FragmentOrder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button2)
        if(savedInstanceState == null){
            transaction = supportFragmentManager.beginTransaction()
            fragmentLogin = FragmentLogin.newInstance("Nikita")
            transaction.add(R.id.fragment_container_view,fragmentLogin,"loginFragment").commit()
        }
        button.setOnClickListener{
            println("click make order")
            fragmentOrder = FragmentOrder.newInstance("Nikita")
            //transaction.remove(fragmentLogin).commit()
            transaction.replace(R.id.fragment_container_view,fragmentOrder,"orderFragment")
//            transaction.add(R.id.fragment_container_view,fragmentOrder, "orderFragment").commit()
        }

    }


}
