package com.eloix.fgoplanner.repository

import com.eloix.fgoplanner.model.*
import java.time.LocalDate

object BannerRepository {
    private val servants = listOf(
        Servant(
            id = 1,
            name = "Jeanne d’Arc (Archer)",
            rarity = 5,
            classType = ServantClass.ARCHER,
            isLimited = true,
            releaseDate = "2017-08-09"
        ),
        Servant(
            id = 2,
            name = "Artoria Pendragon (Ruler)",
            rarity = 5,
            classType = ServantClass.RULER,
            isLimited = true
        ),
        Servant(
            id = 3,
            name = "Cu Chulainn",
            rarity = 3,
            classType = ServantClass.LANCER,
            isLimited = false
        )
    )

    private val banners = listOf(
        Banner(
            id = 1,
            name = "Summer 2025",
            type = BannerType.EVENT,
            startDate = LocalDate.of(2025, 8, 15),
            endDate = LocalDate.of(2025, 9, 5),
            featuredServants = listOf(servants[0], servants[1])
        ),
        Banner(
            id = 2,
            name = "Story Gacha",
            type = BannerType.STORY,
            startDate = LocalDate.of(2015, 7, 30),
            endDate = LocalDate.of(2099, 12, 31),
            featuredServants = listOf(servants[2])
        )
    )

    fun getAllBanners(): List<Banner> = banners

    fun getActiveBanners(today: LocalDate = LocalDate.now()): List<Banner> {
        return banners.filter { it.isActive(today) }
    }

    fun getServants(): List<Servant> = servants
}