package com.example.orderapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentLogin:Fragment(R.layout.frag1) {

    private val ARG_PARAM1 = "Login"
    var login:String = ""
    private lateinit var password:String

    private lateinit var button:Button
    private lateinit var loginField: EditText
    private lateinit var passwordField: EditText


    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentLogin().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button)
        loginField = view.findViewById(R.id.loginField)
        passwordField = view.findViewById(R.id.passwordField)

        println("onViewCreated")
        arguments?.let {
            login = it.getString(ARG_PARAM1,"")
        }
        println(login)
        button.setOnClickListener {
            try {
                login = loginField.text.toString()
                password = passwordField.text.toString()
                //findNavController().navigate(R.id.order)
                println(login)
            }catch (e:Exception){
                throw e
            }
        }
    }
}