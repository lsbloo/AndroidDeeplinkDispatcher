package com.student.journalapp.main.presentation

import com.student.core.presentation.UIAction

sealed class MainUIAction : UIAction {
    data object ShowGenericError : MainUIAction()

}