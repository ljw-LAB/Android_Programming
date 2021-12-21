package com.example.ex17_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.preference.PreferenceFragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}