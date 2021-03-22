package app.takizawa.lei.charactermemo2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        startButton.setOnClickListener {
            val start = Intent(this, MainActivity::class.java)
            startActivity(start)
        }

    }
}