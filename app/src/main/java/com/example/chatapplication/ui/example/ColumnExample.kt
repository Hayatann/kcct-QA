package com.example.chatapplication.ui.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatapplication.R
import com.example.chatapplication.ui.theme.ChatApplicationTheme


@Composable
fun ColumnExample() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "列だよ")
        Image(painter = painterResource(id = R.drawable.ic_group), contentDescription = "")
        Text(text = "列だよ")
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewColumnExample() {
    ChatApplicationTheme {
        ColumnExample()
    }
}