package app.takizawa.lei.charactermemo2

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmMemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //realmの初期化設定
        Realm.init(this)
        //開発の効率化　更新をする
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}