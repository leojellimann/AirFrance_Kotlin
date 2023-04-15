package com.shindra.aero.tptpsfip3a2022.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.shindra.aero.tptpsfip3a2022.ui.Data.PlanesInfos
import com.shindra.aero.tptpsfip3a2022.ui.Data.UiResponse
import com.shindra.aero.tptpsfip3a2022.ui.components.ImageCDN
import com.shindra.aero.tptpsfip3a2022.ui.components.PlaneCard
import kotlinx.serialization.SerialName

@Composable
fun ClubPlaneScreen(navController: NavController ,viewModel: ClubPlaneViewModel = viewModel()) {
    val state = viewModel.planeInfoUiResponse.collectAsState().value//Refresh the viewmodel state
    println(state)
    if(state is UiResponse.Success<*>){
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(0.dp, 60.dp, 0.dp, 58.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            itemsIndexed((state as  UiResponse.Success<*>).data as List<PlanesInfos>) { _, item ->
                PlaneCard(
                    immatriculation = item.immatriculation,
                    constructor = item.constructor,
                    type = item.type,
                    cost = item.cost,
                    urlPlane = item.urlPlane,
                    navController = navController
                )
            }

        }
    }

}