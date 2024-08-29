package com.example.chatapplication.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatapplication.entity.GroupData
import com.example.chatapplication.entity.groupDataSample
import com.example.chatapplication.ui.theme.ChatApplicationTheme

@Composable
fun GroupList(
    groupDataList: List<GroupData>,
    onGroupClick: (Int) -> Unit = {}
) {
    LazyColumn {
        items(groupDataList) { groupData ->
            GroupRow(
                groupData = groupData,
                onClick = { onGroupClick(groupData.id) }
            )
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
fun PreviewGroupList() {
    ChatApplicationTheme {
        GroupList(groupDataList = groupDataSample)
    }
}
