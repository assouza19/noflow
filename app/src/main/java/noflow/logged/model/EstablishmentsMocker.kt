package noflow.logged.model

import noflow.logged.adapter.EstablishmentItem

class EstablishmentsMocker {

    fun getEstablishments(): List<EstablishmentItem> {
        return listOf(
            EstablishmentItem(
                name = "Guaco-o Cambuí",
                address = "Rua Governador Valadares, nº 123",
                category = "Restaurante",
                open = true,
                capacity = 20,
                allowArrow = true
            ),
            EstablishmentItem(
                name = "Lado B",
                address = "Rua Teste, nº 123",
                category = "Bar",
                open = false,
                capacity = 35,
                allowArrow = false
            ),
            EstablishmentItem(
                name = "Praça",
                address = "Rua Marcos Penteado, 235",
                category = "Parque",
                open = true,
                capacity = 35,
                allowArrow = false,
                allowSchedule = false
            ),
            EstablishmentItem(
                name = "Bar & Restaurante 321",
                address = "Rua Carlos Teves, nº 123",
                category = "Bar",
                open = true,
                capacity = 35,
                allowArrow = true
            ),
            EstablishmentItem(
                name = "Drogaria São Paulo",
                address = "Rua Jandira, 453",
                category = "Drogaria",
                open = true,
                capacity = 45,
                allowArrow = true,
                allowSchedule = false
            )
        )
    }
}