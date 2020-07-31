package noflow.logged.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import noflow.Extensions.Event
import noflow.Extensions.triggerEvent
import noflow.logged.business.IBMBusiness
import noflow.logged.model.IBMREquest
import noflow.logged.model.IBMResponse
import kotlin.coroutines.CoroutineContext

const val CATEGORY = "category"
const val ESTABLISHMENT = "loja"

class MainViewModel(
    private val business: IBMBusiness,
    private val dispatcher: CoroutineContext
) : ViewModel() {

    private var internalSuccess = MutableLiveData<Event<IBMResponse>>()
    private var response = IBMResponse()

    fun getBestHour(category: String, establishment: String) {
        val data = IBMREquest(
            listOf(CATEGORY, ESTABLISHMENT), listOf(
                listOf(category, establishment)
            )
        )
        viewModelScope.launch(dispatcher) {
            response = business.getBestHour(data)
            callExecuted()
        }
    }

    private fun callExecuted() {
        internalSuccess.triggerEvent(response)
    }
}