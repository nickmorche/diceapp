package com.nnte.primeiraaula_diceapp

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.ChipGroup


class MainActivity : AppCompatActivity() {

    var historico = mutableListOf<Int>()
    var isAnimating = false // Indica se está rolando animação
    private val modalDialog: Dialog? = null // Dialogo modal
    private lateinit var sharedPreferences: SharedPreferences // Armazena as preferências e configuraç]ões do usuário

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Cria os componentes da tela.
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("historico_de_dados", Context.MODE_PRIVATE)

        /**
         * Cria uma variável do tipo TextView e Encontra o objeto no xml
         * @variavel R que porra é isso? Aparentenmente é onde tá tudo
         * @method findViewById tenta encontrar um objeto com esse id
         *
         * Obs: quando o tipo da variável fica vermelho, clique em cima dele
         * e clique em Import
         */
        val botao: Button = findViewById(R.id.botao_maluco)
        val imagemDoDado: ImageView = findViewById(R.id.imagem)
        val openModalBotao: Button = findViewById(R.id.openModalButton)


        // Armazena o chipgroup em uma variável
        val chipGroup: ChipGroup = findViewById(R.id.chip_group)

        /**
         * @method setOnCheckedChangeListerner
         * Define um ouvinte de evento para detectar quando uma opção é selecionada.
         * Ou seja, ao clicar em um dos chips, vai mudar a imagem.
         */
        chipGroup.setOnCheckedChangeListener {_, _ ->
            when(chipGroup.checkedChipId) {
                R.id.chip_d4 -> imagemDoDado.setImageResource(R.drawable.d4_1) // Muda a imagem
                R.id.chip_d6 -> imagemDoDado.setImageResource(R.drawable.d6_1)
                R.id.chip_d8 -> imagemDoDado.setImageResource(R.drawable.d8_1)
                R.id.chip_d10 -> imagemDoDado.setImageResource(R.drawable.d10_1)
                R.id.chip_d12 -> imagemDoDado.setImageResource(R.drawable.d12_1)
                R.id.chip_d20 -> imagemDoDado.setImageResource(R.drawable.d20_1)
            }
        }
        /* *
         * @method setOnClickListener: função responsável por atribuir uma função ao clicar no botão
         *
         */
        botao.setOnClickListener {
            jogarDado(imagemDoDado, chipGroup)
        }

