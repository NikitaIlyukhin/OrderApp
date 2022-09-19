package com.example.orderapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.orderapp2.FragmentOrder

class FragmentOrderInfo:Fragment(R.layout.frag3) {
    private val ARG_LOGIN:String = "login"
    private val ARG_PASS:String = "password"
    private val ARG_ORDER:String = "order"
    private val ARG_MORE:String = "more"

    private lateinit var login:String
    private lateinit var password:String
    private lateinit var order:String
    private lateinit var more:Bundle

    private lateinit var loginField:TextView
    private lateinit var passwordField:TextView
    private lateinit var orderField:TextView
    private lateinit var moreField:TextView

    companion object{
        @JvmStatic
        fun newInstance(param1: String,
                        param2: String,
                        param3: String,
                        param4: Bundle
                        ) =
            FragmentOrderInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, param1)
                    putString(ARG_PASS,param2)
                    putString(ARG_ORDER,param3)
                    putBundle(ARG_MORE,param4)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            login = it.getString(ARG_LOGIN,"")
            password = it.getString(ARG_PASS,"")
            order = it.getString(ARG_ORDER,"")
            more = it.getBundle(ARG_MORE)!!
        }

        if(savedInstanceState == null){
            loginField = view.findViewById(R.id.client)
            loginField.setText(login)

            passwordField = view.findViewById(R.id.pass)
            passwordField.setText(password)

            orderField = view.findViewById(R.id.orderText)
            orderField.setText(order)

            moreField = view.findViewById(R.id.moreText)
            var moreRes:String = ""
            if(more.getBoolean("milk"))  moreRes = moreRes+" молоко,"
            if(more.getBoolean("sugar")) moreRes = moreRes+" сахар,"
            if(more.getBoolean("lemon")) moreRes = moreRes+" лимон,"
            if(moreRes!="")moreRes = moreRes.substring(0,moreRes.length-1)
            moreField.setText(moreRes)
        }

    }
}