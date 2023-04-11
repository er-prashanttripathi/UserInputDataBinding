package com.example.userinputapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.userinputapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //creating variable to initialize dataclass, directly from kt file, method 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
//        binding.myVariable=myVariable

        binding.apply {
            val m:String=binding.edttxtInput.toString()
            val myVariableObject = MyDataClass("Your NickName Is: ")
            btnDone.setOnClickListener {
                myVariableObject.nickname=binding.edttxtInput.text.toString()
                binding.myDataClass = myVariableObject
                txtNickName.visibility=View.VISIBLE
                txtkName.visibility=View.VISIBLE
                //hide Keyboard
              addNickName(it)
            }
//            binding.myDataClass = myVariableObject
        }
    }

    private fun addNickName(view: View) //function to hide Keyboard after clicking done button listener

    {
        binding.btnDone.visibility=View.GONE
        binding.edttxtInput.visibility=View.GONE
        //hide keybnoard after ob button click submit
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0);
    }
}