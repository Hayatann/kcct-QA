package com.example.chatapplication.entity

import java.time.LocalDateTime

data class GroupData(
    val id: Int,
    val name: String,
    val lastMessage: String,
    val lastMessageTime: LocalDateTime,
)

val groupDataSample= listOf(
    GroupData(1, "メモ帳", "Hello", LocalDateTime.now().minusHours(1)),
    GroupData(2, "Group 2", "Hi", LocalDateTime.now().minusHours(2)),
    GroupData(3, "Group 3", "Hey", LocalDateTime.now().minusDays(1)),
    GroupData(4, "Group 4", "Yo", LocalDateTime.now().minusDays(2)),
    GroupData(5, "Group 5", "Sup", LocalDateTime.now().minusMonths(1)),
    GroupData(6, "Group 6", "What's up", LocalDateTime.now().minusMonths(2)),
    GroupData(7, "Group 7", "Howdy", LocalDateTime.now().minusYears(1)),
    GroupData(8, "Group 8", "Greetings", LocalDateTime.now().minusYears(2)),
    GroupData(9, "Group 9", "Salutations", LocalDateTime.now().minusYears(3)),
    GroupData(10, "Group 10", "Good day", LocalDateTime.now().minusYears(4)),
    GroupData(11, "Group 11", "Good evening", LocalDateTime.now().minusYears(5)),
    GroupData(12, "Group 12", "Good night", LocalDateTime.now().minusYears(6)),
    GroupData(13, "Group 13", "Good morning", LocalDateTime.now().minusYears(7)),
    GroupData(14, "Group 14", "Good afternoon", LocalDateTime.now().minusYears(8)),
    GroupData(15, "Group 15", "Goodbye", LocalDateTime.now().minusYears(9)),
    GroupData(16, "Group 16", "Farewell", LocalDateTime.now().minusYears(10)),
    GroupData(17, "Group 17", "See you later", LocalDateTime.now().minusYears(11)),
    GroupData(18, "Group 18", "Later", LocalDateTime.now().minusYears(12)),
    GroupData(19, "Group 19", "Bye", LocalDateTime.now().minusYears(13)),
    GroupData(20, "Group 20", "Adios", LocalDateTime.now().minusYears(14)),
)
