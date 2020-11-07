package com.example.hasscontrolsprovider.network.response

import com.squareup.moshi.JsonClass
import java.time.ZonedDateTime

@JsonClass(generateAdapter = true)
data class HassState(
    val entity_id: String,
    val state: String,
    val attributes: Attributes,
    val last_changed: ZonedDateTime?
) {

    companion object {
        const val STATE_ON = "on"
        const val STATE_OFF = "off"
        const val STATE_UNAVAILABLE = "unavailable"
        const val STATE_NOT_FOUND = "not_found" // Used for leftover UI controls

        fun notFoundState(id: String) = HassState(
            id,
            STATE_NOT_FOUND,
            Attributes(null, null, null, null, null, null, null),
            null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Attributes(
        val friendly_name: String?,
        val brightness: Int?,
        val supported_features: Int?,
        val color_temp: Int?,
        val min_mireds: Int?,
        val max_mireds: Int?,
        val battery_level: Float?
    )

    val entityType: EntityType = entity_id.toEntityType()
}


enum class EntityType {
    UNKNOWN,
    LIGHT,
    SWITCH,
    VACUUM,
    CAMERA
}

object SupportedLightFeatureFlags {
    const val BRIGHTNESS = 1
    const val COLOR_TEMP = 2
    const val COLOR = 16
    const val WHITE_VALUE = 128 // TODO
}

object SupportedVacuumFeatureFlags {
    const val BATTERY = 64
}

private fun String.toEntityType(): EntityType {
    return when {
        startsWith("light.") -> EntityType.LIGHT
        startsWith("camera.") -> EntityType.CAMERA
        startsWith("vacuum.") -> EntityType.VACUUM
        startsWith("switch.") -> EntityType.SWITCH
        else -> EntityType.UNKNOWN
    }
}