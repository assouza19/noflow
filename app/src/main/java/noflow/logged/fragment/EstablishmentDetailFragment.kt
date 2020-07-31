package noflow.logged.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.br.noflow.R
import kotlinx.android.synthetic.main.fragment_establishment_detail.*
import kotlinx.android.synthetic.main.row_section.*
import kotlinx.android.synthetic.main.schedule_selection.*
import noflow.Extensions.subscribe
import noflow.logged.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val OPEN = "aberto"
private const val CLOSE = "fechado"

class EstablishmentDetailFragment : Fragment() {
    private val args by navArgs<EstablishmentDetailFragmentArgs>()
    private val establishment by lazy { args.establishmentItem }
    private val controller by lazy {
        findNavController()
    }

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_establishment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner()

        establishment?.let {
            name.text = it.name
            address.text = it.address
            category.text = it.category
            state.text = if (it.open) OPEN else CLOSE
        }

        setButtons()
        setCheckBoxClick()
        setViews()
    }

    private fun setViews() {
        establishment?.let { item ->
            if(item.allowArrow && item.open) {
                includeRow.visibility = View.VISIBLE
            } else {
                includeRow.visibility = View.GONE
            }

            if(!item.allowSchedule) {
                groupSchedule.visibility = View.GONE
            }
        }
    }

    private fun setCheckBoxClick() {
        monday.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                numberHour.text = "16"
                groupHour.visibility = View.VISIBLE

            } else {
                groupHour.visibility = View.GONE
            }
        }

        tuesday.setOnClickListener { view ->
            if ((view as AppCompatCheckBox).isChecked) {
                numberHour.text = "13"
                groupHour.visibility = View.VISIBLE

            } else {
                groupHour.visibility = View.GONE
            }
        }
    }

    private fun setButtons() {
        confirmSchedule.setOnClickListener {
            controller.navigate(R.id.action_establishmentDetailFragment_to_scheduleSuccessFragment)
        }

        confirmRow.setOnClickListener {
            controller.navigate(R.id.action_establishmentDetailFragment_to_confirmRowSuccessFragment)
        }
    }

    private fun setSpinner() {
        val hours = resources.getStringArray(R.array.commercial_hours)
        val spinnerAdapter =
            ArrayAdapter(requireContext(), R.layout.spinner_item, hours)

        time.apply {
            adapter = spinnerAdapter

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //Not used
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // A FAZER
                }

            }
        }
    }
}