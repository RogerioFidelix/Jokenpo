package yo.jokenpo

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import yo.jokenpo.R.string.*
import java.util.*

class GameActivity : AppCompatActivity() {

    private var numeroAleatorio: Random? = null

    private val rock = 1
    private val papel = 2
    private val tesoura = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        numeroAleatorio = Random()

        btn_pedra.setOnClickListener {
            iv_voce!!.setImageDrawable(ContextCompat.getDrawable
            (this, R.drawable.pedra))
        }

        btn_papel.setOnClickListener {
            iv_voce!!.setImageDrawable(ContextCompat.getDrawable
            (this, R.drawable.papel))
        }

        btn_tesoura.setOnClickListener {
            iv_voce!!.setImageDrawable(ContextCompat.getDrawable
            (this, R.drawable.tesoura))
        }
    }

    private fun realizarJogada(jogadaPlayer: Int) {

        val player = MediaPlayer.create(this, R.raw.jokenpo)
        player.start()

        val jogadaPC = numeroAleatorio!!.nextInt(3) + 1

        when (jogadaPlayer) {
            1 -> {
                iv_pc!!.setImageDrawable((ContextCompat.getDrawable(this, R.drawable.pedra)))
                when (jogadaPlayer) {
                    3 -> win()
                    1 -> draw()
                    2 -> lose()
                }
            }
        }

        when (jogadaPlayer) {
            2 -> {
                iv_pc!!.setImageDrawable((ContextCompat.getDrawable(this, R.drawable.pedra)))
                when (jogadaPlayer) {
                    1 -> win()
                    2 -> draw()
                    3 -> lose()
                }
            }
        }

        when (jogadaPlayer) {
            3 -> {
                iv_pc!!.setImageDrawable((ContextCompat.getDrawable(this, R.drawable.pedra)))
                when (jogadaPlayer) {
                    2 -> win()
                    3 -> draw()
                    1 -> lose()
                }
            }
        }
    }

    private fun win() {
        txv_resultado!!.text = getString(R.string.venceu)
        txv_resultado!!.setTextColor(ContextCompat.getColor(this, R.color.abc_color_highlight_material))
    }

    private fun lose() {
        txv_resultado!!.text = getString(R.string.perdeu)
        txv_resultado!!.setTextColor(ContextCompat.getColor(this, R.color.abc_color_highlight_material))
    }

    private fun draw() {
        txv_resultado!!.text = getString(R.string.empatou)
        txv_resultado!!.setTextColor(ContextCompat.getColor(this, R.color.abc_color_highlight_material))
    }
}
