package noflow.logged.api

import noflow.logged.model.IBMResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IBMService {

    @Headers("Content-Type: application/json")
    @GET("")
    suspend fun getBestHour(
        @Query("token") token: String

    ): Response<IBMResponse>
}