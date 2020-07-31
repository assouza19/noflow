package noflow.logged.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IBMResponse(
    @Json(name = "fields") val fields: List<String> = listOf(),
    @Json(name = "values") val values: List<List<Int>> = listOf()
)