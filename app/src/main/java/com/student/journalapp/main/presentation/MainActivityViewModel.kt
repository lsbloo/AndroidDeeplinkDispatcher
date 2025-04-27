package com.student.journalapp.main.presentation

import com.student.core.BaseViewModel
import com.student.journalapp.main.domain.usecase.RecoveryAllDeepLinksUseCase

class MainActivityViewModel(
    private val recoveryAllDeepLinksUseCase: RecoveryAllDeepLinksUseCase
) : BaseViewModel<MainUIState, MainUIAction>(MainUIState()) {


    fun onViewCreated() {

       // sendAction {
       //     MainUIAction.ShowPage
        // }
    }

}