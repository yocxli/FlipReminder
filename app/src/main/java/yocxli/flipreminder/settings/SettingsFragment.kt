package yocxli.flipreminder.settings


import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import yocxli.flipreminder.BuildConfig

import yocxli.flipreminder.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val appVersion: Preference? = preferenceScreen.findPreference("app_version")
        appVersion?.summary = BuildConfig.VERSION_NAME
    }


}
