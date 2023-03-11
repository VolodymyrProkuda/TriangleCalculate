package com.example.trianglecalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trianglecalculate.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{ calculateTriangle() }
    }

    fun calculateTriangle() {
       var flagCalclate: Int = 0
        var a: Double
        var b: Double
        var c: Double
        var fi: Double
        var cosfi: Double
        var sinfi: Double

  //     binding.textView.text = binding.editText6.text.toString()
  //     binding.textView2.text = binding.editText2.text.toString()
  //     binding.textView4.text = binding.editText4.text.toString()
   //    binding.textView5.text = binding.editText.text.toString()
  //     binding.textView6.text = binding.editText5.text.toString()
        if (binding.editText6.text.toString() != "") { a = binding.editText6.text.toString().toDouble()}
        else {a = 0.0
            flagCalclate++}
        if (binding.editText2.text.toString() != "") { b = binding.editText2.text.toString().toDouble()}
        else {b = 0.0
            flagCalclate++}
        if (binding.editText3.text.toString() != "") { c = binding.editText3.text.toString().toDouble()}
        else {c = 0.0
            flagCalclate++}
        if (binding.editText4.text.toString() != "") { fi = binding.editText4.text.toString().toDouble()/180*PI}
        else {fi = 0.0
            flagCalclate++}
        if (binding.editText.text.toString() != "")  { cosfi = binding.editText.text.toString().toDouble()}
        else {cosfi = 0.0
            flagCalclate++}
        if (binding.editText5.text.toString() != "") { sinfi = binding.editText5.text.toString().toDouble()}
        else {sinfi = 0.0
            flagCalclate++}
        if ((a !=0.0) && (b != 0.0))  {
            c = sqrt(a*a+b*b)
            fi = atan(b/a)
            cosfi = cos(fi)
            sinfi = sin(fi)
        }
        if ((a !=0.0) && (c != 0.0))  {
            b = sqrt(c*c-a*a)
            fi = atan(b/a)
            cosfi = cos(fi)
            sinfi = sin(fi)
        }
        if ((b !=0.0) && (c != 0.0))  {
            a = sqrt(c*c-b*b)
            fi = atan(b/a)
            cosfi = cos(fi)
            sinfi = sin(fi)
        }

        if (cosfi !=0.0) fi = acos(cosfi)
        if (sinfi !=0.0) fi = asin(sinfi)
        if ((a !=0.0) && (fi != 0.0))  {
            c = a/cos(fi)
            b = sqrt(c*c-a*a)
            cosfi = cos(fi)
            sinfi = sin(fi)
        }
        if ((b !=0.0) && (fi != 0.0))  {
            c = b/sin(fi)
            a = sqrt(c*c-b*b)
            cosfi = cos(fi)
            sinfi = sin(fi)
        }
        if ((c !=0.0) && (fi != 0.0))  {
            b = c*sin(fi)
            a = sqrt(c*c-b*b)
            cosfi = cos(fi)
            sinfi = sin(fi)
        }
        if (flagCalclate != 4) {
           a = 0.0
             b = 0.0
             c = 0.0
             fi = 0.0
             cosfi = 0.0
             sinfi = 0.0
            flagCalclate = 0
        }


        binding.textView.text =  "a=%.3f".format(a)
        binding.textView2.text = "b=%.3f".format(b)
        binding.textView3.text = "c=%.3f".format(c)
        binding.textView4.text = "fi=%.3f".format(fi/PI*180)
        binding.textView5.text = "cosfi=%.3f".format(cosfi)
        binding.textView6.text = "sinfi=%.3f".format(sinfi)

    }
}