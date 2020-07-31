package noflow.logged.provider

import noflow.logged.model.IBMREquest
import noflow.logged.model.IBMResponse

interface IBMProvider {

    suspend fun getBestHour(data: IBMREquest): IBMResponse
}