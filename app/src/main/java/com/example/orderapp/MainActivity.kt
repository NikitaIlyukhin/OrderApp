package com.example.orderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.orderapp2.FragmentLogin

class MainActivity : AppCompatActivity() {
    private lateinit var transaction: FragmentTransaction
    private lateinit var fragmentLogin: FragmentLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            transaction = supportFragmentManager.beginTransaction()
            fragmentLogin = FragmentLogin.newInstance("Nikita")
            transaction.add(R.id.fragment_container_view,fragmentLogin,"loginFragment").commit()
        }
    }
}