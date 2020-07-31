package noflow.logged.business

import noflow.logged.model.IBMREquest
import noflow.logged.provider.IBMProvider

class IBMBusinessImpl(private val provider: IBMProvider) : IBMBusiness {

    override suspend fun getBestHour(data: IBMREquest) = provider.getBestHour(data)
}