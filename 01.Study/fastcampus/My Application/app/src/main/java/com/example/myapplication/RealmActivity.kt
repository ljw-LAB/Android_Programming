package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config : RealmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded() // 데이터베이스에 변경이 이뤄졌으면 데이베이스를 삭제하겠음
                .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        button_save.setOnClickListener {
            realm.executeTransaction{
                // A테이블에서 데이터를 가져온다 -> 10
                // B테이블에서 데이터를 가져온다 -> 10
                // C테이블에서 데이터를 가져온다 -> 10
                // 조합을 한다
                // D테이블에서 조합을 한다
                with(it.createObject(School::class.java))
                {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }

            }
        }
        button_load.setOnClickListener{
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data : " + data)
            }
        }
        button_delete.setOnClickListener{
            realm.executeTransaction{
                    //it.where(School::class.java).findAll().deleteAllFromRealm()
                    it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }

    }
}