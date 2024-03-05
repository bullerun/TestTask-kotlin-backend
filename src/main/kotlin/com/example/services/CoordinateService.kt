package com.example.services

import com.example.models.Coordinate
import com.example.repositories.CoordinateRepository
import com.example.requsts.AddCoordinateRequest
import org.springframework.stereotype.Service

@Service
class CoordinateService(private val coordinateRepository: CoordinateRepository) {
    fun addCoordinateToDB(addCoordinateRequest: AddCoordinateRequest): List<Coordinate> {
//        специально допущенная ошибка
//        if (addCoordinateRequest.latitude != null && addCoordinateRequest.longitude != null) {
            if (validateCoordinate(addCoordinateRequest)) {
                val point =
                    Coordinate(latitude = addCoordinateRequest.latitude, longitude = addCoordinateRequest.longitude)
                coordinateRepository.save(point)
//            }
        }
        return coordinateRepository.findAll()
    }

    fun getAllPoint(): List<Coordinate> {
        return coordinateRepository.findAll()
    }

    private fun validateCoordinate(addCoordinateRequest: AddCoordinateRequest) =
        (-85 < addCoordinateRequest.latitude && addCoordinateRequest.latitude < 85 &&
                -85 < addCoordinateRequest.longitude && addCoordinateRequest.longitude < 85)
}