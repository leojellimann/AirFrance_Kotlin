package com.shindra.aero.tptpsfip3a2022.ui.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSpecificPlaneInfo(
    val isMandatory: Boolean? = null,
    @SerialName("lever_arm")
    val leverArm: Double? = null,
    @SerialName("max_value")
    val maxValue: Int? = null,
    @SerialName("min_value")
    val minValue: Int? = null,
    val name: String? = null,
    val type: String? = null,
    val unit: String? = null,
    val value: Float? = null
)