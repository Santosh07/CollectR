package np.com.yipl.collectr.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import np.com.yipl.collectr.R

/**
 * A simple [Fragment] subclass.
 * Use the [FormListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_list, container, false)
    }


    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                FormListFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
