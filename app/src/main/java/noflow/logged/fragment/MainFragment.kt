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

    private var establishments = mutableListOf(
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
            EstablishmentAdapter(establishments) {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        establishmentList.adapter = adapter

        clickCheckBox()
    }

    private fun clickCheckBox() {
        checkBoxBar.setOnClickListener { view ->
            if((view as AppCompatCheckBox).isChecked) {
                clearAnotherCheckBox(BAR)
                val b = establishments.filter {
                    it.category == BAR
                }
                adapter.swap(b.toMutableList())
            } else {
                adapter.swap(establishments)
            }
        }

        checkBoxRestaurant.setOnClickListener { view ->
            if((view as AppCompatCheckBox).isChecked) {
                clearAnotherCheckBox(RESTAURANT)
                val rest = establishments.filter {
                    it.category == RESTAURANT
                }
                adapter.swap(rest.toMutableList())
            } else {
                adapter.swap(establishments)
            }
        }
    }

    private fun clearAnotherCheckBox(type: String) {
        when (type) {
            BAR -> {
                checkBoxDrogary.isSelected = false
                checkBoxPark.isSelected = false
                checkBoxRestaurant.isSelected = false
                checkBoxService.isSelected = false
            }
            RESTAURANT -> {
                checkBoxDrogary.isSelected = false
                checkBoxPark.isSelected = false
                checkBoxBar.isSelected = false
                checkBoxService.isSelected = false
            }
        }
    }

    companion object {
        const val BAR = "Bar"
        const val RESTAURANT = "Restaurante"
    }
}