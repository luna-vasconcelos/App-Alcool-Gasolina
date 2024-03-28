package com.example.alcoolougasolina

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("PDM24.1","No onCreate, $percentual")

        percentual=0.7
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }

        val btCalc: Button= findViewById(R.id.btCalcular)
        val textMsg: TextView= findViewById(R.id.textMsg)
        val gas: EditText= findViewById(R.id.edGasolina)
        val alcool: EditText= findViewById(R.id.edAlcool)
        val switchBut: Switch= findViewById(R.id.swPercentual)

            btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            //percentual=0.75
            val gasNumber = gas.text.toString().toDoubleOrNull()
            val alcoolNumber = alcool.text.toString().toDoubleOrNull()
            val calculo = gasNumber?.div(alcoolNumber!!)
            if (alcoolNumber != null && gasNumber != null) {
                val result = calculoMelhorOpcao(alcoolNumber, gasNumber, switchBut.isChecked)
                textMsg.text="O melhor a utilizar é: $result"
            }
            Log.d("PDM24","No btCalcular, $percentual")
        })
    }

    private fun calculoMelhorOpcao(alcoolNumber: Double, gasNumber: Double, isSwitchOn: Boolean): String {
        if (isSwitchOn){
            return "Álcoll"
        }
        return if (alcoolNumber / gasNumber < 0.7) "Álcool" else "Gasolina"
    }

    override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}
