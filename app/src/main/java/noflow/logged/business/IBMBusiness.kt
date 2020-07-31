package noflow.logged.business

import noflow.logged.model.IBMREquest
import noflow.logged.model.IBMResponse

interface IBMBusiness {

    suspend fun getBestHour(data: IBMREquest) : IBMResponse
}