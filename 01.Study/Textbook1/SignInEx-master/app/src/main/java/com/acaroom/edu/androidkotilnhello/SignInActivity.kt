package com.acaroom.edu.androidkotilnhello

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.acaroom.edu.androidkotilnhello.bl.ISignInBL
import com.acaroom.edu.androidkotilnhello.bl.SignInBL
import com.acaroom.edu.androidkotilnhello.model.AuthCredentials
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class SignInActivity: AppCompatActivity() {

    private val signInBL: ISignInBL = SignInBL()
    private lateinit var view: SignInView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = SignInView()
        view.setContentView(this)
    }

    fun authorizeUser(username: String, password: String) {
        doAsync {
            val authorized = signInBL.checkUserCredentials(
                    AuthCredentials(username = username, password = password))
            activityUiThread {
                if (authorized) {
                    toast("Signed!!!")
                } else {
                    view.showAccessDeniedAlertDialog()
                }
            }
        }
    }
}