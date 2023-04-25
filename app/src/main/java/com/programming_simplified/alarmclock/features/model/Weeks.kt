package com.programming_simplified.alarmclock.features.model

data class Weeks(
    val shortName: Char, val idx : Int, val fullName: String
)

val listOfWeeks = listOf(
    Weeks(
        'S', 1,"Sunday"
    ),
    Weeks(
        'M', 2,"Monday"
    ),
    Weeks(
        'T',3, "Tuesday"
    ),
    Weeks(
        'W',4, "Wednesday"
    ),
    Weeks(
        'T', 5,"Thursday"
    ),
    Weeks(
        'F', 6,"Friday"
    ),
    Weeks(
        'S', 7 ,"Saturday"
    ),
)