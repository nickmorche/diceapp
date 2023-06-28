package com.nnte.primeiraaula_diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cria os componentes da tela.
        setContentView(R.layout.activity_main)

        /**
         * Cria uma variável do tipo TextView e Encontra o objeto no xml
         * @variavel R que porra é isso? Aparentenmente é onde tá tudo
         * @method findViewById tenta encontrar um objeto com esse id
         *
         * Obs: quando o tipo da variável fica vermelho, clique em cima dele
         * e clique em Import
         */
        val textoTela: TextView = findViewById(R.id.textoHelloWorld)
        val botao: Button = findViewById(R.id.botao_maluco)

        /* *
         * @method setOnClickListener: função responsável por atribuir uma função ao clicar no botão
         *
         */
        botao.setOnClickListener {
            /**
             * Muda a @property text no componente textoTela com um número randômico de 1 a 6
             */
            textoTela.text = (1 .. 6 ).random().toString()
        }

    }
}