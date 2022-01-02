package com.example.ex20_1

import androidx.multidex.MultiDexApplication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MyApplication: MultiDexApplication() {

    companion object {
        lateinit var auth: FirebaseAuth
        var email: String? = null

        lateinit var  db : FirebaseFirestore
        lateinit var storage : FirebaseFirestore

        fun checkAuth(): Boolean{
            val currentUser = auth.currentUser
            return currentUser?.let {
                email = currentUser.email
                if(currentUser.isEmailVerified){
                    true
                }else {
                    false
                }
            } ?: let {
                false
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        auth =  Firebase.auth

        db = FirebaseFirestore.getInstance()
        storage = Firebase.storage
    }
}
