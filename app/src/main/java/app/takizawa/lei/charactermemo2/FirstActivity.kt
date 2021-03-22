package app.takizawa.lei.charactermemo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlin.random.Random

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val randomImage = Random.nextInt(7)

        if (randomImage == 0){
            meigen.setImageResource(R.drawable.meigen_chara00)
        }

        if (randomImage == 1){
            meigen.setImageResource(R.drawable.meigen_chara01)
        }

        if (randomImage == 2){
            meigen.setImageResource(R.drawable.meigen_chara02)
        }

        if (randomImage == 3){
            meigen.setImageResource(R.drawable.meigen_chara03)
        }

        if (randomImage == 4){
            meigen.setImageResource(R.drawable.meigen_chara04)
        }

        if (randomImage == 5){
            meigen.setImageResource(R.drawable.meigen_chara05)
        }

        if (randomImage == 6){
            meigen.setImageResource(R.drawable.meigen_chara06)
        }


        informationButton.setOnClickListener {
            val second = Intent(this, InformationActivity::class.java)
            startActivity(second)
            finish()
        }

        firstImage.setOnClickListener {
            val first = Intent(this, MainActivity::class.java)
            startActivity(first)
            finish()
        }
    }
}
