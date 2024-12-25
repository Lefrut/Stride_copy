package com.application.home;

import com.application.common_ui.mvi.MviViewModel
import com.application.home.model.mvi.HomeEffect
import com.application.home.model.mvi.HomeState


class HomeViewModel : MviViewModel<HomeState, HomeEffect>(HomeState.Success()) {


}