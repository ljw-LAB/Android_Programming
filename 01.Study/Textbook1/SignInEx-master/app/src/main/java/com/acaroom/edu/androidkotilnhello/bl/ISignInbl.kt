package com.acaroom.edu.androidkotilnhello.bl

import com.acaroom.edu.androidkotilnhello.model.AuthCredentials

interface ISignInBL {

    fun checkUserCredentials(credentials: AuthCredentials): Boolean

}