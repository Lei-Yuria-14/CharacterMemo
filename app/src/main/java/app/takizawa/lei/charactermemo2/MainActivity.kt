package app.takizawa.lei.charactermemo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.delete
import java.nio.file.Files.list
import java.util.*

class MainActivity : AppCompatActivity() {

    val imageIds: Array<Int> = arrayOf(
        R.drawable.red,
        R.drawable.yellow,
        R.drawable.orange,
        R.drawable.blue3,
        R.drawable.deepblue,
        R.drawable.green,
        R.drawable.deepgreen,
        R.drawable.purple,
        R.drawable.pink,
        R.drawable.blown,
        R.drawable.black,
        R.drawable.white
    )

    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characterDataList = readAll()

        if(characterDataList.isEmpty()) {
            createData()
        }

        val adapter = RecyclerViewAdapter(this, characterDataList, true)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun createData() {
            for (i in 0..11) {
                create(i, imageIds[i],"Character $i")
            }
    }

    fun create(intId: Int, imageId: Int, characterName: String) {
        realm.executeTransaction {
            val characterData = it.createObject(CharacterData::class.java, UUID.randomUUID().toString())
            characterData.characterImageResource = imageId
            characterData.name = characterName

            characterData.intId = intId
        }
    }

    fun readAll(): RealmResults<CharacterData> {
        return realm.where(CharacterData::class.java).findAll()
    }



}
