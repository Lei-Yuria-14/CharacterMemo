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
            editNicknameText.editText?.setText(memo.nickname)
            editPositionText.editText?.setText(memo.position)
            editJobText.editText?.setText(memo.job)
            editBloodtypeText.editText?.setText(memo.bloodType)
            editAgeText.editText?.setText(memo.age)
            editBirthdayText.editText?.setText(memo.birthday)
            editAbilityText.editText?.setText(memo.ability)
            editFirstPersonText.editText?.setText(memo.firstPerson)
            editFavoriteText.editText?.setText(memo.favorite)
            editHeightText.editText?.setText(memo.height)
            editWeightText.editText?.setText(memo.weight)
            editVoiceText.editText?.setText(memo.voice)
            editPersonalityText.editText?.setText(memo.personality)
            editSpecialSkillText.editText?.setText(memo.specialSkill)
            editAppearanceText.editText?.setText(memo.appearance)
            editUpbringText.editText?.setText(memo.upbring)
            editSceneText.editText?.setText(memo.scene)
            editRemarkText.editText?.setText(memo.remark)
            editWriteText.editText?.setText(memo.write)
            editOtherText.editText?.setText(memo.other)
        }

        display(name.toString())

        val intent = Intent(applicationContext, DisplayActivity::class.java)

        prepareForIntent(name as String, intent)

        saveButton.setOnClickListener {
            update(name.toString())

            val name: String = editNameText.editText?.text.toString()
            val gender: String = editGenderText.editText?.text.toString()
            val nickname: String = editNicknameText.editText?.text.toString()
            val position: String = editPositionText.editText?.text.toString()
            val job: String = editJobText.editText?.text.toString()
            val bloodType: String = editBloodtypeText.editText?.text.toString()
            val age: String = editAgeText.editText?.text.toString()
            val birthday: String = editBirthdayText.editText?.text.toString()
            val ability: String = editAbilityText.editText?.text.toString()
            val firstPerson: String = editFirstPersonText.editText?.text.toString()
            val favorite: String = editFavoriteText.editText?.text.toString()
            val height: String = editHeightText.editText?.text.toString()
            val weight: String = editWeightText.editText?.text.toString()
            val voice: String = editVoiceText.editText?.text.toString()
            val personality: String = editPersonalityText.editText?.text.toString()
            val specialSkill: String = editSpecialSkillText.editText?.text.toString()
            val appearance: String = editAppearanceText.editText?.text.toString()
            val upbring: String = editUpbringText.editText?.text.toString()
            val scene: String = editSceneText.editText?.text.toString()
            val remark: String = editRemarkText.editText?.text.toString()
            val write: String = editWriteText.editText?.text.toString()
            val other: String = editOtherText.editText?.text.toString()
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
            editNicknameText.editText?.setText(character.nickname)
            editPositionText.editText?.setText(character.position)
            editJobText.editText?.setText(character.job)
            editBloodtypeText.editText?.setText(character.bloodType)
            editAgeText.editText?.setText(character.age)
            editBirthdayText.editText?.setText(character.birthday)
            editAbilityText.editText?.setText(character.ability)
            editFirstPersonText.editText?.setText(character.firstPerson)
            editFavoriteText.editText?.setText(character.favorite)
            editHeightText.editText?.setText(character.height)
            editWeightText.editText?.setText(character.weight)
            editVoiceText.editText?.setText(character.voice)
            editPersonalityText.editText?.setText(character.personality)
            editSpecialSkillText.editText?.setText(character.specialSkill)
            editAppearanceText.editText?.setText(character.appearance)
            editUpbringText.editText?.setText(character.upbring)
            editSceneText.editText?.setText(character.scene)
            editRemarkText.editText?.setText(character.remark)
            editWriteText.editText?.setText(character.write)
            editOtherText.editText?.setText(character.other)
        }
    }

    fun update(name: String) {
        realm.executeTransaction {
            val character = realm.where(CharacterData::class.java).equalTo("name", name).findFirst()
                ?: return@executeTransaction

            character.name = editNameText.editText?.text.toString()
            character.gender = editGenderText.editText?.text.toString()
            character.nickname = editNicknameText.editText?.text.toString()
            character.position = editPositionText.editText?.text.toString()
            character.job = editJobText.editText?.text.toString()
            character.bloodType = editBloodtypeText.editText?.text.toString()
            character.age = editAgeText.editText?.text.toString()
            character.birthday = editBirthdayText.editText?.text.toString()
            character.ability = editAbilityText.editText?.text.toString()
            character.firstPerson = editFirstPersonText.editText?.text.toString()
            character.favorite = editFavoriteText.editText?.text.toString()
            character.height = editHeightText.editText?.text.toString()
            character.weight = editWeightText.editText?.text.toString()
            character.voice = editVoiceText.editText?.text.toString()
            character.personality = editPersonalityText.editText?.text.toString()
            character.specialSkill = editSpecialSkillText.editText?.text.toString()
            character.appearance = editAppearanceText.editText?.text.toString()
            character.upbring = editUpbringText.editText?.text.toString()
            character.scene = editSceneText.editText?.text.toString()
            character.remark = editRemarkText.editText?.text.toString()
            character.write = editWriteText.editText?.text.toString()
            character.other = editOtherText.editText?.text.toString()

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