package np.com.yipl.collectr.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import np.com.yipl.collectr.R


class DownloadedFormsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_downloaded_forms, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DownloadedFormsFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
