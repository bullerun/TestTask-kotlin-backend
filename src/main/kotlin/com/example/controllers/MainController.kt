package com.example.controllers

import com.example.models.Coordinate
import com.example.services.CoordinateService
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.example.requsts.AddCoordinateRequest

@Controller
@RequiredArgsConstructor
class MainController (private val coordinateService: CoordinateService){
    @PostMapping("/add/coordinate")
    fun addPoint(@RequestBody addCoordinateRequest: AddCoordinateRequest): ResponseEntity<List<Coordinate>> {
        return ResponseEntity.ok(coordinateService.addCoordinateToDB(addCoordinateRequest))
    }

    @GetMapping("/get/coordinate")
    fun getAllPoint() :ResponseEntity<List<Coordinate>> {
        return ResponseEntity.ok(coordinateService.getAllPoint())
    }
}