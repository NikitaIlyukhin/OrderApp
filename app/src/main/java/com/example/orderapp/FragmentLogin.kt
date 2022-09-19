package com.example.orderapp2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.orderapp.R

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


        arguments?.let {
            login = it.getString(ARG_PARAM1,"")
        }

        button.setOnClickListener {
            try {
                login = loginField.text.toString()
                password = passwordField.text.toString()
                var fragmentOrder:FragmentOrder = FragmentOrder.newInstance(login,password)
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container_view,fragmentOrder)
                    .commit()
            }catch (e:Exception){
                throw e
            }
        }
    }
}