package app.takizawa.lei.charactermemo2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_mamo.*


class ReMemoActivity : AppCompatActivity() {
    //変数
    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    private val positionItems: Array<String> = arrayOf(
        "ヒーロー（主人公）",
        "メンター（賢者）",
        "ガーディアン（門番）",
        "ヘラルド（使者）",
        "シェイプシフター（変化者）",
        "シャドウ（悪者）",
        "トリックスター（道化師）",
        "未定"
    )


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mamo)

        //MainActivityから値を受けとる
        val name = intent.getStringExtra("NAME")
        editNameText.editText?.setText(name)

        //既に保存されているデータを取得してmemoに代入
        val memo: CharacterData? = read(name as String)

        if (memo != null) {
            editNameText.editText?.setText(memo.name)
            editGenderText.editText?.setText(memo.gender)
            editNicknameText.setText(memo.nickname)
            editPositionText.setText(memo.position)
            editJobText.setText(memo.job)
            editBloodtypeText.setText(memo.bloodType)
            editAgeText.setText(memo.age)
            editBirthdayText.setText(memo.birthday)
            editAbilityText.setText(memo.ability)
            editFirstPersonText.setText(memo.firstPerson)
            editFavoriteText.setText(memo.favorite)
            editHeightText.setText(memo.height)
            editWeightText.setText(memo.weight)
            editVoiceText.setText(memo.voice)
            editPersonalityText.setText(memo.personality)
            editSpecialSkillText.setText(memo.specialSkill)
            editAppearanceText.setText(memo.appearance)
            editUpbringText.setText(memo.upbring)
            editSceneText.setText(memo.scene)
            editRemarkText.setText(memo.remark)
            editWriteText.setText(memo.write)
            editOtherText.setText(memo.other)
        }

        display(name.toString())

        val intent = Intent(applicationContext, DisplayActivity::class.java)

        prepareForIntent(name as String, intent)

        saveButton.setOnClickListener {
            update(name.toString())

            val name: String = editNameText.editText?.text.toString()
            val gender: String = editGenderText.editText?.text.toString()
            val nickname: String = editNicknameText.text.toString()
            val position: String = editPositionText.text.toString()
            val job: String = editJobText.text.toString()
            val bloodType: String = editBloodtypeText.text.toString()
            val age: String = editAgeText.text.toString()
            val birthday: String = editBirthdayText.text.toString()
            val ability: String = editAbilityText.text.toString()
            val firstPerson: String = editFirstPersonText.text.toString()
            val favorite: String = editFavoriteText.text.toString()
            val height: String = editHeightText.text.toString()
            val weight: String = editWeightText.text.toString()
            val voice: String = editVoiceText.text.toString()
            val personality: String = editPersonalityText.text.toString()
            val specialSkill: String = editSpecialSkillText.text.toString()
            val appearance: String = editAppearanceText.text.toString()
            val upbring: String = editUpbringText.text.toString()
            val scene: String = editSceneText.text.toString()
            val remark: String = editRemarkText.text.toString()
            val write: String = editWriteText.text.toString()
            val other: String = editOtherText.text.toString()
            save(
                name, gender, nickname, position, job, bloodType, age, birthday, ability, firstPerson
                , favorite, height, weight, voice, personality, specialSkill, appearance, upbring, scene
                , remark, write, other
            )

            startActivity(intent)
        }
    }

    //Activityが終了したときに実行される
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun display(name: String){
        realm.executeTransaction {
            val character = realm.where(CharacterData::class.java).equalTo("name", name).findFirst()
                ?: return@executeTransaction

            editNameText.editText?.setText(character.name)
            editGenderText.editText?.setText(character.gender)
            editNicknameText.setText(character.nickname)
            editPositionText.setText(character.position)
            editJobText.setText(character.job)
            editBloodtypeText.setText(character.bloodType)
            editAgeText.setText(character.age)
            editBirthdayText.setText(character.birthday)
            editAbilityText.setText(character.ability)
            editFirstPersonText.setText(character.firstPerson)
            editFavoriteText.setText(character.favorite)
            editHeightText.setText(character.height)
            editWeightText.setText(character.weight)
            editVoiceText.setText(character.voice)
            editPersonalityText.setText(character.personality)
            editSpecialSkillText.setText(character.specialSkill)
            editAppearanceText.setText(character.appearance)
            editUpbringText.setText(character.upbring)
            editSceneText.setText(character.scene)
            editRemarkText.setText(character.remark)
            editWriteText.setText(character.write)
            editOtherText.setText(character.other)
        }
    }

    fun update(name: String) {
        realm.executeTransaction {
            val character = realm.where(CharacterData::class.java).equalTo("name", name).findFirst()
                ?: return@executeTransaction

            character.name = editNameText.editText?.text.toString()
            character.gender = editGenderText.editText?.text.toString()
            character.nickname = editNicknameText.text.toString()
            character.position = editPositionText.text.toString()
            character.job = editJobText.text.toString()
            character.bloodType = editBloodtypeText.text.toString()
            character.age = editAgeText.text.toString()
            character.birthday = editBirthdayText.text.toString()
            character.ability = editAbilityText.text.toString()
            character.firstPerson = editFirstPersonText.text.toString()
            character.favorite = editFavoriteText.text.toString()
            character.height = editHeightText.text.toString()
            character.weight = editWeightText.text.toString()
            character.voice = editVoiceText.text.toString()
            character.personality = editPersonalityText.text.toString()
            character.specialSkill = editSpecialSkillText.text.toString()
            character.appearance = editAppearanceText.text.toString()
            character.upbring = editUpbringText.text.toString()
            character.scene = editSceneText.text.toString()
            character.remark = editRemarkText.text.toString()
            character.write = editWriteText.text.toString()
            character.other = editOtherText.text.toString()

        }
    }

    fun prepareForIntent(name: String, intent: Intent) {
        realm.executeTransaction {
            val character = realm.where(CharacterData::class.java).equalTo("name", name).findFirst()
                ?: return@executeTransaction

            intent.putExtra("intId",character.intId)
        }
    }

    //readメソッド　?…返り値がnullになる可能性がある:
    fun read(name: String): CharacterData? {
        return realm.where(CharacterData::class.java).equalTo("name",name).findFirst()
    }

    fun save(name: String,gender: String,nickname: String,position: String,job: String,bloodType: String,age: String
             ,birthday: String,ability: String,firstPerson: String,favorite: String,height: String,weight: String
             ,voice: String,personality: String,specialSkill: String,appearance: String,upbring: String,scene: String
             ,remark: String,write: String,other: String){
        //保存する処理
        val memo: CharacterData? = read(name)

        //データベースへの書き込み
        realm.executeTransaction {
            if (memo != null) {
                //メモの更新
                memo.name = name
                memo.gender = gender
                memo.nickname = nickname
                memo.position = position
                memo.job = job
                memo.bloodType = bloodType
                memo.age = age
                memo.birthday = birthday
                memo.ability = ability
                memo.firstPerson = firstPerson
                memo.favorite = favorite
                memo.height = height
                memo.weight = weight
                memo.voice = voice
                memo.personality = personality
                memo.specialSkill = specialSkill
                memo.appearance = appearance
                memo.upbring = upbring
                memo.scene = scene
                memo.remark = remark
                memo.write = write
                memo.other = other
            } else {
                //メモの新規作成
                val newMemo: CharacterData = it.createObject(CharacterData::class.java)
                newMemo.name = name
                newMemo.gender = gender
                newMemo.nickname = nickname
                newMemo.position = position
                newMemo.job = job
                newMemo.bloodType = bloodType
                newMemo.age = age
                newMemo.birthday = birthday
                newMemo.ability = ability
                newMemo.firstPerson = firstPerson
                newMemo.favorite = favorite
                newMemo.height = height
                newMemo.weight = weight
                newMemo.voice = voice
                newMemo.personality = personality
                newMemo.specialSkill = specialSkill
                newMemo.appearance = appearance
                newMemo.upbring = upbring
                newMemo.scene = scene
                newMemo.remark = remark
                newMemo.write = write
                newMemo.other = other
            }
        }
    }

}