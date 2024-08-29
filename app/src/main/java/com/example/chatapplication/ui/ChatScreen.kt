package com.example.chatapplication.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapplication.R
import com.example.chatapplication.entity.ChatApiEntity
import com.example.chatapplication.entity.ChatData
import com.example.chatapplication.entity.UserData
import com.example.chatapplication.entity.sampleUserData
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import kotlinx.coroutines.delay
import java.time.LocalDateTime

@Composable
fun ChatScreen(
    viewModel: SharedViewModel,
    onBackClick: () -> Unit = {},
) {
    val groupId = viewModel.groupId.collectAsState()
    val chatDataList = viewModel.chatList.collectAsState()
    val userDataList = viewModel.userList.collectAsState()

//    val userOptions = sampleUserData.map { it.name }


//    LaunchedEffect(Unit) {
//        while(true) {
//            viewModel.fetchChatList()
//            viewModel.fetchUserList()
//            delay(1000L)
//        }
//    }
    LaunchedEffect(Unit) {
        viewModel.fetchChatList()
        viewModel.fetchUserList()
    }


    Scaffold(
        topBar = {
            Row {
                Button(
                    onClick = onBackClick) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "")
                }
                Button(onClick = {
                    viewModel.fetchChatList()
                    viewModel.fetchUserList()
                }) {
                    Icon(Icons.Filled.Refresh, contentDescription = "")
                }
            }
        },
        bottomBar = {
            SendingTextField(
                viewModel,
                chatDataList.value,
                userDataList.value
            )
        },
    ) { innerPadding ->
        ChatList(
            chatDataList = chatDataList.value.filter { x -> x.groupId == groupId.value }, // viewModelの場合groupId.valueに
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendingTextField(
    viewModel: SharedViewModel,
    chatDataList: ArrayList<ChatData> = arrayListOf<ChatData>(),
    userDataList: ArrayList<UserData> = arrayListOf<UserData>(),
) {
    var groupId = viewModel.groupId.collectAsState()
    var text by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedUserName by remember {
        mutableStateOf("")
    }
    var selectedUserId by remember {
        mutableIntStateOf(0)
    }
    LaunchedEffect(selectedUserName) {
        selectedUserId = userDataList.find { it.name == selectedUserName }?.id ?: 0
    }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it },
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = selectedUserName,
                    onValueChange = {},
                    readOnly = true,
                    singleLine = true,
                    label = { Text("ユーザー名") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    userDataList.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option.name, style = MaterialTheme.typography.bodyLarge) },
                            onClick = {
                                selectedUserName = option.name
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }
        TextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue.filter { x -> x != '\n' }
            },
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()){
                            viewModel.postChat(
                                chat = ChatApiEntity(
                                    id = chatDataList.last().id + 1,
                                    groupId = groupId.value,
                                    senderId = selectedUserId,
                                    senderName = selectedUserName,
                                    createdAt = LocalDateTime.now().toString(),
                                    message = text
                                ),
                            )

                            focusManager.clearFocus()
                            text = ""
                        }
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sendicon256x),
                        modifier = Modifier.size(40.dp),
                        contentDescription = "",
                        tint = Color.Unspecified,
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(0.5f.dp, Color.Black))
        )
    }
}



@Preview
@Composable
fun PreviewChatScreen() {
    ChatApplicationTheme {
//        ChatScreen()
    }
}
