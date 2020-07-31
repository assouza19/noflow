package noflow.logged.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import noflow.logged.api.IBMService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IBMRetrofit {

    private val url = "https://us-south.ml.cloud.ibm.com/v3/wml_instances/1db72837-63a1-4b95-ba81-995bd96f6b3a/deployments/492b9b6e-5b2e-46a6-bc0b-c09053fa2748/online"
    private val gson: Gson by lazy { GsonBuilder().create() }

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getInstance(): IBMService = retrofit.create(IBMService::class.java)

}