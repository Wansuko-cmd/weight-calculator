package com.wsr.weightcalculator.view.ui.main.route

import java.lang.IllegalArgumentException

enum class MainDestination{
    INDEX,
    SHOW;

    companion object{
        fun fromRoute(route: String?): MainDestination =
            when(route?.substringBefore("/")){
                INDEX.name -> INDEX
                SHOW.name -> SHOW
                null -> INDEX
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}