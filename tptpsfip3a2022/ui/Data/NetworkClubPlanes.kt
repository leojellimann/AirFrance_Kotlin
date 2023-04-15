package com.shindra.aero.tptpsfip3a2022.ui.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Objects

@Serializable
data class NetworkClubPlanes(
    val planes: List<NetworkPlaneInfo>? = null
)
