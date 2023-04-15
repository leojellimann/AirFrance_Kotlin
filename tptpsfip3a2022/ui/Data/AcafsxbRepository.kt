package com.shindra.aero.tptpsfip3a2022.ui.Data

import AcafsxbDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AcafsxbRepository (private val dataSource: AcafsxbDataSource) {
    fun planesInfo(): Flow<List<PlanesInfos>> = flow {
        //Emit a flow
        //Must return a PlanesInfo object
        emit(
            dataSource.planesInfo().planes?.map { infosPlanes ->
                println(infosPlanes)
                PlanesInfos(
                    immatriculation = infosPlanes.registration.orEmpty(),
                    constructor = infosPlanes.manufacturer.orEmpty(),
                    type = infosPlanes.model.orEmpty(),
                    cost = infosPlanes.hourlyCost ?: 0.0,
                    urlPlane = infosPlanes.image.orEmpty()
                )
            } ?: emptyList()
        )
    }

    fun specificPlanesInfo(registration: String): Flow<List<SpecificPlanesInfos>> = flow {
        emit(
            dataSource.specificPlanesInfo(registration).inputs?.map { specificInfosPlanes ->
                println(specificInfosPlanes)
                SpecificPlanesInfos(
                    isMandatory = specificInfosPlanes.isMandatory ?: false,
                    leverArm = specificInfosPlanes.leverArm ?: 0.0,
                    maxValue = specificInfosPlanes.maxValue ?: 0,
                    minValue = specificInfosPlanes.minValue ?: 0,
                    name = specificInfosPlanes.name.orEmpty(),
                    type = specificInfosPlanes.type.orEmpty(),
                    unit = specificInfosPlanes.unit.orEmpty(),
                    value = specificInfosPlanes.value ?: 0f,
                )
            } ?: emptyList()
        )
    }

    fun limitsPlanesInfo(registration : String) : Flow<LimitPlanesInfos> = flow {
        emit(
            dataSource.limitPlanesInfo(registration).let{
                    limitInfosPlanes ->
                LimitPlanesInfos(
                    emptyMass = limitInfosPlanes.emptyMass ?: 0f,
                    mtow = limitInfosPlanes.mtow ?: 0,
                    mlw = limitInfosPlanes.mlw ?: 0,
                )
            }
        )
    }


}

data class PlanesInfos(
    val immatriculation: String,
    val constructor: String,
    val type: String,
    val cost: Double,
    val urlPlane: String
)

data class SpecificPlanesInfos(
    val isMandatory: Boolean,
    val leverArm: Double,
    val maxValue: Int,
    val minValue: Int,
    val name: String,
    val type: String,
    val unit: String,
    val value: Float
)

data class LimitPlanesInfos(
    val emptyMass: Float,
    val mtow: Int,
    val mlw: Int
)



