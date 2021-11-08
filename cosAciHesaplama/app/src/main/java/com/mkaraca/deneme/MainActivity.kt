package com.mkaraca.deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.mkaraca.deneme.databinding.ActivityMainBinding
import java.lang.Math.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b= ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.button.setOnClickListener {
            if (TextUtils.isEmpty(b.etX1.text) || TextUtils.isEmpty(b.etY1.text) || TextUtils.isEmpty(b.etX2.text) || TextUtils.isEmpty(b.etY2.text)){
                Toast.makeText(applicationContext,"Deger Giriniz",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else
                if (!b.cboxCos.isChecked && !b.cboxEuc.isChecked){
                    Toast.makeText(this,"Bir yöntem seçiniz",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else if(b.cboxCos.isChecked && !b.cboxCos.isChecked){
                    b.twtEuc.text=eucfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).toString()
                }else if(!b.cboxCos.isChecked && b.cboxEuc.isChecked){
                    b.twtCos.text=cosfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).get(0).toString()
                    b.twtAci.text=cosfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).get(1).toString()
                    b.twtCosb.text=cosfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).get(2).toString()
                }else if (b.cboxEuc.isChecked && b.cboxEuc.isChecked) {
                    b.twtEuc.text=eucfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).toString()
                    b.twtCos.text=cosfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).get(0).toString()
                    b.twtAci.text=cosfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).get(1).toString()
                    b.twtCosb.text=cosfun(b.etX1.text.toString().toDouble(),b.etY1.text.toString().toDouble(),b.etX2.text.toString().toDouble(),b.etY2.text.toString().toDouble()).get(2).toString()
                }

        }

        b.btnYdeger.setOnClickListener {
            b.etX1.text.clear()
            b.etY1.text.clear()
            b.etX2.text.clear()
            b.etY2.text.clear()
            b.twtEuc.text = getString(R.string.twt_euc)
            b.twtCos.text = getString(R.string.twt_cos)
            b.twtAci.text = getString(R.string.twt_aci)
            b.twtCosb.text = getString(R.string.twt_cosb)
            b.etX1.requestFocus()
        }

        b.etX1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                b.etX1.postDelayed(Runnable { b.etY1.requestFocus() }, 1000)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        b.etY1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                b.etY1.postDelayed(Runnable { b.etX2.requestFocus() }, 1000)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        b.etX2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                b.etX2.postDelayed(Runnable { b.etY2.requestFocus() },1000)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        b.etY2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                b.etY2.postDelayed(Runnable { b.cboxCos.requestFocus() },1000)
                klavyeGizle()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

    }


    fun eucfun(x1:Double,y1:Double,x2:Double,y2:Double): Long {
        var eucSonuc= sqrt((x1-x2).pow(2)+(y1-y2).pow(2))
        return round(eucSonuc*100)/100
    }

    fun cosfun(x1:Double,y1:Double,x2:Double,y2:Double): Array<Long> {
        var cosSonuc=((x1*x2+y1*y2)/(sqrt(x1.pow(2)+x2.pow(2)) * sqrt(y1.pow(2)+y2.pow(2))))
        var cosAci= (acos(cosSonuc))*180/ PI
        var cosDist=1-cosSonuc
        return arrayOf(round(cosSonuc*100)/100, round((cosAci*100)/100), round(cosDist*100)/100)
    }

    fun klavyeGizle(){
        (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            hideSoftInputFromWindow(b.etX1.windowToken,0)
        }
    }


}