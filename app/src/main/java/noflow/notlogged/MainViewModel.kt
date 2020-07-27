package noflow.notlogged

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val sharedPreferences: SharedPreferences
): ViewModel() {

    fun savePreference(key: String, value: Boolean) {
        sharedPreferences.edit().apply {
            putBoolean(key, value)
        }.apply()
    }

    fun getPreference(key: String): Boolean {
       return sharedPreferences.getBoolean(key, false)
    }

    fun verifyRegister(): Boolean {
        TODO("chamada API")
    }
}