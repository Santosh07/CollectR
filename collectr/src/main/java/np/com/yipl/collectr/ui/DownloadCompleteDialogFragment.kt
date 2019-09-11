package np.com.yipl.collectr.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import np.com.yipl.collectr.R

/**
 * A simple [Fragment] subclass.
 * Use the [DownloadCompleteDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DownloadCompleteDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_download_complete, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DownloadCompleteDialogFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
