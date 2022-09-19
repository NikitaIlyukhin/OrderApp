package com.example.orderapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentOrder:Fragment(R.layout.frag2) {
    private val ARG_LOGIN:String = "login"
    private lateinit var login:String;
    companion object{
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentOrder().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, param1)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}