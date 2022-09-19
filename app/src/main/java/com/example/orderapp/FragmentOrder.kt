package com.example.orderapp2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.orderapp.FragmentOrderInfo
import com.example.orderapp.R

class FragmentOrder:Fragment(R.layout.frag2) {
    private val ARG_LOGIN:String = "login"
    private val ARG_PASS:String = "password"
    private val teaArray:Array<String> = arrayOf("Зеленый", "Черный")
    private val coffeeArray = arrayOf("Американо","Капуччино")

    private lateinit var login:String
    private lateinit var password:String
    private var drink:String = ""
    private var type:String = ""

    private lateinit var button: Button
    private lateinit var loginField:TextView
    private lateinit var lemonlbl:TextView
    private lateinit var drinkFieldGroup:RadioGroup
    private lateinit var selectedDrink: RadioButton
    private lateinit var milkCB:CheckBox
    private lateinit var lemonCB:CheckBox
    private lateinit var sugarCB:CheckBox
    private lateinit var spinnerTea:Spinner
    private lateinit var spinnerCoffee:Spinner


    companion object{
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentOrder().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, param1)
                    putString(ARG_PASS,param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState == null){
            button          = view.findViewById(R.id.button)
            drinkFieldGroup = view.findViewById(R.id.radioGroup)
            milkCB          = view.findViewById(R.id.checkBoxMilk)
            lemonCB         = view.findViewById(R.id.checkBoxLemon)
            sugarCB         = view.findViewById(R.id.checkBoxSugar)
            lemonlbl        = view.findViewById(R.id.lemon)
            loginField      = view.findViewById(R.id.hello)
            spinnerTea      = view.findViewById(R.id.spinnerTea)
            spinnerCoffee   = view.findViewById(R.id.spinnerCoffee)

            //Hello блок
            arguments?.let {
                login = it.getString(ARG_LOGIN,"")
                password = it.getString(ARG_PASS,"")
            }
            loginField.setText("Привет, "+login+"!")




            //Блок ЧАЙ - Кофе
            selectedDrink = view.findViewById(drinkFieldGroup.checkedRadioButtonId)
            drink = selectedDrink.text.toString()

            if(drink == "Чай"){
                spinnerCoffee.visibility    = View.GONE
                spinnerTea.visibility       = View.VISIBLE
            } else {
                spinnerTea.visibility       = View.GONE
                spinnerCoffee.visibility    = View.VISIBLE
            }

            //Изменения в радио чай-кофе
            drinkFieldGroup.setOnCheckedChangeListener { group, checkedId ->
                selectedDrink = view.findViewById(checkedId)
                drink = selectedDrink.text.toString()

                //Скрыть "добавить лимон" если не чай
                if(drink != "Чай") {
                    lemonlbl.visibility         = View.GONE
                    lemonCB.visibility          = View.GONE
                    spinnerTea.visibility       = View.GONE
                    spinnerCoffee.visibility    = View.VISIBLE
                } else {
                    lemonlbl.visibility         = View.VISIBLE
                    lemonCB.visibility          = View.VISIBLE
                    spinnerCoffee.visibility    = View.GONE
                    spinnerTea.visibility       = View.VISIBLE
                }
            }

            //SpinnerTea
            spinnerTea?.adapter = ArrayAdapter(activity?.applicationContext!!, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, teaArray)
            spinnerTea?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    type = parent?.getItemAtPosition(position).toString()
                }
            }
            //SpinnerCoffee
            spinnerCoffee?.adapter = ArrayAdapter(activity?.applicationContext!!, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, coffeeArray)
            spinnerCoffee?.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    type = parent?.getItemAtPosition(position).toString()
                }
            }

            //Кнопка сделать заказ
            button.setOnClickListener {
                try {
                    println(type)
                    val bundle = bundleOf(
                        Pair("milk",milkCB.isChecked),
                        Pair("sugar",sugarCB.isChecked),
                        Pair("lemon",lemonCB.isChecked && drink == "Чай")
                    )
                    var fragmentOrderInfo:FragmentOrderInfo = FragmentOrderInfo.newInstance(login,password,drink+" "+type,bundle)
                    parentFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container_view,fragmentOrderInfo)
                        .commit()
                }catch (e:Exception){
                    throw e
                }
            }
        }
    }

}