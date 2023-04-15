package com.shindra.aero.tptpsfip3a2022.ui.Data

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSpecificPlane(
    val inputs: List<NetworkSpecificPlaneInfo>? = null
)
