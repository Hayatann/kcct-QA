package com.example.chatapplication.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatapplication.api.ApiClientProvider
import com.example.chatapplication.entity.ChatApiEntity
import com.example.chatapplication.entity.ChatData
import com.example.chatapplication.entity.GroupData
import com.example.chatapplication.entity.UserData
import com.example.chatapplication.entity.convertUIData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val apiService = ApiClientProvider.provideApiService
    private val _groupId = MutableStateFlow(0)
    private val _chatList = MutableStateFlow(arrayListOf<ChatData>())
    private val _groupList = MutableStateFlow(arrayListOf<GroupData>())
    private val _userList = MutableStateFlow(arrayListOf<UserData>())

    val groupId get() = _groupId
    val chatList get() = _chatList
    val groupList get() = _groupList
    val userList get() = _userList

    fun setGroupId(groupId: Int) {
        _groupId.value = groupId
    }

    fun fetchChatList() {
        viewModelScope.launch {
            try {
                val res = apiService.fetchChatList(_groupId.value)
                if (res.isSuccessful) {
                    val chatApiEntity = res.body() ?: emptyList()
                    _chatList.value = chatApiEntity.convertUIData()
                }
            } catch (e: Exception) {
                Log.e("SharedViewModel", e.message ?: "")
            }
        }
    }

    fun fetchGroupList() {
        viewModelScope.launch {
            try {
                val res = apiService.fetchGroupList()
                if (res.isSuccessful) {
                    val groupApiEntity = res.body() ?: emptyList()
                    _groupList.value = groupApiEntity.convertUIData()
                }
            } catch (e: Exception) {
                Log.e("SharedViewModel", e.message ?: "")
            }
        }
    }

    fun fetchUserList() {
        viewModelScope.launch {
            try {
                val res = apiService.fetchUsers()
                if (res.isSuccessful) {
                    val userApiEntity = res.body() ?: emptyList()
                    _userList.value = userApiEntity.convertUIData()
                }
            } catch (e: Exception) {
                Log.e("SharedViewModel", e.message ?: "")
            }
        }
    }

    fun postChat(chat: ChatApiEntity) {
        viewModelScope.launch {
            try {
                val res = apiService.postChat(chat)
                if (res.isSuccessful) {
                    println("post successful")
                    fetchChatList()
                } else {
                    println(res)
                }
            } catch (e: Exception) {
                Log.e("SharedViewModel", e.message ?: "")
            }
        }
    }
}
