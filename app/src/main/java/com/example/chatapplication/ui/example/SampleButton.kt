package com.example.chatapplication.ui.example

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapplication.ui.theme.ChatApplicationTheme

@Composable
fun SampleButton(modifier: Modifier = Modifier) {
    var isPushed by remember {
        mutableStateOf(false)
    }

    Button(
        modifier = modifier
            .width(400.dp)
            .height(200.dp)
            .systemBarsPadding()
        ,
        onClick = { isPushed = !isPushed }
    ) {
        Text(
            text = if (isPushed) "Pushed" else "not Pushed",
            fontSize = 30.sp,
            color = Color.Red
        )
    }
}

@Preview()
@Composable
fun PreviewSampleButton() {
    ChatApplicationTheme {
        SampleButton()
    }
}
