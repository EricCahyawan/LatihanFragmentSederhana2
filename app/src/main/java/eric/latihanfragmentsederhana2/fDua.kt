package eric.latihanfragmentsederhana2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fDua.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_DEFAULT_NUMBER = "defaultNumber"

class fDua : Fragment() {
    private var defaultNumber: Int = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            defaultNumber = it.getInt(ARG_DEFAULT_NUMBER, 99)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_f_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val _textView2 = view.findViewById<TextView>(R.id.textView2) // Assumes a TextView with this ID
        _textView2.text = "$defaultNumber"
    }

    companion object {
        fun newInstance(defaultNumber: Int) = fDua().apply {
            arguments = Bundle().apply {
                putInt(ARG_DEFAULT_NUMBER, defaultNumber)
            }
        }
    }
}