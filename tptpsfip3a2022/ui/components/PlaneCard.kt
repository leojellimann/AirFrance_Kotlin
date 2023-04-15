package com.shindra.aero.tptpsfip3a2022.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import com.shindra.aero.tptpsfip3a2022.R
import com.shindra.aero.tptpsfip3a2022.ui.BottomBarScreen
import com.shindra.aero.tptpsfip3a2022.ui.Navigation
import com.shindra.aero.tptpsfip3a2022.ui.theme.TpTpsFip3A2022Theme


@Composable
fun PlaneCard(immatriculation: String, constructor: String, type: String, cost: Double, urlPlane: String, navController: NavController)  {
    OutlinedCard(modifier = Modifier
        .padding(horizontal = 8.dp)
        .fillMaxWidth(),
    )
    {
        ImageCDN(urlPlane = urlPlane)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column {
                Text(text = immatriculation, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                Row {
                    Text(text = constructor, style = MaterialTheme.typography.bodySmall)
                    Text(text = type, style = MaterialTheme.typography.bodySmall)
                }
            }

            Text(text = "${String.format("%.2f", cost)} €/h")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            Button(
                onClick = { navController.navigate(route = Navigation.Specific.route)
                    Navigation.Specific.registration = immatriculation
                          },
                Modifier.padding(end = 8.dp),
            )
            {
                Text(text = stringResource(R.string.btn_masse_centrage))
            }
        }
    }
}

@Composable
fun ImageCDN(urlPlane: String) {
    Surface(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        shape = MaterialTheme.shapes.medium
    )
    {
        SubcomposeAsyncImage(
            model = urlPlane,
            contentDescription = "Image Plane",
            loading = {
                ShimmerSurface(modifier = Modifier)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 0.dp),
            contentScale = ContentScale.Crop,
        )
    }
}