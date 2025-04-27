package com.student.journalapp.main.presentation

import com.student.core.BaseViewModel

class MainActivityViewModel : BaseViewModel<MainUIState, MainUIAction>(MainUIState()) {


    fun onViewCreated() {
        sendAction {
            MainUIAction.ShowPage
        }
    }

}