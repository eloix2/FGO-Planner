package com.eloix.fgoplanner.model

import java.time.LocalDate

data class Banner(
    val id: Int,
    val name: String,
    val type: BannerType,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val featuredServants: List<Servant>
) {
    fun isActive(today: LocalDate = LocalDate.now()): Boolean {
        return (today.isEqual(startDate) || today.isAfter(startDate)) &&
                (today.isEqual(endDate) || today.isBefore(endDate))
    }

    fun daysRemaining(today: LocalDate = LocalDate.now()): Long {
        return if (today.isBefore(endDate)) {
            java.time.temporal.ChronoUnit.DAYS.between(today, endDate)
        } else {
            0
        }
    }
}

enum class BannerType {
    STORY,
    LIMITED,
    EVENT,
    CAMPAIGN
}
