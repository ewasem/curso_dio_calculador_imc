package com.ewapps.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.Format

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

    }

    private fun setListeners() {
        et_weight.doOnTextChanged { text, _, _, _ ->
            //textView.text = text

        }

        et_size.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        btn_calculate.setOnClickListener {
            calculateIMC(et_weight.text.toString(), et_size.text.toString())
        }
    }

    private fun calculateIMC(weight: String, size: String) {
        val weight = weight.toFloatOrNull()
        val size = size.toFloatOrNull()
        if (weight != null && size != null) {
            val imc = weight / (size * size)
            val dec = DecimalFormat("#.00")
            val final = dec.format(imc)

            tv_imc.text = "Meu IMC é \n $final"
        }
    }
}