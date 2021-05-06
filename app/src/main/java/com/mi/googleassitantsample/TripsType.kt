package com.mi.googleassitantsample


enum class TripsType(val value: String) {
    ONGOING_TRIPS(DeepLink.ONGOING_TRIPS_PATH),
    COMPLETED_TRIPS(DeepLink.COMPLETED_TRIPS_PATH),
    UPCOMING_TRIPS(DeepLink.UPCOMING_TRIPS_PATH);

    companion object {
        fun find(type: String?): TripsType {
            return values().find { it.value.equals(other = type, ignoreCase = true) }
                ?: UPCOMING_TRIPS
        }
    }
}
