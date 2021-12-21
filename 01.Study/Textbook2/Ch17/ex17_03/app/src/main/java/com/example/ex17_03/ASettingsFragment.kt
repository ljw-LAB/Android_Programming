package com.example.ex17_03

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class ASettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.a_preferences, rootKey)
    }
}