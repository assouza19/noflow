package noflow.logged.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.noflow.R
import noflow.logged.adapter.EstablishmentItem

private const val ESTABLISHMENT = "establishment"

class EstablishmentDetailFragment : Fragment() {
    private var establishment: EstablishmentItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            establishment = it.get(ESTABLISHMENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_establishment_detail, container, false)
    }

    companion object {
        fun newInstance(item: EstablishmentItem) =
            EstablishmentDetailFragment().apply {
                arguments = Bundle().apply {
                    putBundle(ESTABLISHMENT, item)
                }
            }
    }
}