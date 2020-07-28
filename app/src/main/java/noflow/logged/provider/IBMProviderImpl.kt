package noflow.logged.provider

import noflow.Extensions.toMd5
import noflow.logged.retrofit.IBMRetrofit
import java.text.SimpleDateFormat
import java.util.*


class IBMProviderImpl(service: IBMRetrofit) : IBMProvider {

    private val retrofit = service.getInstance()
    private var publicKey = "88ee39d74c2dc934562fbf52241c68e2"
    private var privateKey = "dcbf6d23d351ba771d17ca2b52c9b12944047bdb"
    private var timeStamp: String =
        SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    private var hash = (timeStamp.plus(privateKey).plus(publicKey)).toMd5()

}

