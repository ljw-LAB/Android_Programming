package com.acaroom.edu.androidkotilnhello.bl

import com.acaroom.edu.androidkotilnhello.model.AuthCredentials

class SignInBL : ISignInBL {

    override fun checkUserCredentials(credentials: AuthCredentials): Boolean {
        return ("youngdeok".equals(credentials.username) && "asdf".equals(credentials.password))
    }
}