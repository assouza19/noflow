package noflow.logged.model

import noflow.logged.adapter.EstablishmentItem

class EstablishmentsMocker {

    fun getEstablishments(): List<EstablishmentItem> {
        return listOf(
            EstablishmentItem(
                name = "Guaco-o Cambuí",
                address = "Rua lá, nº 123",
                category = "Restaurante",
                open = true,
                capacity = 20
            ),
            EstablishmentItem(
                name = "Lado B",
                address = "Rua Teste, nº 123",
                category = "Bar",
                open = false,
                capacity = 35
            )
        )
    }
}