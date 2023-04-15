package com.shindra.aero.tptpsfip3a2022.ui.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPlaneInfo(
    @SerialName("hourly_cost")
    val hourlyCost: Double? = null,
    val image: String? = null,
    val manufacturer: String? = null,
    val model: String? = null,
    @SerialName("number_of_seats")
    val numberOfSeats: Int? = null,
    val registration: String? = null,
)
