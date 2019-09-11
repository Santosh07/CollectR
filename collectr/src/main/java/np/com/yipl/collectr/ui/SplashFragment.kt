package np.com.yipl.collectr.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.android.synthetic.main.fragment_splash.view.*

import np.com.yipl.collectr.R

//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {
    //private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        view.yi_btn_connect_to_server.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

        return view

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                SplashFragment().apply {
                    arguments = Bundle().apply {
                        //putString(ARG_PARAM2, param2)
                    }
                }
    }
}
