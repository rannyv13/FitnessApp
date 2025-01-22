package com.example.fitnessapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fitnessapp.R

data class Activities (
    val dayH: Int,
    @StringRes val title: Int,
    @StringRes val desc: Int,
    @DrawableRes val fitIcon: Int,
    val fitTime: Double,
    @StringRes val routes: Int
)

val activities = listOf(
    Activities(1,R.string.title_1,R.string.desc_run,R.drawable.directions_run,1.0,R.string.oval),
    Activities(2,R.string.title_2,R.string.desc_walk,R.drawable.directions_walk,1.0,R.string.altaraza),
    Activities(3,R.string.title_3,R.string.desc_run,R.drawable.directions_run,1.0,R.string.oval),
    Activities(4,R.string.title_4,R.string.desc_run,R.drawable.directions_run,1.0,R.string.oval),
    Activities(5,R.string.title_5,R.string.desc_rest,R.drawable.bed,24.0,R.string.rest),
    Activities(6,R.string.title_6,R.string.desc_run,R.drawable.directions_run,1.0,R.string.oval),
    Activities(7,R.string.title_7,R.string.desc_walk,R.drawable.directions_walk,1.0,R.string.altaraza),
    Activities(8,R.string.title_8,R.string.desc_run,R.drawable.directions_run,1.0,R.string.oval),
    Activities(9,R.string.title_9,R.string.desc_run,R.drawable.directions_run,1.0,R.string.oval),
    Activities(10,R.string.title_10,R.string.desc_rest,R.drawable.bed,24.0,R.string.rest),
    Activities(11,R.string.title_11,R.string.desc_run,R.drawable.directions_run,1.5,R.string.oval),
    Activities(12,R.string.title_12,R.string.desc_walk,R.drawable.directions_walk,1.5,R.string.altaraza),
    Activities(13,R.string.title_13,R.string.desc_run,R.drawable.directions_run,1.5,R.string.oval),
    Activities(14,R.string.title_14,R.string.desc_run,R.drawable.directions_run,1.5,R.string.oval),
    Activities(15,R.string.title_15,R.string.desc_rest,R.drawable.bed,24.0,R.string.rest),
    Activities(16,R.string.title_16,R.string.desc_run,R.drawable.directions_run,2.0,R.string.oval),
    Activities(17,R.string.title_17,R.string.desc_walk,R.drawable.directions_walk,2.0,R.string.altaraza),
    Activities(18,R.string.title_18,R.string.desc_run,R.drawable.directions_run,2.0,R.string.oval),
    Activities(19,R.string.title_19,R.string.desc_run,R.drawable.directions_run,2.0,R.string.oval),
    Activities(20,R.string.title_20,R.string.desc_rest,R.drawable.bed,24.0,R.string.rest),

)