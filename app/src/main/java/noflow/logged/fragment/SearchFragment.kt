package noflow.logged.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.br.noflow.R
import kotlinx.android.synthetic.main.fragment_search.*
import noflow.logged.adapter.EstablishmentAdapter
import noflow.logged.model.EstablishmentsMocker

class SearchFragment : Fragment() {

    private lateinit var adapter: EstablishmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter =
            EstablishmentAdapter(EstablishmentsMocker().getEstablishments().toMutableList()) {
                Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            }
        resultSearchList.adapter = adapter
    }




}
