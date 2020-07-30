package noflow.logged.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.Fragment
import com.br.noflow.R
import kotlinx.android.synthetic.main.fragment_main_logged.*
import noflow.logged.adapter.EstablishmentAdapter
import noflow.logged.adapter.EstablishmentItem
import noflow.logged.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var adapter: EstablishmentAdapter

    private var establishments = listOf(
        EstablishmentItem(
            name = "Guaco-o Cambuí",
            address = "Rua lá, nº 123",
            category = "Restaurante",
            open = true
        ),
        EstablishmentItem(
            name = "Lado B",
            address = "Rua Teste, nº 123",
            category = "Bar",
            open = false
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_logged, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter =
            EstablishmentAdapter(establishments.toMutableList()) {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        establishmentList.adapter = adapter

        clickCheckBox()
    }

    private fun clickCheckBox() {
        checkBoxBar.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(establishments.filter {
                    it.category == BAR
                }.toMutableList())

                establishments
            } else {
                adapter.swap(establishments.toMutableList())
            }
        }

        checkBoxRestaurant.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(establishments.filter {
                    it.category == RESTAURANT
                }.toMutableList())
            } else {
                adapter.swap(establishments.toMutableList())
            }
        }
    }

    companion object {
        const val BAR = "Bar"
        const val RESTAURANT = "Restaurante"
        const val PARK = "Parques"
        const val SERVICE = "Serviços"
        const val DROGARY = "Drogarias"
    }
}