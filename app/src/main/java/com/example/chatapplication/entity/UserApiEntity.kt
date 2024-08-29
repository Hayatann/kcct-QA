package com.example.chatapplication.entity

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class UserApiEntity(
    val id: Int,
    val name: String,
)



fun List<UserApiEntity>.convertUIData(): ArrayList<UserData> {
    val userList = arrayListOf<UserData>()
    this.forEach {
        userList.add(
            UserData(
                id = it.id,
                name = it.name,
            )
        )
    }
    return userList
}
