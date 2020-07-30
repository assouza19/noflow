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
import noflow.logged.model.EstablishmentsMocker
import noflow.logged.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()
    private lateinit var adapter: EstablishmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_logged, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter =
            EstablishmentAdapter(EstablishmentsMocker().getEstablishments().toMutableList()) {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        establishmentList.adapter = adapter

        clickCheckBox()
    }

    private fun clickCheckBox() {
        checkBoxBar.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(EstablishmentsMocker().getEstablishments().filter {
                    it.category == BAR
                }.toMutableList())
            } else {
                adapter.swap(EstablishmentsMocker().getEstablishments().toMutableList())
            }
        }

        checkBoxRestaurant.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(EstablishmentsMocker().getEstablishments().filter {
                    it.category == RESTAURANT
                }.toMutableList())
            } else {
                adapter.swap(EstablishmentsMocker().getEstablishments().toMutableList())
            }
        }

        checkBoxPark.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(EstablishmentsMocker().getEstablishments().filter {
                    it.category == PARK
                }.toMutableList())
            } else {
                adapter.swap(EstablishmentsMocker().getEstablishments().toMutableList())
            }
        }

        checkBoxService.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(EstablishmentsMocker().getEstablishments().filter {
                    it.category == SERVICE
                }.toMutableList())
            } else {
                adapter.swap(EstablishmentsMocker().getEstablishments().toMutableList())
            }
        }

        checkBoxDrogary.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                adapter.swap(EstablishmentsMocker().getEstablishments().filter {
                    it.category == DROGARY
                }.toMutableList())
            } else {
                adapter.swap(EstablishmentsMocker().getEstablishments().toMutableList())
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