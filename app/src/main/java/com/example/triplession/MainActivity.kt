package com.example.triplession

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity(), numbers {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        val array_of_numbers = retorna_array()
        intent.putExtra("numbers", array_of_numbers)
        print("Criei a variavel: ${(array_of_numbers)}")
        super.onStart()
        print("onStart")
    }

    override fun onResume() {
        super.onResume()
        print(">>>>>>>> onResume >>>>>> aqui estou colhendo a variavel")
        val intent = intent
        handleArray(intent.getStringArrayExtra("numbers"))
    }

    override fun onPause() {
        super.onPause()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        print("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        print("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy")
    }

    fun print(msg: String) {
        Log.d("Activity State ", msg)
    }

    private fun handleArray(numbers: Array<String>) {
        val screen_orientation = resources.configuration.orientation
        if (screen_orientation == Configuration.ORIENTATION_PORTRAIT) {
            textResult.setText(numbers[0])
            textResult2.setText(numbers[1])
            textResult3.setText(numbers[2])

        } else {
            textResult.setText(numbers[(0..2).random()])
            textResult2.isVisible = false
            textResult3.isVisible = false
        }
    }
}