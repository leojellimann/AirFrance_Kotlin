package com.shindra.aero.tptpsfip3a2022.Data.NetworkData

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLimitPlane(
    @SerialName("mtwo")
    val mtow : Int? = null,
    val mlw : Int? = null,
    val emptyMass : Float? = null,
)

