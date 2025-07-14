package org.verb.bodymetrics.home.presentation

sealed interface HomeScreenAction {
    data object OnSelectedMeasuresSaved: HomeScreenAction
}