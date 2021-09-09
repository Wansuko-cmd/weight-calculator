package com.wsr.weightcalculator.view.ui.main.route.contents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainContents(titleId: Int){
    Text(text = "MainContents #$titleId")
}

class MainContentsArguments{
    companion object{
        const val TITLE_ID = "titleId"
    }
}