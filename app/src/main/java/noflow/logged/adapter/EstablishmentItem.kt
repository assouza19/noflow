package noflow.logged.adapter

class EstablishmentItem(
    val name: String,
    val address: String,
    val category: String,
    val open: Boolean,
    val allowArrow: Boolean = true,
    val capacity: Int
)