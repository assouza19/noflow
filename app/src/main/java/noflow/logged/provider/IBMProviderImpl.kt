package noflow.logged.provider

import noflow.logged.model.IBMREquest
import noflow.logged.model.IBMResponse
import noflow.logged.retrofit.IBMRetrofit


class IBMProviderImpl(service: IBMRetrofit) : IBMProvider {

    private val retrofit = service.getInstance()
    private var token = "p-6d5f15bab436d6dfeb638556beb81902fb980e74"
    private val instanceID = "1db72837-63a1-4b95-ba81-995bd96f6b3a"

    override suspend fun getBestHour(data: IBMREquest): IBMResponse {

        return try {
            val call = retrofit.getBestHour(token)
            if(call.isSuccessful) {
                call.body() as IBMResponse
            } else {
               IBMResponse()
            }

        } catch (e: Exception) {
            IBMResponse()
        }
    }


}

