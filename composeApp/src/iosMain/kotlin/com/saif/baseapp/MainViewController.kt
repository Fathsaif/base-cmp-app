package com.saif.baseapp

import androidx.compose.ui.window.ComposeUIViewController
import com.saif.baseapp.di.KoinInitializerIOS

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializerIOS().init()
    }
) {
    App()
}