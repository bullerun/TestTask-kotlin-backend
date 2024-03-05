package com.example.models

import jakarta.persistence.*
import lombok.Data
import lombok.NoArgsConstructor
import java.io.Serializable


@Data
@NoArgsConstructor
@Entity
@Table(name = "coordinate")
class Coordinate(
    @field:Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinate_id_seq")
    @SequenceGenerator(name = "coordinate_id_seq", sequenceName = "coordinate_id_seq", allocationSize = 1)
    private var id: Long? = null,

    @Column(name = "latitude", nullable = false)
    private var latitude: Float,

    @Column(name = "longitude", nullable = false)
    private var longitude: Float,

    ) : Serializable {
    constructor() : this(null, 0.0f, 0.0f)

    fun getId(): Long? {
        return id
    }

    fun getLatitude(): Float {
        return latitude
    }

    fun getLongitude(): Float {
        return longitude
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun setLatitude(latitude: Float) {
        this.latitude = latitude
    }

    fun setLongitude(longitude: Float) {
        this.longitude = longitude
    }

}
