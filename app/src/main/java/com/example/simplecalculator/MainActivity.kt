package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.substring
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.simplecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        binding.apply {
            b0.Görünüm("0")
            b1.Görünüm("1")
            b2.Görünüm("2")
            b3.Görünüm("3")
            b4.Görünüm("4")
            b5.Görünüm("5")
            b6.Görünüm("6")
            b7.Görünüm("7")
            b8.Görünüm("8")
            b9.Görünüm("9")
            btopla.Görünüm("+")
            bcarp.Görünüm("*")
            bcKar.Görünüm("-")
            bbol.Görünüm("/")
            bvirgL.Görünüm(",")
            byuzde.Görünüm("%")
            bc.setOnClickListener {
                hesapText.text = null
                sonucText.text = ""

            }
            bsil.setOnClickListener {
                var deltext = hesapText.text.toString()
                hesapText.setText(deltext.dropLast(1))
            }


            bsonuc.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(binding.hesapText.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()) {
                        binding.sonucText.text = longResult.toString()
                    } else {
                        binding.sonucText.text = result.toString()
                    }
                } catch (e: Exception) {
                    Log.d("Exception", "Message: ${e.message}")
                }

            }


            }


    }
    fun View.Görünüm(string: String) {
        setOnClickListener {
            binding.hesapText.append(string)

        }
    }
}








