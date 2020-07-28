package noflow.logged.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import noflow.logged.api.IBMService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IBMRetrofit {

    private val url = "https://gateway.marvel.com"
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