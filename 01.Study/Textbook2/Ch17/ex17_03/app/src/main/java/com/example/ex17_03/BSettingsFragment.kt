package com.example.ex17_03

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class BSettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.b_preferences, rootKey)
    }
}