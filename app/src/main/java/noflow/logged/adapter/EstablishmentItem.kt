package noflow.logged.adapter

import java.io.Serializable

interface Establishment : Serializable

data class EstablishmentItem(
    val name: String,
    val address: String,
    val category: String,
    val open: Boolean,
    val allowArrow: Boolean = true,
    val capacity: Int
) : Establishment