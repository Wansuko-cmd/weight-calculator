package com.wsr.weightcalculator.view.ui.main.route.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainContent(titleId: Int){
    Scaffold(
        topBar = { MainContentTopBar() }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "MainContents #$titleId")
        }
    }
}
