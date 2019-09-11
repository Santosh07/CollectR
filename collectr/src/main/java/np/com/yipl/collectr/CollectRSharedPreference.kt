package np.com.yipl.collectr

import android.app.Application
import android.content.Context

private const val PREF_KEY = "np.com.yipl.collectr.PREFERENCE_FILE_KEY"

class CollectRSharedPreference(
        application: Application ) {

    val USERLOGGEDINKEY = "YI_USERLOGGEDINKEY"

    val sharedPref = application.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)

    var isUserLoggedIn: Boolean
        get() {
            return sharedPref?.getBoolean(USERLOGGEDINKEY, false) ?: false
        }
        set(value) {
            val editor = sharedPref.edit()
            editor.putBoolean(USERLOGGEDINKEY, value)
            editor.apply()
        }
}