        openModalBotao.setOnClickListener{
            showCustomModal()
        }


    }

    private fun showCustomModal(){
        val modalDialog = Dialog(this@MainActivity)
        modalDialog.setContentView(R.layout.modal_layout)

        // AVISO: é necessário usar o findViewById pelo @var modalDialog, para pegar da tela correta
        var titleTextView:TextView = modalDialog.findViewById(R.id.titleTextView)
        titleTextView.text = "Título do Modal"

        /**
         * Cria a lista para o ReciclerView do modal
         * @var recycleViewModal é a lista
         * @var adapter é a classe que adapta os itens na lista
         * @var dataList é a lista de dados que envia para o adaptador
         */
        // Inicializar a lista de dados
        var dataList: ArrayList<String>
        dataList = ArrayList()
        dataList.add("Item 1")
        dataList.add("Item 2")
        dataList.add("Item 3")

        // Inicializar a RecyclerView e configurar o LayoutManager
        var recycleViewModal: RecyclerView = modalDialog.findViewById(R.id.recyclerViewModal)
        recycleViewModal.layoutManager = LinearLayoutManager(this)

        // Inicializar o adaptador e atribuí-lo à RecyclerView
        var adapter: MyAdapter
        adapter = MyAdapter(dataList)
        recycleViewModal.adapter = adapter // Configure o RecyclerView com o adaptador

        var closeButton: Button = modalDialog.findViewById(R.id.closeButton)

        closeButton.setOnClickListener{
            modalDialog.dismiss();
        }

        modalDialog.show();
    }

    private fun jogarDado(imagemDoDado: ImageView, chipGroup: ChipGroup){
        var faceSorteada: Int
        var textoDaTela: TextView = findViewById(R.id.textoHelloWorld)

        /**
         * Arrays que armazenam as referências aos recursos de imagem dos dados
         * Possibilitando assim apenas referenciá-los
         */
        val facesDoDadoD4 = arrayOf(
            R.drawable.d4_1,
            R.drawable.d4_2,
            R.drawable.d4_3,
            R.drawable.d4_4
        )
        val facesDoDadoD6 = arrayOf(
            R.drawable.d6_1,
            R.drawable.d6_2,
            R.drawable.d6_3,
            R.drawable.d6_4,
            R.drawable.d6_5,
            R.drawable.d6_6
        )
        val facesDoDadoD8 = arrayOf(
            R.drawable.d8_1,
            R.drawable.d8_2,
            R.drawable.d8_3,
            R.drawable.d8_4,
            R.drawable.d8_5,
            R.drawable.d8_6,
            R.drawable.d8_7,
            R.drawable.d8_8,
        )
        val facesDoDadoD10 = arrayOf(
            R.drawable.d10_1,
            R.drawable.d10_2,
            R.drawable.d10_3,
            R.drawable.d10_4,
            R.drawable.d10_5,
            R.drawable.d10_6,
            R.drawable.d10_7,
            R.drawable.d10_8,
            R.drawable.d10_9,
            R.drawable.d10_10
        )
        val facesDoDadoD12 = arrayOf(
            R.drawable.d12_1,
            R.drawable.d12_2,
            R.drawable.d12_3,
            R.drawable.d12_4,
            R.drawable.d12_5,
            R.drawable.d12_6,
            R.drawable.d12_7,
            R.drawable.d12_8,
            R.drawable.d12_9,
            R.drawable.d12_10,
            R.drawable.d12_11,
            R.drawable.d12_12,
        )
        val facesDoDadoD20 = arrayOf(
            R.drawable.d20_1,
            R.drawable.d20_2,
            R.drawable.d20_3,
            R.drawable.d20_4,
            R.drawable.d20_5,
            R.drawable.d20_6,
            R.drawable.d20_7,
            R.drawable.d20_8,
            R.drawable.d20_9,
            R.drawable.d20_10,
            R.drawable.d20_11,
            R.drawable.d20_12,
            R.drawable.d20_13,
            R.drawable.d20_14,
            R.drawable.d20_15,
            R.drawable.d20_16,
            R.drawable.d20_17,
            R.drawable.d20_18,
            R.drawable.d20_19,
            R.drawable.d20_20
        )

        var dadoImageSelect: Int


        when(chipGroup.checkedChipId){ // Captura o id do chip escolhido dentro do chip group
            R.id.chip_d4 -> {
                faceSorteada = (1..4).random()
                // textoDaTela.text = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString())
                //imagemDoDado.contentDescription = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString()) //para descrever a imagem para voiceover

                /**
                 * Muda a @property text no componente textoTela com um número randômico de 1 a 6
                 */
                textoDaTela.text = faceSorteada.toString()
                imagemDoDado.contentDescription = faceSorteada.toString()

                mudaImagem(facesDoDadoD4[faceSorteada-1], imagemDoDado)

            }
            R.id.chip_d6 -> {
                faceSorteada = (1..6).random()

                textoDaTela.text = faceSorteada.toString()
                imagemDoDado.contentDescription = faceSorteada.toString()

                mudaImagem(facesDoDadoD6[faceSorteada-1], imagemDoDado)

            }
            R.id.chip_d8 -> {
                faceSorteada = (1..8).random()

                textoDaTela.text = faceSorteada.toString()
                imagemDoDado.contentDescription = faceSorteada.toString()

                mudaImagem(facesDoDadoD8[faceSorteada-1], imagemDoDado)

            }
            R.id.chip_d10 -> {
                faceSorteada = (1..10).random()

                textoDaTela.text = faceSorteada.toString()
                imagemDoDado.contentDescription = faceSorteada.toString()

                mudaImagem(facesDoDadoD10[faceSorteada-1], imagemDoDado)

            }
            R.id.chip_d12 -> {
                faceSorteada = (1..12).random()

                textoDaTela.text = faceSorteada.toString()
                imagemDoDado.contentDescription = faceSorteada.toString()


                mudaImagem(facesDoDadoD12[faceSorteada-1], imagemDoDado)

            }
            R.id.chip_d20 -> {
                faceSorteada = (1..20).random()

                textoDaTela.text = faceSorteada.toString()
                imagemDoDado.contentDescription = faceSorteada.toString()

                mudaImagem(facesDoDadoD20[faceSorteada-1], imagemDoDado)

            }

        }

    }

    /**
     * Realiza uma animação de rolagem de dados
     */
    private fun mudaImagem(idResourceImage: Int, imagemDoDado: ImageView){
        val editor = sharedPreferences.edit()

        // Se não está animando, anima
        if(!isAnimating){
            isAnimating = true
            // Aplica a animação
            imagemDoDado.animate().apply {
                duration = 700 // DUração de 700 milissegundos
                rotationXBy(360f) // Rotação de 360 graus
                alpha(0f) // Deixa transparente
            }.withEndAction {
                imagemDoDado.animate().apply{
                    alpha(1f) // Deixa opaco
                }
                imagemDoDado.setImageResource(idResourceImage) //Afeta a imagem
                isAnimating = false
            }.start() // Começa a animação com base nesses parâmetros

            // Armazena o dado rolado no histórico
            historico.add(idResourceImage)
            editor.putString("historico", historico.toString())
            editor.apply()
        }
    }

}