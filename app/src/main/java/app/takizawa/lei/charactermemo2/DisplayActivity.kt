package app.takizawa.lei.charactermemo2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_display.*
import kotlinx.android.synthetic.main.activity_mamo.*

class DisplayActivity : AppCompatActivity() {
    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val intId = intent.getIntExtra("intId", -1)

        display(intId)

        when (intId) {
            0 -> background.setBackgroundResource(R.drawable.pred_new)
            1 -> background.setBackgroundResource(R.drawable.pyellow_new)
            2 -> background.setBackgroundResource(R.drawable.porange_new)
            3 -> background.setBackgroundResource(R.drawable.pblue_new)
            4 -> background.setBackgroundResource(R.drawable.pdeepblue_new)
            5 -> background.setBackgroundResource(R.drawable.pgreen_new)
            6 -> background.setBackgroundResource(R.drawable.pdeepgreen_new)
            7 -> background.setBackgroundResource(R.drawable.ppurple_new)
            8 -> background.setBackgroundResource(R.drawable.ppink_new)
            9 -> background.setBackgroundResource(R.drawable.pblown_new)
            10 -> background.setBackgroundResource(R.drawable.pblack_new)
            11 -> background.setBackgroundResource(R.drawable.pwhite_new)
        }
    }

    fun display(intId: Int) {
        realm.executeTransaction {
            val character = realm.where(CharacterData::class.java).equalTo("intId", intId).findFirst()
                ?: return@executeTransaction

            nameDisText.text = character.name
            nicknameDisText.text = character.nickname
            ageDisText.text = character.age
            bloodtypeDisText.text = character.bloodType
            birthdayDisText.text = character.birthday
            voiceDisText.text = character.voice
            jobDisText.text = character.job
            positionDisText.text = character.position
            heightDisText.text = character.height
            weightDisText.text = character.weight
            remarkDisText.text = character.remark
        }
    }
}
