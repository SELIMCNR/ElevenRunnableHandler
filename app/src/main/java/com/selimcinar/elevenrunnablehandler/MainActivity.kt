package com.selimcinar.elevenrunnablehandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var numara = 0

    var runnable : Runnable = Runnable{ }
    var handler = Handler(Looper.myLooper()!!)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun baslat(view:View){
        /*klasik yapı
        numara = numara+1
        textView.text = "Sayaç: ${numara}"
        * */
        numara = 0
        runnable = object  : Runnable{
            override fun run() {
                numara= numara +1
                textView.text = "Sayac : ${numara}"
                handler.postDelayed(runnable,1000) //handler runnable kullanmak için gerekli
            }
        }
        handler.post (runnable)  // runnable nesnesini çalıştırmaya başlar

    }
    fun durdur(view: View){
        handler.removeCallbacks(runnable) // runnable içerisinde işlemleri geri al
        numara=0
        textView.text="Sayaç : 0"
    }
}