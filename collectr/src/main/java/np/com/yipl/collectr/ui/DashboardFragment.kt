package np.com.yipl.collectr.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.yipl.collectr.MyCollect

import np.com.yipl.collectr.R

class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (DashboardViewModel(activity!!.application).pref.isUserLoggedIn) {
            
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DashboardFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
