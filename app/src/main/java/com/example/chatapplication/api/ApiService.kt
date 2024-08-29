package com.example.chatapplication.api

import com.example.chatapplication.entity.ChatApiEntity
import com.example.chatapplication.entity.ChatData
import com.example.chatapplication.entity.GroupApiEntity
import com.example.chatapplication.entity.GroupData
import com.example.chatapplication.entity.UserApiEntity
import com.example.chatapplication.entity.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("chats")
    suspend fun fetchChatList(@Query("group_id")groupId: Int):Response<List<ChatApiEntity>>

    @GET("groups")
    suspend fun fetchGroupList():Response<List<GroupApiEntity>>

    @GET("users")
    suspend fun fetchUsers():Response<List<UserApiEntity>>

    @POST("chats")
    suspend fun postChat(@Body chat: ChatApiEntity):Response<ChatApiEntity>
}
