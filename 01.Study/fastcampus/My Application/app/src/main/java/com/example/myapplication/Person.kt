package com.example.myapplication

import java.io.Serializable

class PersonFromServer(
        val id : Int? = null,
        var name : String? = null,
        var age : Int? = null,
        var intro : String? = null
) : Serializable