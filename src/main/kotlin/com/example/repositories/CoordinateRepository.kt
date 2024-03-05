package com.example.repositories

import com.example.models.Coordinate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoordinateRepository : JpaRepository<Coordinate, Long>
