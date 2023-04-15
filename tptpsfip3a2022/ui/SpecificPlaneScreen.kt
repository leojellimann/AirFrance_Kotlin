package com.shindra.aero.tptpsfip3a2022.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shindra.aero.tptpsfip3a2022.ui.Data.SpecificPlanesInfos
import com.shindra.aero.tptpsfip3a2022.ui.Data.UiResponse
import com.shindra.aero.tptpsfip3a2022.ui.components.SpecPlaneCard
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shindra.aero.tptpsfip3a2022.R
import com.shindra.aero.tptpsfip3a2022.ui.Data.LimitPlanesInfos

@SuppressLint("SuspiciousIndentation")
@Composable
fun SpecificPlaneScreen(viewModel: SpecificPlaneViewModel = viewModel()) {
    val state = viewModel.specPlaneInfoUiResponse.collectAsState().value//Refresh the viewmodel state
    val valueTechnical = viewModel.planeTechnicalUIResponse.collectAsState().value

    if(state is UiResponse.Success<*> && valueTechnical is UiResponse.Success<*>){
        Column(modifier = Modifier.padding(top = 55.dp)) {
            //Header
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.inversePrimary),
            ){
                val dataWeight = (valueTechnical as UiResponse.Success<*>).data
                var emptyMass = (dataWeight as LimitPlanesInfos).emptyMass
                var mtow = dataWeight.mtow
                var mlw = dataWeight.mlw
                Row(
                    modifier = Modifier
                        .padding(4.dp, 12.dp, 4.dp, 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.txt_MTOW))
                    Text(text = "$mtow kg")
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp, 8.dp, 4.dp, 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.txt_MLW))
                    Text(text = "$mlw kg")
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp, 8.dp, 4.dp, 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.txt_current_weight))
                    Text(text = "$emptyMass kg")
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp, 8.dp, 4.dp, 12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = stringResource(id = R.string.txt_allowed_weight))
                    //As I don't update the current weight onboard with the sliders,
                    // I decided to display the allowed weight before adding weight
                    var allowed = mtow - emptyMass
                    Text(text = "$allowed kg")
                }
            }

            //List of sliders
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val dataSlider = (state as UiResponse.Success<*>).data as List<SpecificPlanesInfos>

                val finalDataSlider = dataSlider.filter { it.type != "PLANE" }//Allows to get all the data from JSON but without the object with type Plane
                    finalDataSlider.forEach { data ->
                        SpecPlaneCard(
                            isMandatory = data.isMandatory,
                            leverArm = data.leverArm,
                            maxValue = data.maxValue,
                            minValue = data.minValue,
                            name = data.name,
                            type = data.type,
                            unit = data.unit,
                            value = data.value.toInt()
                        )
                    }
            }
        }
    }
}