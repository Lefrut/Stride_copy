package com.application.start

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.application.resources.R
import com.application.start.model.mvi.StartState
import com.application.ui.components.IntroPage

@Composable
fun StartScreen(
    viewState: StartState,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    if (viewState == StartState.Success) {
        IntroPage(
            text = stringResource(R.string.start_screen_text),
            buttonText = stringResource(R.string.login),
            onButtonClick = onLoginClick,
            labelButtonText = stringResource(R.string.register),
            onLabelButtonClick = onRegisterClick
        )
    }
}