package noflow.logged.api

import retrofit2.Response
import retrofit2.http.GET

interface IBMService {

    @GET("")
    suspend fun getIBM(): Response<String>
}