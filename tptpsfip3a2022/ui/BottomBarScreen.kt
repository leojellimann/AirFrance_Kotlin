package com.shindra.aero.tptpsfip3a2022.ui

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.shindra.aero.tptpsfip3a2022.R

sealed class BottomBarScreen(
    val route: String,
    val title: String
){
    object Planes: BottomBarScreen(
        route = "planes",
        title= "Nos avions"
        )
    object Weather: BottomBarScreen(
        route = "weather",
        title= "Météo"
        )
}
sealed class Navigation(
    val route: String,
    val title: String,
    var registration: String,
){
    object Specific: Navigation(
        route = "specific",
        title = "Specifique",
        registration = ""
    )
}
