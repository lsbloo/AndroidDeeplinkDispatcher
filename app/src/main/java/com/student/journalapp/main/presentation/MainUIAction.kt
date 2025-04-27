package com.student.journalapp.main.presentation

import com.student.core.UIAction

sealed class MainUIAction : UIAction {
    object ShowPage : MainUIAction()
}