package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String = if (result < 18.5f) {
            tvClassificacao.setTextColor(Color.RED)
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            tvClassificacao.setTextColor(Color.GREEN)
            "NORMAL"
        } else if (result in 25f..29.9f) {
            tvClassificacao.setTextColor(Color.YELLOW)
            "SOBREPESO"
        } else if (result in 30f..39.9f) {
            tvClassificacao.setTextColor(Color.RED)
            "OBESIDADE"
        } else {
            tvClassificacao.setTextColor(Color.RED)
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao

    }


}



