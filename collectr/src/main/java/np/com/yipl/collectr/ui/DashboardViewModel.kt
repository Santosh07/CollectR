package np.com.yipl.collectr.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import np.com.yipl.collectr.CollectRSharedPreference

class DashboardViewModel(application: Application): ViewModel() {

    val pref = CollectRSharedPreference(application)
}