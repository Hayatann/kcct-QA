package com.example.chatapplication.entity

data class UserData(
    val id: Int,
    val name: String,
)

val sampleUserData = listOf(
    UserData(1, "Alice"),
    UserData(2, "Bob"),
    UserData(3, "Charlie"),
    UserData(4, "David"),
    UserData(5, "Eve"),
    UserData(6, "Frank"),
)