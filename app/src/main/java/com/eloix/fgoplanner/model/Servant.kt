package com.eloix.fgoplanner.model

data class Servant(
    val id: Int,
    val name: String,
    val rarity: Int, // 0★ a 5★
    val classType: ServantClass,
    val isLimited: Boolean = false,
    val releaseDate: String? = null
)

enum class ServantClass {
    SABER,
    ARCHER,
    LANCER,
    RIDER,
    CASTER,
    ASSASSIN,
    BERSERKER,
    RULER,
    AVENGER,
    MOONCANCER,
    ALTEREGO,
    FOREIGNER,
    SHIELDER,
    BEAST,
    UNBEAST
}