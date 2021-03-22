package app.takizawa.lei.charactermemo2

import io.realm.FieldAttribute
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*


open class CharacterData(
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    open var intId: Int = 0,

    //MainActivityで表示するデータ
    open var characterImageResource: Int = 0,
    open var name: String = "",
    //MainActivityで表示しないデータ
    open var gender: String = "",
    open var nickname: String = "",
    open var position: String = "",
    open var job: String = "",
    open var bloodType: String = "",
    open var age: String = "",
    open var birthday: String = "",
    open var ability: String = "",
    open var firstPerson: String = "",
    open var favorite: String = "",
    open var height: String = "",
    open var weight: String = "",
    open var voice: String = "",
    open var personality: String = "",
    open var specialSkill: String = "",
    open var appearance: String = "",
    open var upbring: String = "",
    open var scene: String = "",
    open var remark: String = "",
    open var write: String = "",
    open var other: String = ""
) : RealmObject()