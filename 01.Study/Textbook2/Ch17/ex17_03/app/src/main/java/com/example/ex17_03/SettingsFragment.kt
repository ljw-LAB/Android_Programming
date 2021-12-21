package com.example.ex17_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragment
import androidx.preference.PreferenceFragmentCompat

class SettingsFragment :  PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        //setPreferencesFromResource(R.xml.root_preferences, rootKey)
        //setPreferencesFromResource(R.xml.root_preferences_1, rootKey)
        setPreferencesFromResource(R.xml.root_preferences_2, rootKey)

        val idPreference : PreferenceCategory? = findPreference("a")
        idPreference?.setOnPreferenceClickListener {
            setPreferencesFromResource(R.xml.a_preferences, "a1")
            idPreference.isVisible = true
            true
        }
    }
}
