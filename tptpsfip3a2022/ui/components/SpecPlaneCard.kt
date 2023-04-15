package com.shindra.aero.tptpsfip3a2022.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shindra.aero.tptpsfip3a2022.R
import com.shindra.aero.tptpsfip3a2022.ui.SpecificPlaneViewModel
import com.shindra.aero.tptpsfip3a2022.ui.theme.TpTpsFip3A2022Theme

@Composable
fun SpecPlaneCard(isMandatory: Boolean, leverArm: Double, maxValue: Int, minValue: Int, name: String, type: String, unit: String, value: Int){

    //Column for list of sliders
    Column(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
    )
    {

        Text(text = "$name")
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imageType = ImageType(type)
            Image(painter = imageType, contentDescription = null, )
            var sliderValue by remember { mutableStateOf(minValue.toFloat()) }
            Row(modifier = Modifier.weight(1f)) {
                Slider(value = sliderValue, onValueChange = { sliderValue = it }, valueRange = minValue.toFloat()..maxValue.toFloat() )
               }
            Text("${String.format("%.0f", sliderValue)}")
            Text("$unit")
        }
    }


}

@Composable
fun ImageType(type: String) : Painter{
    return painterResource( when(type){
        "CARGO" ->  R.drawable.ic_outline_luggage_24
        "FUEL" ->  R.drawable.ic_outline_local_gas_station_24
        "PASSENGER" -> R.drawable.ic_outline_groups_24
        else -> R.drawable.ic_baseline_person_outline_24
    })
}