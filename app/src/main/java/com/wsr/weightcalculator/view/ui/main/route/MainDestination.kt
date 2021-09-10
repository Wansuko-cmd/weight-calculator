package com.wsr.weightcalculator.view.ui.main.route

import java.lang.IllegalArgumentException

enum class MainDestination{
    INDEX,
    CONTENT;

    companion object{
        fun fromRoute(route: String?): MainDestination =
            when(route?.substringBefore("/")){
                INDEX.name -> INDEX
                CONTENT.name -> CONTENT
                null -> INDEX
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}